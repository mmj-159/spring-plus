package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;

public interface TodoCustomRepository {
    //2-8 QueryDSL
    Todo findByIdWithUser(Long id);
}
