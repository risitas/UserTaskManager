package com.smzynm.UserTaskManager.controller;

import com.smzynm.UserTaskManager.dto.CommentDto;
import com.smzynm.UserTaskManager.dto.MessageDto;
import com.smzynm.UserTaskManager.dto.ResponseDto;
import com.smzynm.UserTaskManager.services.CommentService;
import com.smzynm.UserTaskManager.services.ResponseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/response")
@RequiredArgsConstructor
@Validated
public class ResponseController {

    private final ResponseService responseService;


    @GetMapping()
    public ResponseEntity<MessageDto> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, responseService.findAll()));
    }

    @GetMapping("byId/{id}")
    public ResponseEntity<MessageDto> findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, responseService.findById(id)));
    }


    @PostMapping()
    public ResponseEntity<MessageDto> save(@Valid @RequestBody ResponseDto responseDto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, responseService.save(responseDto)));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<MessageDto> update(@Valid @RequestBody ResponseDto responseDto, @PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, responseService.update(responseDto,id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, responseService.delete(id)));
    }
}
