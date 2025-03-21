package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoCustomRepository {

    Todo findByIdWithUser(Long Id);

    //1-3 JPA JPQL
    @Query("SELECT t FROM Todo t LEFT JOIN FETCH t.user u WHERE (:weather IS NULL OR t.weather = :weather) AND (:startDate IS NULL OR t.modifiedAt >= :startDate) AND (:endDate IS NULL OR t.modifiedAt <= :endDate) ORDER BY t.modifiedAt DESC")
    Page<Todo> findByOptions(
            @Param("weather") String weather,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            Pageable pageable
    );
}
