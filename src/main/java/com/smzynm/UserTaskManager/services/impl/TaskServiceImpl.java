package com.smzynm.UserTaskManager.services.impl;

import com.smzynm.UserTaskManager.dto.TaskDto;
import com.smzynm.UserTaskManager.exception.AttributeException;
import com.smzynm.UserTaskManager.mapper.TaskMapper;
import com.smzynm.UserTaskManager.model.Task;
import com.smzynm.UserTaskManager.repository.TaskRepository;
import com.smzynm.UserTaskManager.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;


    @Override
    public List<TaskDto> findAll() {
        return taskMapper.toTaskDtos((List<Task>) taskRepository.findAll());
    }

    @Override
    public Optional<TaskDto> findById(Long id) throws Exception {
        Optional<Task> task = taskRepository.findById(id);
        if(!task.isPresent())
            throw new AttributeException("The task with id "+ id + " does not exist");
        return Optional.ofNullable(taskMapper.toTaskDto(task.get()));
    }

    @Override
    public Optional<TaskDto> findByName(String name) throws Exception {
        Optional<Task> task = taskRepository.findByName(name);
        if(!task.isPresent())
            throw new AttributeException("The task with name "+ name + " does not exist");
        return Optional.ofNullable(taskMapper.toTaskDto(task.get()));
    }

    @Override
    public List<TaskDto> findByStatus(String status) throws Exception {
        return taskMapper.toTaskDtos(taskRepository.findByStatus(status));
    }

    @Override
    public List<TaskDto> findByStartDateAndEndDateBetween(LocalDate startDate, LocalDate endDate) throws Exception {
        return taskMapper.toTaskDtos(taskRepository.findByStartDateBetween(startDate,endDate));
    }

    @Override
    public List<TaskDto> findAllByUserId(Long userId) throws Exception {
        return taskMapper.toTaskDtos(taskRepository.findAllByUserId(userId));
    }

    @Override
    public boolean save(TaskDto taskDto) throws Exception {
        if(isExistId(taskDto.getId()) || isExistName(taskDto.getName()) )
            throw new AttributeException("The Task already exists");

        Task task =taskMapper.toTask(taskDto);
        taskRepository.save(task);
        return true;
    }

    @Override
    public boolean update(TaskDto taskDto) throws Exception {
        if(!taskRepository.findById(taskDto.getId()).isPresent())
            throw new AttributeException("The task with id " + taskDto.getId() + " does not exist");
        Task task = taskMapper.toTask(taskDto);


        Optional<Task> taskForName = taskRepository.findByName(taskDto.getName());

        if(taskForName.isPresent())
            if(isExistName(taskDto.getName()) && (!taskForName.get().getId().equals(taskDto.getId())) )
                throw new AttributeException("The task whit name "+ taskDto.getName() + " already exists");

        taskRepository.save(task);
        return true;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        Optional<Task> task = taskRepository.findById(id);
        if(!task.isPresent())
            throw new AttributeException("The task with id "+ id + " does not exist");
        taskRepository.deleteById(id);
        return true;
    }

    public boolean isExistName(String name) {

        boolean isPresent = taskRepository.findByName(name).isPresent();
        return isPresent ? true:false;
    }

    public boolean isExistId(Long id) {

        boolean isPresent = taskRepository.findById(id).isPresent();
        return isPresent ? true: false;
    }
}
