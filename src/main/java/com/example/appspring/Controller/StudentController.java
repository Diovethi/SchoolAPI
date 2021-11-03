package com.example.appspring.Controller;

import com.example.appspring.entities.Response;
import com.example.appspring.entities.Student;
import com.example.appspring.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path= "/student")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<Response> getStudents(){

        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("Students", studentService.getStudents()))
                        .message("List of Students.")
                        .status(HttpStatus.CREATED)
                        .build()
        );

    }

    @GetMapping(path = "/{studentId}")
    public ResponseEntity<Response> getStudent(@PathVariable Long studentId){

        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("Student", studentService.getStudent(studentId)))
                        .message("Student searched successfully.")
                        .status(HttpStatus.CREATED)
                        .build()
        );

    }

    @PostMapping
    public ResponseEntity<Response> registerNewStudent(@RequestBody Student student){
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("Student", studentService.addNewStudent(student)))
                        .message("Student created successfully.")
                        .status(HttpStatus.CREATED)
                        .build()
                );
    }

    @PutMapping(path = "{studentId}")
    public ResponseEntity<Response> updateStudent(@PathVariable Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){

       return  ResponseEntity.ok(
                   Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("Student", studentService.updateStudentEmailName(studentId,name,email)))
                        .message("Student edited successfully.")
                        .status(HttpStatus.OK)
                        .build()
                );

    }

    @DeleteMapping(path="{studentId}")
    public ResponseEntity<Response> deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .message("Student Deleted successfully.")
                        .status(HttpStatus.OK)
                        .build()
        );

    }



}
