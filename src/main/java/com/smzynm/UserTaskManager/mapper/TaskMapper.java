package com.smzynm.UserTaskManager.mapper;

import com.smzynm.UserTaskManager.dto.TaskDto;
import com.smzynm.UserTaskManager.dto.TeamDto;
import com.smzynm.UserTaskManager.model.Task;
import com.smzynm.UserTaskManager.model.Team;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mappings({
            @Mapping(target = "id",source = "id"),
            @Mapping(target = "name",source = "name"),
            @Mapping(target = "description",source = "description"),
            @Mapping(target = "startDate",source = "startDate"),
            @Mapping(target = "endDate",source = "endDate"),
            @Mapping(target = "status",source = "status"),
            @Mapping(target = "type",source = "type"),
            @Mapping(target = "userId",source = "userId")
    })
    TaskDto toTaskDto(Task task);

    List<TaskDto> toTaskDtos(List<Task> tasks);

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "comments", ignore = true)
    Task toTask(TaskDto taskDto);

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "comments", ignore = true)
    List<Task> tasks(List<TaskDto> taskDtos);
}
