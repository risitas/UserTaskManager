package com.smzynm.UserTaskManager.services.impl;

import com.smzynm.UserTaskManager.dto.MessageRequestDto;
import com.smzynm.UserTaskManager.dto.get.UserGetDto;
import com.smzynm.UserTaskManager.dto.post.UserPostDto;
import com.smzynm.UserTaskManager.exception.AttributeException;
import com.smzynm.UserTaskManager.mapper.get.UserGetMapper;
import com.smzynm.UserTaskManager.mapper.post.UserPostMapper;
import com.smzynm.UserTaskManager.model.Team;
import com.smzynm.UserTaskManager.model.User;
import com.smzynm.UserTaskManager.repository.UserRepository;
import com.smzynm.UserTaskManager.services.CodeGeneratorService;
import com.smzynm.UserTaskManager.services.MessageService;
import com.smzynm.UserTaskManager.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserPostMapper userPostMapper;
    private final UserGetMapper userGetMapper;

    @Override
    public List<UserGetDto> findAll() {
        return userGetMapper.toUserGetDtos((List<User>) userRepository.findAll());
    }

    @Override
    public Optional<UserGetDto> findByIdentification(Long identification) throws Exception {
        Optional<User> user = userRepository.findById(identification);
        if(!user.isPresent())
            throw new AttributeException("The user with identification "+ identification + " does not exist");
        return Optional.ofNullable(userGetMapper.toUserGetDto(user.get()));
    }

    @Override
    public Optional<UserGetDto> findByEmail(String email) throws Exception {
        Optional<User> user = userRepository.findByEmail(email);
        if(!user.isPresent())
            throw new AttributeException("The user with email "+ email + " does not exist");
        return Optional.ofNullable(userGetMapper.toUserGetDto(user.get()));
    }

    @Override
    public boolean save(UserPostDto userPostDto) throws Exception {

        if(isExist(userPostDto.getIdentification()) || isExistEmail(userPostDto.getEmail()) )
            throw new AttributeException("The User already exists");

        User user =userPostMapper.toUser(userPostDto);
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean update(UserPostDto userPostDto) throws Exception {
        if(!userRepository.findById(userPostDto.getIdentification()).isPresent())
            throw new AttributeException("The with identification " + userPostDto.getIdentification() + " does not exist");
        User user = userPostMapper.toUser(userPostDto);
        user.setIdentification(userPostDto.getIdentification());

        userRepository.save(user);
        return true;
    }

    @Override
    public boolean delete(Long identification) throws Exception {
        Optional<User> user = userRepository.findById(identification);
        if(!user.isPresent())
            throw new AttributeException("The user with identification "+ identification + " does not exist");
        userRepository.deleteById(identification);
        return true;
    }

    public boolean isExist(Long identification) {

        boolean isPresent = userRepository.findById(identification).isPresent();

        return isPresent ? true: false;
    }
    public boolean isExistEmail(String email) {

        boolean isPresent = userRepository.findByEmail(email).isPresent();

        return isPresent ? true: false;
    }
}
