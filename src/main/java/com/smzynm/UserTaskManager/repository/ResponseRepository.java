package com.smzynm.UserTaskManager.repository;

import com.smzynm.UserTaskManager.model.Response;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends CrudRepository<Response, Long> {
}
