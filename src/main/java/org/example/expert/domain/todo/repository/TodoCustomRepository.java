package org.example.expert.domain.todo.repository;

import com.querydsl.jpa.impl.JPAQuery;
import org.example.expert.domain.todo.entity.Todo;

public interface TodoCustomRepository {

    Todo findByIdWithUser(Long id);
}
