package com.smzynm.UserTaskManager.controller;

import com.smzynm.UserTaskManager.dto.MessageDto;
import com.smzynm.UserTaskManager.dto.MessageRequestDto;
import com.smzynm.UserTaskManager.dto.post.EmailPostDto;
import com.smzynm.UserTaskManager.dto.post.UserPostDto;
import com.smzynm.UserTaskManager.services.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
@Validated
public class EmailController {

    private final EmailService emailService;

    @PostMapping()
    public ResponseEntity<MessageDto> sendEmail(@Valid @RequestBody EmailPostDto emailPostDto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, emailService.sendEmail(emailPostDto)));

    }

}
