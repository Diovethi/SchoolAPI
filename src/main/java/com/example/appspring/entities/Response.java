package com.example.appspring.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@SuperBuilder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    protected LocalDateTime timestamp;
    protected int StatusCode;
    protected HttpStatus status;
    protected String reason;
    protected String message;
    protected Map<?,?> data;
}
