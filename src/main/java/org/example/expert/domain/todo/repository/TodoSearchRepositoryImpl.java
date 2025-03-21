package org.example.expert.domain.todo.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import static org.example.expert.domain.todo.entity.QTodo.todo;
import static org.example.expert.domain.user.entity.QUser.user;

@Repository
@AllArgsConstructor
public class TodoSearchRepositoryImpl implements TodoSearchRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Todo> findByManyOptions(String title, LocalDateTime startDate, LocalDateTime endDate, String nickname, Pageable pageable) {
        return (Page<Todo>) jpaQueryFactory.selectFrom(todo)
                .leftJoin(todo.user, user).fetchJoin()
                .where(
                        (title != null && !title.isEmpty()) ? todo.title.contains(title) : null,
                        (startDate != null && endDate != null) ? todo.createdAt.between(startDate, endDate) : null,
                        (nickname != null && !nickname.isEmpty()) ? user.nickName.contains(nickname) : null
                )
                .orderBy(todo.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }
}
