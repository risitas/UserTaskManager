package com.smzynm.UserTaskManager.repository;

import com.smzynm.UserTaskManager.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

}
