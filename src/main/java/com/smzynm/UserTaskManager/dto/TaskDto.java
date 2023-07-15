package com.smzynm.UserTaskManager.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDto{

    @NotNull
    private Long id;
    @NotBlank(message = "The field name cannot be empty ")
    private String name;
    @NotBlank(message = "The field description cannot be empty ")
    private String description;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    @NotBlank(message = "The field status cannot be empty ")
    private String status;
    @NotBlank(message = "The field type cannot be empty ")
    private String type;

    @NotNull
    private Long userId;
}
