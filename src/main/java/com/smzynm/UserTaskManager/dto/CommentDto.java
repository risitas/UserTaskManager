package com.smzynm.UserTaskManager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentDto {

    @NotBlank
    private String text;

    @NotNull
    private Long userId;

    @NotNull
    private Long taskId;
    private Long parentCommentId;
}
