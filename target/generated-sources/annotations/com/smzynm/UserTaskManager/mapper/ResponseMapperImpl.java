package com.smzynm.UserTaskManager.mapper;

import com.smzynm.UserTaskManager.dto.ResponseDto;
import com.smzynm.UserTaskManager.model.Response;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-16T18:19:14-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class ResponseMapperImpl implements ResponseMapper {

    @Override
    public ResponseDto toResponseDto(Response response) {
        if ( response == null ) {
            return null;
        }

        ResponseDto responseDto = new ResponseDto();

        responseDto.setText( response.getText() );
        responseDto.setCommentId( response.getCommentId() );

        return responseDto;
    }

    @Override
    public List<ResponseDto> toResponseDtos(List<Response> responses) {
        if ( responses == null ) {
            return null;
        }

        List<ResponseDto> list = new ArrayList<ResponseDto>( responses.size() );
        for ( Response response : responses ) {
            list.add( toResponseDto( response ) );
        }

        return list;
    }

    @Override
    public Response toResponse(ResponseDto responseDto) {
        if ( responseDto == null ) {
            return null;
        }

        Response response = new Response();

        response.setText( responseDto.getText() );
        response.setCommentId( responseDto.getCommentId() );

        return response;
    }

    @Override
    public List<Response> toResponses(List<ResponseDto> responseDtos) {
        if ( responseDtos == null ) {
            return null;
        }

        List<Response> list = new ArrayList<Response>( responseDtos.size() );
        for ( ResponseDto responseDto : responseDtos ) {
            list.add( toResponse( responseDto ) );
        }

        return list;
    }
}
