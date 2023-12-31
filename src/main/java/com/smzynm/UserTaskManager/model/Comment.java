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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private boolean is_read;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "parent_comment_id", nullable = true)
    private Long parentCommentId;

    @ManyToOne
    @JoinColumn(name = "task_id" , insertable = false, updatable = false)
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false, updatable = false)
    private User user;

    @ManyToOne(optional = true)
    @JoinColumn(name = "parent_comment_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> childComments;
}
