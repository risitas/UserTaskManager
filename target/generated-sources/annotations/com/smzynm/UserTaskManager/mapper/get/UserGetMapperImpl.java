package com.smzynm.UserTaskManager.mapper.get;

import com.smzynm.UserTaskManager.dto.get.UserGetDto;
import com.smzynm.UserTaskManager.model.Team;
import com.smzynm.UserTaskManager.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-14T15:37:52-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class UserGetMapperImpl implements UserGetMapper {

    @Override
    public UserGetDto toUserGetDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserGetDto userGetDto = new UserGetDto();

        userGetDto.setIdentification( user.getIdentification() );
        userGetDto.setName( user.getName() );
        userGetDto.setLastName( user.getLastName() );
        userGetDto.setPhoneNumber( user.getPhoneNumber() );
        userGetDto.setEmail( user.getEmail() );
        userGetDto.setNameTeam( userTeamName( user ) );

        return userGetDto;
    }

    @Override
    public List<UserGetDto> toUserGetDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserGetDto> list = new ArrayList<UserGetDto>( users.size() );
        for ( User user : users ) {
            list.add( toUserGetDto( user ) );
        }

        return list;
    }

    @Override
    public List<User> toUsers(List<UserGetDto> userGetDtos) {
        if ( userGetDtos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userGetDtos.size() );
        for ( UserGetDto userGetDto : userGetDtos ) {
            list.add( userGetDtoToUser( userGetDto ) );
        }

        return list;
    }

    private String userTeamName(User user) {
        if ( user == null ) {
            return null;
        }
        Team team = user.getTeam();
        if ( team == null ) {
            return null;
        }
        String name = team.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    protected User userGetDtoToUser(UserGetDto userGetDto) {
        if ( userGetDto == null ) {
            return null;
        }

        User user = new User();

        user.setIdentification( userGetDto.getIdentification() );
        user.setName( userGetDto.getName() );
        user.setLastName( userGetDto.getLastName() );
        user.setPhoneNumber( userGetDto.getPhoneNumber() );
        user.setEmail( userGetDto.getEmail() );

        return user;
    }
}
