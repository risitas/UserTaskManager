package com.smzynm.UserTaskManager.services;

import com.smzynm.UserTaskManager.dto.TeamDto;
import com.smzynm.UserTaskManager.dto.get.UserGetDto;
import com.smzynm.UserTaskManager.dto.post.UserPostDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserGetDto> findAll();
    Optional<UserGetDto> findByIdentification(Long identification)throws Exception;
    Optional<UserGetDto>  findByEmail(String email)throws Exception;
    boolean save(UserPostDto userPostDto)throws Exception;
    boolean update(UserPostDto userPostDto)throws Exception;
    boolean delete(Long identification)throws Exception;
}
