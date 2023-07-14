package com.smzynm.UserTaskManager.mapper.post;

import com.smzynm.UserTaskManager.dto.post.UserPostDto;
import com.smzynm.UserTaskManager.model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface UserPostMapper {
    @Mappings({
            @Mapping(target = "identification", source = "identification"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "lastName", source = "lastName"),
            @Mapping(target = "phoneNumber", source = "phoneNumber"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "password", source = "password"),
            @Mapping(target = "imageUrl", source = "imageUrl"),
            @Mapping(target = "teamId", source = "teamId")
    })
    UserPostDto toUserPostDto(User user);

    @InheritInverseConfiguration
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    @Mapping(target = "team", ignore = true)
    User toUser(UserPostDto userPostDto);

}
