package com.smzynm.UserTaskManager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    private Long identification;

    private String name;

    private String lastName;

    private String phoneNumber;

    private String email;

    private String password;

    private String verificationCode;

    private String imageUrl;

    @Column(name = "team_id", nullable = true)
    private Long teamId;

    @ManyToOne(optional = true)
    @JoinColumn(name = "team_id",referencedColumnName = "id", insertable = false, updatable = false)
    private Team team;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;



}
