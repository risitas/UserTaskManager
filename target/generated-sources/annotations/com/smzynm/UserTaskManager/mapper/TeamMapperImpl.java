package com.smzynm.UserTaskManager.mapper;

import com.smzynm.UserTaskManager.dto.TeamDto;
import com.smzynm.UserTaskManager.model.Team;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-13T13:39:12-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Override
    public TeamDto toTeamDto(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamDto teamDto = new TeamDto();

        teamDto.setName( team.getName() );
        teamDto.setResponsible( team.getResponsible() );
        teamDto.setDescription( team.getDescription() );

        return teamDto;
    }

    @Override
    public List<TeamDto> teamDtos(List<Team> teams) {
        if ( teams == null ) {
            return null;
        }

        List<TeamDto> list = new ArrayList<TeamDto>( teams.size() );
        for ( Team team : teams ) {
            list.add( toTeamDto( team ) );
        }

        return list;
    }

    @Override
    public Team toTeam(TeamDto teamDto) {
        if ( teamDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setName( teamDto.getName() );
        team.setResponsible( teamDto.getResponsible() );
        team.setDescription( teamDto.getDescription() );

        return team;
    }

    @Override
    public List<Team> teams(List<TeamDto> teamDtos) {
        if ( teamDtos == null ) {
            return null;
        }

        List<Team> list = new ArrayList<Team>( teamDtos.size() );
        for ( TeamDto teamDto : teamDtos ) {
            list.add( toTeam( teamDto ) );
        }

        return list;
    }
}
