package com.smzynm.UserTaskManager.services.impl;

import com.smzynm.UserTaskManager.dto.CommentDto;
import com.smzynm.UserTaskManager.dto.ResponseDto;
import com.smzynm.UserTaskManager.exception.AttributeException;
import com.smzynm.UserTaskManager.mapper.ResponseMapper;
import com.smzynm.UserTaskManager.model.Comment;
import com.smzynm.UserTaskManager.model.Response;
import com.smzynm.UserTaskManager.repository.ResponseRepository;
import com.smzynm.UserTaskManager.services.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResponseServiceImpl implements ResponseService {

    private final ResponseRepository responseRepository;
    private final ResponseMapper responseMapper;

    @Override
    public List<ResponseDto> findAll() {
        return responseMapper.toResponseDtos((List<Response>) responseRepository.findAll());
    }

    @Override
    public Optional<ResponseDto> findById(Long id) throws Exception {
        Optional<Response> response = responseRepository.findById(id);
        if(response.isEmpty())
            throw new AttributeException("The response with id "+ id + " does not exist");
        return Optional.ofNullable(responseMapper.toResponseDto(response.get()));
    }

    @Override
    public long save(ResponseDto responseDto) throws Exception {
        Response response = responseRepository.save(responseMapper.toResponse(responseDto));
        return response.getId();
    }

    @Override
    public boolean update(ResponseDto responseDto, Long id) throws Exception {
        if(responseRepository.findById(id).isEmpty())
            throw new AttributeException("The response with id " + id + " does not exist");
        Response response  = responseMapper.toResponse(responseDto);
        response.setId(id);

        responseRepository.save(response);
        return true;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        Optional<Response> response = responseRepository.findById(id);
        if(response.isEmpty())
            throw new AttributeException("The response with id "+ id + " does not exist");
        responseRepository.deleteById(id);
        return true;
    }
}
