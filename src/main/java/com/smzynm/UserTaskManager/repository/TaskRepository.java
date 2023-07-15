package com.smzynm.UserTaskManager.repository;

import com.smzynm.UserTaskManager.dto.TaskDto;
import com.smzynm.UserTaskManager.model.Task;
import com.smzynm.UserTaskManager.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    Optional<Task> findByName(String name);
    List<Task> findByStatus(String status);
    List<Task> findByStartDateBetween(LocalDate startDate, LocalDate endDate);

    List<Task> findAllByUserId(Long userId );
}
