package com.zazergel.bracketchecker.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ResponseError {
    private String status;
    private String reason;
    private String message;
    private LocalDateTime timestamp;
}
