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
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable Long studentId){
        return studentService.getStudent(studentId);
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
    public void updateStudent(@PathVariable Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.updateStudentEmailName(studentId,name,email);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);

    }



}
