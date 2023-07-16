package com.smzynm.UserTaskManager.mapper;

import com.smzynm.UserTaskManager.dto.ResponseDto;
import com.smzynm.UserTaskManager.model.Response;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResponseMapper {
    @Mappings({
            @Mapping(target = "text",source = "text"),
            @Mapping(target = "commentId",source = "commentId"),
    })
    ResponseDto toResponseDto(Response response);

    List<ResponseDto> toResponseDtos(List<Response> responses);

    @InheritInverseConfiguration
    @Mapping(target = "comment", ignore = true)
    Response toResponse(ResponseDto responseDto);

    List<Response> toResponses(List<ResponseDto> responseDtos);


}
