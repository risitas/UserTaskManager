package com.smzynm.UserTaskManager.services.impl;

import com.smzynm.UserTaskManager.dto.TeamDto;
import com.smzynm.UserTaskManager.exception.AttributeException;
import com.smzynm.UserTaskManager.mapper.TeamMapper;
import com.smzynm.UserTaskManager.model.Team;
import com.smzynm.UserTaskManager.repository.TeamRepository;
import com.smzynm.UserTaskManager.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    public List<TeamDto> findAll() {
        return teamMapper.teamDtos((List<Team>) teamRepository.findAll());
    }

    @Override
    public Optional<TeamDto> findById(Long id) throws Exception{
        Optional<Team> team = teamRepository.findById(id);
        if(!team.isPresent())
            throw new AttributeException("The team "+ id + " does not exist");
        return Optional.ofNullable(teamMapper.toTeamDto(team.get()));

    }

    @Override
    public Optional<TeamDto>  findByName(String name) throws Exception{
        Optional<Team> team = teamRepository.findByName(name);
        if(!team.isPresent())
            throw new AttributeException("The team "+ name + " does not exist");
        return  Optional.ofNullable(teamMapper.toTeamDto(team.get()));
    }

    @Override
    public List<TeamDto> findAllByResponsible(String responsible) throws Exception{
        return teamMapper.teamDtos(teamRepository.findByResponsible(responsible));
    }

    @Override
    public boolean save(TeamDto teamDto) throws Exception{

        if(isExist(teamDto.getName()))
            throw new AttributeException("The team "+ teamDto.getName() + " already exists");

        teamRepository.save(teamMapper.toTeam(teamDto));
        return true;
    }

    @Override
    public boolean update(TeamDto teamDto, Long id) throws Exception{

        if(!teamRepository.findById(id).isPresent())
            throw new AttributeException("The team " + id + " does not exist");
        Team team = teamMapper.toTeam(teamDto);
        team.setId(id);

        Optional<Team> teamForName = teamRepository.findByName(teamDto.getName());

        if(teamForName.isPresent())
            if(isExist(teamDto.getName()) && (!teamForName.get().getId().equals(id)) )
                throw new AttributeException("The team "+ teamDto.getName() + " already exists");

        teamRepository.save(team);
        return true;
    }

    @Override
    public boolean delete(Long id) throws Exception{
        Optional<Team> team = teamRepository.findById(id);
        if(!team.isPresent())
            throw new AttributeException("The team "+ id + " does not exist");
        teamRepository.deleteById(id);
        return true;
    }

    public boolean isExist(String name) {

        boolean isPresent = teamRepository.findByName(name).isPresent();
        return isPresent ? true:false;
    }
}
