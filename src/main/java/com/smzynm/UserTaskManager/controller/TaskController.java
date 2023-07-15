package com.smzynm.UserTaskManager.controller;

import com.smzynm.UserTaskManager.dto.MessageDto;
import com.smzynm.UserTaskManager.dto.TaskDto;
import com.smzynm.UserTaskManager.services.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
@Validated
public class TaskController {

    private final TaskService taskService;

    @GetMapping()
    public ResponseEntity<MessageDto> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, taskService.findAll()));
    }

    @GetMapping("byId/{id}")
    public ResponseEntity<MessageDto> findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, taskService.findById(id)));
    }

    @GetMapping("byName/{name}")
    public ResponseEntity<MessageDto> findByName(@PathVariable String name) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, taskService.findByName(name)));
    }

    @GetMapping("byStatus/{status}")
    public ResponseEntity<MessageDto> findByStatus(@PathVariable String status) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, taskService.findByStatus(status)));
    }

    @GetMapping("byDate/{startDate}/{endDate}")
    public ResponseEntity<MessageDto> findByStartDateAndEndDateBetween(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, taskService.findByStartDateAndEndDateBetween(startDate,endDate)));
    }

    @GetMapping("byUserId/{userId}")
    public ResponseEntity<MessageDto> findAllByUserId(@PathVariable Long userId) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, taskService.findAllByUserId(userId)));
    }

    @PostMapping()
    public ResponseEntity<MessageDto> save(@Valid @RequestBody TaskDto taskDto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, taskService.save(taskDto)));

    }

    @PutMapping()
    public ResponseEntity<MessageDto> update(@Valid @RequestBody TaskDto taskDto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, taskService.update(taskDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, taskService.delete(id)));
    }
}
