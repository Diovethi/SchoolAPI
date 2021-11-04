package com.example.appspring.Controller;

import com.example.appspring.Controller.Response.Response;
import com.example.appspring.Controller.Response.StudentResponse;
import com.example.appspring.entities.Student;
import com.example.appspring.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping(path= "/student")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<StudentResponse> getStudents(){

        return ResponseEntity.ok(
                StudentResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .students(studentService.getStudents())
                        .message("List of Students.")
                        .StatusCode(HttpStatus.OK.value())
                        .build()
        );

    }

    @GetMapping(path = "/{studentId}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable Long studentId){

        return ResponseEntity.ok(
                StudentResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .student(studentService.getStudent(studentId))
                        .message("Student searched successfully.")
                        .StatusCode(HttpStatus.OK.value())
                        .build()
        );

    }

    @PostMapping
    public ResponseEntity<StudentResponse> registerNewStudent(@RequestBody Student student){
        return ResponseEntity.ok(
                StudentResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .student(studentService.addNewStudent(student))
                        .message("Student created successfully.")
                        .StatusCode(HttpStatus.OK.value())
                        .build()
                );
    }

    @PutMapping(path = "{studentId}")
    public ResponseEntity<StudentResponse> updateStudent(@PathVariable Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){

       return  ResponseEntity.ok(
               StudentResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .student(studentService.updateStudentEmailName(studentId,name,email))
                        .message("Student edited successfully.")
                        .StatusCode(HttpStatus.OK.value())
                        .build()
                );

    }

    @DeleteMapping(path="{studentId}")
    public ResponseEntity<StudentResponse> deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok(
                StudentResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .message("Student Deleted successfully.")
                        .StatusCode(HttpStatus.OK.value())
                        .build()
        );

    }



}
