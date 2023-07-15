package com.smzynm.UserTaskManager.controller;

import com.smzynm.UserTaskManager.dto.MessageDto;
import com.smzynm.UserTaskManager.dto.MessageRequestDto;
import com.smzynm.UserTaskManager.dto.post.UserPostDto;
import com.smzynm.UserTaskManager.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Validated
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<MessageDto> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, userService.findAll()));
    }

    @GetMapping("byIdentification/{identification}")
    public ResponseEntity<MessageDto> findById(@PathVariable Long identification) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, userService.findByIdentification(identification)));
    }

    @GetMapping("byEmail/{email}")
    public ResponseEntity<MessageDto> findByName(@PathVariable String email) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, userService.findByEmail(email)));
    }

    @PostMapping()
    public ResponseEntity<MessageDto> save(@Valid @RequestBody UserPostDto userPostDto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, userService.save(userPostDto)));

    }

    @PutMapping()
    public ResponseEntity<MessageDto> update(@Valid @RequestBody UserPostDto userPostDto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, userService.update(userPostDto)));
    }

    @DeleteMapping("/{identification}")
    public ResponseEntity<MessageDto> delete(@PathVariable Long identification) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, userService.delete(identification)));
    }
}
