package com.smzynm.UserTaskManager.mapper.post;

import com.smzynm.UserTaskManager.dto.post.UserPostDto;
import com.smzynm.UserTaskManager.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-14T18:44:09-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class UserPostMapperImpl implements UserPostMapper {

    @Override
    public UserPostDto toUserPostDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserPostDto userPostDto = new UserPostDto();

        userPostDto.setIdentification( user.getIdentification() );
        userPostDto.setName( user.getName() );
        userPostDto.setLastName( user.getLastName() );
        userPostDto.setPhoneNumber( user.getPhoneNumber() );
        userPostDto.setEmail( user.getEmail() );
        userPostDto.setPassword( user.getPassword() );
        userPostDto.setImageUrl( user.getImageUrl() );
        userPostDto.setTeamId( user.getTeamId() );

        return userPostDto;
    }

    @Override
    public User toUser(UserPostDto userPostDto) {
        if ( userPostDto == null ) {
            return null;
        }

        User user = new User();

        user.setIdentification( userPostDto.getIdentification() );
        user.setName( userPostDto.getName() );
        user.setLastName( userPostDto.getLastName() );
        user.setPhoneNumber( userPostDto.getPhoneNumber() );
        user.setEmail( userPostDto.getEmail() );
        user.setPassword( userPostDto.getPassword() );
        user.setImageUrl( userPostDto.getImageUrl() );
        user.setTeamId( userPostDto.getTeamId() );

        return user;
    }
}
