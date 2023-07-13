package com.smzynm.UserTaskManager.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;


@Data
public class TeamDto {

    @NotBlank(message = "The field name cannot be empty ")
    private String name;

    @NotBlank(message = "The field responsible cannot be empty ")
    private String responsible;
    private String description;
}
