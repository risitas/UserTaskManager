package com.smzynm.UserTaskManager.mapper.get;

import com.smzynm.UserTaskManager.dto.TeamDto;
import com.smzynm.UserTaskManager.dto.get.UserGetDto;
import com.smzynm.UserTaskManager.dto.post.UserPostDto;
import com.smzynm.UserTaskManager.model.Team;
import com.smzynm.UserTaskManager.model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserGetMapper {
    @Mappings({
            @Mapping(target = "identification", source = "identification"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "lastName", source = "lastName"),
            @Mapping(target = "phoneNumber", source = "phoneNumber"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "nameTeam", source = "team.name")
    })
    UserGetDto toUserGetDto(User user);

    List<UserGetDto> toUserGetDtos(List<User> users);

    @InheritInverseConfiguration
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    @Mapping(target = "team", ignore = true)
    List<User> toUsers(List<UserGetDto> userGetDtos);

}
