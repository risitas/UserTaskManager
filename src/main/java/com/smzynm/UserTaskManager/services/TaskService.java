package com.smzynm.UserTaskManager.services;

import com.smzynm.UserTaskManager.dto.TaskDto;
import com.smzynm.UserTaskManager.dto.TeamDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<TaskDto> findAll();
    Optional<TaskDto> findById(Long id)throws Exception;
    Optional<TaskDto>  findByName(String name)throws Exception;
    List<TaskDto>  findByStatus(String status)throws Exception;
    List<TaskDto> findByStartDateAndEndDateBetween(LocalDate startDate, LocalDate endDate)throws Exception;

    List<TaskDto> findAllByUserId(Long userId)throws Exception;
    boolean save(TaskDto taskDto)throws Exception;
    boolean update(TaskDto taskDto)throws Exception;
    boolean delete(Long id)throws Exception;
}
