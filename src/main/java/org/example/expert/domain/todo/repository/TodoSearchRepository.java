package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface TodoSearchRepository {

    Page<Todo> findByManyOptions(String title, LocalDateTime startDate, LocalDateTime endDate, String nickname, Pageable pageable);
}
