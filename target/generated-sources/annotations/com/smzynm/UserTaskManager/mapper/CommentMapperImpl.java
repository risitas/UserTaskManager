package com.smzynm.UserTaskManager.mapper;

import com.smzynm.UserTaskManager.dto.CommentDto;
import com.smzynm.UserTaskManager.model.Comment;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-16T16:25:42-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public CommentDto toCommentDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDto commentDto = new CommentDto();

        commentDto.setText( comment.getText() );
        commentDto.setUserId( comment.getUserId() );
        commentDto.setTaskId( comment.getTaskId() );

        return commentDto;
    }

    @Override
    public List<CommentDto> toCommentDtos(List<Comment> comments) {
        if ( comments == null ) {
            return null;
        }

        List<CommentDto> list = new ArrayList<CommentDto>( comments.size() );
        for ( Comment comment : comments ) {
            list.add( toCommentDto( comment ) );
        }

        return list;
    }

    @Override
    public Comment toComment(CommentDto commentDto) {
        if ( commentDto == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setText( commentDto.getText() );
        comment.setUserId( commentDto.getUserId() );
        comment.setTaskId( commentDto.getTaskId() );

        return comment;
    }

    @Override
    public List<Comment> toComments(List<CommentDto> commentDtos) {
        if ( commentDtos == null ) {
            return null;
        }

        List<Comment> list = new ArrayList<Comment>( commentDtos.size() );
        for ( CommentDto commentDto : commentDtos ) {
            list.add( toComment( commentDto ) );
        }

        return list;
    }
}
