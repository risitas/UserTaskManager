package com.smzynm.UserTaskManager.services.impl;

import com.smzynm.UserTaskManager.dto.CommentDto;
import com.smzynm.UserTaskManager.exception.AttributeException;
import com.smzynm.UserTaskManager.mapper.CommentMapper;
import com.smzynm.UserTaskManager.model.Comment;
import com.smzynm.UserTaskManager.repository.CommentRepository;
import com.smzynm.UserTaskManager.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Override
    public List<CommentDto> findAll() {
        return commentMapper.toCommentDtos((List<Comment>) commentRepository.findAll());
    }

    @Override
    public Optional<CommentDto> findById(Long id) throws Exception {
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isEmpty())
            throw new AttributeException("The comment with id "+ id + " does not exist");
        return Optional.ofNullable(commentMapper.toCommentDto(comment.get()));
    }

    @Override
    public long save(CommentDto commentDto) throws Exception {
        Comment comment = commentRepository.save(commentMapper.toComment(commentDto));
        return comment.getId();
    }

    @Override
    public boolean update(CommentDto commentDto, Long id) throws Exception {
        if(commentRepository.findById(id).isEmpty())
            throw new AttributeException("The comment with id " + id + " does not exist");
        Comment comment = commentMapper.toComment(commentDto);
        comment.setId(id);

        commentRepository.save(comment);
        return true;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isEmpty())
            throw new AttributeException("The comment with id "+ id + " does not exist");
        commentRepository.deleteById(id);
        return true;
    }
}
