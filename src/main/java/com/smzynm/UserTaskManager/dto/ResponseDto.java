package com.smzynm.UserTaskManager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResponseDto {

    @NotBlank
    private String text;
    @NotNull
    private Long commentId;
}
