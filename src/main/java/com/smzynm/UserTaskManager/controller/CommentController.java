package com.smzynm.UserTaskManager.controller;

import com.smzynm.UserTaskManager.dto.CommentDto;
import com.smzynm.UserTaskManager.dto.MessageDto;
import com.smzynm.UserTaskManager.services.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
@Validated
public class CommentController {

    private final CommentService commentService;

    @GetMapping()
    public ResponseEntity<MessageDto> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, commentService.findAll()));
    }

    @GetMapping("byId/{id}")
    public ResponseEntity<MessageDto> findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, commentService.findById(id)));
    }


    @PostMapping()
    public ResponseEntity<MessageDto> save(@Valid @RequestBody CommentDto commentDto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, commentService.save(commentDto)));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<MessageDto> update(@Valid @RequestBody CommentDto commentDto, @PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, commentService.update(commentDto,id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, commentService.delete(id)));
    }
}
