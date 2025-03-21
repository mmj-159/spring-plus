package org.example.expert.domain.todo.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.stereotype.Repository;

import static org.example.expert.domain.todo.entity.QTodo.todo;

@Repository
@AllArgsConstructor
public class TodoCustomRepositoryImpl implements TodoCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;
    //2-8 QueryDSL
    @Override
    public Todo findByIdWithUser(Long id) {
        return jpaQueryFactory.selectFrom(todo)
                .leftJoin(todo.user)
                .fetchJoin()
                .where(todo.id.eq(id))
                .fetchOne();
    }
}
