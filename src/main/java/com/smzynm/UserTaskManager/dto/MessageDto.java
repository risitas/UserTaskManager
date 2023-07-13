package com.smzynm.UserTaskManager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class MessageDto<T> {
    private HttpStatus state;
    private boolean error;
    private T reply;
}
