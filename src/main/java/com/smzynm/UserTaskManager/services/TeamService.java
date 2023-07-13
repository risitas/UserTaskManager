package com.smzynm.UserTaskManager.services;

import com.smzynm.UserTaskManager.dto.TeamDto;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    List<TeamDto> findAll();
    Optional<TeamDto> findById(Long id)throws Exception;
    Optional<TeamDto>  findByName(String name)throws Exception;
    List<TeamDto> findAllByResponsible(String responsible)throws Exception;
    boolean save(TeamDto teamDto)throws Exception;
    boolean update(TeamDto teamDto, Long id)throws Exception;
    boolean delete(Long id)throws Exception;
}
