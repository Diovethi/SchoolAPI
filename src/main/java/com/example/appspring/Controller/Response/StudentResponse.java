package com.example.appspring.Controller.Response;

import com.example.appspring.entities.Student;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponse {

    protected LocalDateTime timestamp;
    protected int StatusCode;
    protected HttpStatus status;
    protected String reason;
    protected String message;
    protected List<Student> students;
    protected Student student;

}
