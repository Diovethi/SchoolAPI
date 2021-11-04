package com.example.appspring.Controller.Response;

import com.example.appspring.entities.Student;
import com.example.appspring.entities.Teacher;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherResponse {

    protected LocalDateTime timestamp;
    protected int StatusCode;
    protected HttpStatus status;
    protected String reason;
    protected String message;
    protected List<Teacher> teachers;
    protected Teacher teacher;

}
