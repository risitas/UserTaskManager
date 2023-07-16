package com.smzynm.UserTaskManager.services;


import com.smzynm.UserTaskManager.dto.CommentDto;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<CommentDto> findAll();
    Optional<CommentDto> findById(Long id)throws Exception;
    long save(CommentDto commentDto)throws Exception;
    boolean update(CommentDto commentDto, Long id)throws Exception;
    boolean delete(Long id)throws Exception;

}
