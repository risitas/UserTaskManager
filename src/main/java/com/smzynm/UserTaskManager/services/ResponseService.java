package com.smzynm.UserTaskManager.services;

import com.smzynm.UserTaskManager.dto.CommentDto;
import com.smzynm.UserTaskManager.dto.ResponseDto;

import java.util.List;
import java.util.Optional;

public interface ResponseService {

    List<ResponseDto> findAll();
    Optional<ResponseDto> findById(Long id)throws Exception;
    long save(ResponseDto responseDto)throws Exception;
    boolean update(ResponseDto responseDto, Long id)throws Exception;
    boolean delete(Long id)throws Exception;
}
