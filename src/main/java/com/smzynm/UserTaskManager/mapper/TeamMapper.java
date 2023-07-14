package com.smzynm.UserTaskManager.mapper;

import com.smzynm.UserTaskManager.dto.TeamDto;
import com.smzynm.UserTaskManager.model.Team;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "responsible", source = "responsible"),
            @Mapping(target = "description", source = "description")
    })
    TeamDto toTeamDto(Team team);

    List<TeamDto> teamDtos(List<Team> teams);

    @InheritInverseConfiguration
    @Mapping(target = "users", ignore = true)
    Team toTeam(TeamDto teamDto);

    @InheritInverseConfiguration
    @Mapping(target = "users", ignore = true)
    List<Team> teams(List<TeamDto> teamDtos);

}
