package com.example.appspring.Controller;

import com.example.appspring.entities.Teacher;
import com.example.appspring.Service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path= "/teacher")
public class TeacherController {

    private final TeacherService teacherService;


    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getTeachers(){
        return teacherService.getTeachers();
    }

    @GetMapping(value="{id}")
    public Teacher getTeacher(@PathVariable Long id){
        return teacherService.getTeacher(id);
    }


    @PostMapping
    public void registerNewTeacher(@RequestBody Teacher teacher){
        teacherService.addNewTeacher(teacher);
    }

    @PutMapping(path = "{teacherId}")
    public void updateStudent(@PathVariable Long teacherId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email,
                              @RequestParam(required = false) String dob){
        teacherService.updateTeacher(teacherId,name,email, LocalDate.parse(dob));
    }

    @DeleteMapping(path="{teacherId}")
    public void deleteStudent(@PathVariable("teacherId") Long teacherId){
        teacherService.deleteTeacher(teacherId);

    }
}
