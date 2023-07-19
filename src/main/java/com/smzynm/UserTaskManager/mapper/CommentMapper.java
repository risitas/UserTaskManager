package com.smzynm.UserTaskManager.mapper;

import com.smzynm.UserTaskManager.dto.CommentDto;
import com.smzynm.UserTaskManager.model.Comment;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mappings({
            @Mapping(target = "text",source = "text"),
            @Mapping(target = "userId",source = "userId"),
            @Mapping(target = "taskId",source = "taskId")
    })
    CommentDto toCommentDto(Comment comment);
    List<CommentDto> toCommentDtos(List<Comment> comments);
    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "task", ignore = true)
    @Mapping(target = "childComments", ignore = true)
    @Mapping(target = "parentComment", ignore = true)
    Comment toComment(CommentDto commentDto);
    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "task", ignore = true)
    @Mapping(target = "childComments", ignore = true)
    @Mapping(target = "parentComment", ignore = true)
    List<Comment> toComments(List<CommentDto> commentDtos);


}
