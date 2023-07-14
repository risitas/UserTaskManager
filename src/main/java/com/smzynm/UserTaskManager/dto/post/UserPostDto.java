package com.smzynm.UserTaskManager.dto.post;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserPostDto {

    @Min(8)
    private Long identification;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    @Size(min = 8, max = 15, message = "The minimum the phoneNumber is 8 and maximum 15")
    private String phoneNumber;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 15, message = "The minimum the password is 8 and maximum 15")
    private String password;

    private String imageUrl;

    private Long teamId;
}
