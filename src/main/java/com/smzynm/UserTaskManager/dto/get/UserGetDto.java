package com.smzynm.UserTaskManager.dto.get;

import lombok.Data;

@Data
public class UserGetDto {

    private Long identification;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String nameTeam;
}
