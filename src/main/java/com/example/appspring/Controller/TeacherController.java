package com.example.appspring.Controller;

import com.example.appspring.Controller.Response.Response;
import com.example.appspring.Controller.Response.StudentResponse;
import com.example.appspring.Controller.Response.TeacherResponse;
import com.example.appspring.entities.Teacher;
import com.example.appspring.Service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping(path= "/teacher")
public class TeacherController {

    private final TeacherService teacherService;


    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<TeacherResponse> getTeachers(){

        return ResponseEntity.ok(
                TeacherResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .message("List of Students.")
                        .teachers(teacherService.getTeachers())
                        .StatusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping(value="{id}")
    public ResponseEntity<TeacherResponse> getTeacher(@PathVariable Long id){
        return ResponseEntity.ok(
                TeacherResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .message("Teacher searched successfully.")
                        .teacher(teacherService.getTeacher(id))
                        .StatusCode(HttpStatus.OK.value())
                        .build()
        );
    }


    @PostMapping
    public ResponseEntity<TeacherResponse> registerNewTeacher(@RequestBody Teacher teacher){
        teacherService.addNewTeacher(teacher);
        return ResponseEntity.ok(
                TeacherResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .message("Teacher registered successfully.")
                        .teacher(teacher)
                        .StatusCode(HttpStatus.CREATED.value())
                        .build()
        );

    }

    @PutMapping(path = "{teacherId}")
    public ResponseEntity<TeacherResponse> updateStudent(@PathVariable Long teacherId,
                                           @RequestParam(required = false) String name,
                                           @RequestParam(required = false) String email,
                                           @RequestParam(required = false) String dob){
        return ResponseEntity.ok(
                TeacherResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .teacher( teacherService.updateTeacher(teacherId,name,email, LocalDate.parse(dob)))
                        .message("Teacher edited successfully.")
                        .StatusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping(path="{teacherId}")
    public ResponseEntity<TeacherResponse> deleteStudent(@PathVariable("teacherId") Long teacherId){
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.ok(
                TeacherResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .message("Teacher deleted successfully.")
                        .StatusCode(HttpStatus.OK.value())
                        .build()
        );
    }
}
