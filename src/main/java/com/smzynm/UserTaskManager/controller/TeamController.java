package com.smzynm.UserTaskManager.controller;

import com.smzynm.UserTaskManager.dto.MessageDto;
import com.smzynm.UserTaskManager.dto.TeamDto;
import com.smzynm.UserTaskManager.services.TeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
@Validated
public class TeamController {
    private final TeamService teamService;

    @GetMapping()
    public ResponseEntity<MessageDto> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, teamService.findAll()));
    }

    @GetMapping("byId/{id}")
    public ResponseEntity<MessageDto> findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, teamService.findById(id)));
    }

    @GetMapping("byName/{name}")
    public ResponseEntity<MessageDto> findByName(@PathVariable String name) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, teamService.findByName(name)));
    }

    @GetMapping("byResponsible/{responsible}")
    public ResponseEntity<MessageDto> findById(@PathVariable String responsible) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, teamService.findAllByResponsible(responsible)));

    }

    @PostMapping()
    public ResponseEntity<MessageDto> save(@Valid @RequestBody TeamDto teamDto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, teamService.save(teamDto)));

    }

    @PutMapping({"/{id}"})
    public ResponseEntity<MessageDto> update(@Valid @RequestBody TeamDto teamDto, @PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, teamService.update(teamDto, id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, teamService.delete(id)));
    }

}
