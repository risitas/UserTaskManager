package com.smzynm.UserTaskManager.mapper;

import com.smzynm.UserTaskManager.dto.TaskDto;
import com.smzynm.UserTaskManager.model.Task;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-16T16:25:41-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDto toTaskDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDto taskDto = new TaskDto();

        taskDto.setId( task.getId() );
        taskDto.setName( task.getName() );
        taskDto.setDescription( task.getDescription() );
        taskDto.setStartDate( task.getStartDate() );
        taskDto.setEndDate( task.getEndDate() );
        taskDto.setStatus( task.getStatus() );
        taskDto.setType( task.getType() );
        taskDto.setUserId( task.getUserId() );

        return taskDto;
    }

    @Override
    public List<TaskDto> toTaskDtos(List<Task> tasks) {
        if ( tasks == null ) {
            return null;
        }

        List<TaskDto> list = new ArrayList<TaskDto>( tasks.size() );
        for ( Task task : tasks ) {
            list.add( toTaskDto( task ) );
        }

        return list;
    }

    @Override
    public Task toTask(TaskDto taskDto) {
        if ( taskDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( taskDto.getId() );
        task.setName( taskDto.getName() );
        task.setDescription( taskDto.getDescription() );
        task.setStartDate( taskDto.getStartDate() );
        task.setEndDate( taskDto.getEndDate() );
        task.setStatus( taskDto.getStatus() );
        task.setType( taskDto.getType() );
        task.setUserId( taskDto.getUserId() );

        return task;
    }

    @Override
    public List<Task> tasks(List<TaskDto> taskDtos) {
        if ( taskDtos == null ) {
            return null;
        }

        List<Task> list = new ArrayList<Task>( taskDtos.size() );
        for ( TaskDto taskDto : taskDtos ) {
            list.add( toTask( taskDto ) );
        }

        return list;
    }
}
