package com.smzynm.UserTaskManager.services;


import com.smzynm.UserTaskManager.dto.post.EmailPostDto;

public interface EmailService {

    Boolean sendEmail(EmailPostDto emailPostDto) throws Exception;
}
