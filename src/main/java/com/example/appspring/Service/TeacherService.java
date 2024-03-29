package com.example.appspring.Service;

import com.example.appspring.Exceptions.ApiRequestException;
import com.example.appspring.entities.Teacher;
import com.example.appspring.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;


    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }


    public  void addNewTeacher(Teacher teacher) {
        Optional<Teacher> studentOptional = teacherRepository.findTeacherByEmail(teacher.getEmail());
        if (studentOptional.isPresent())
            throw new ApiRequestException("This email alreaady exists.");
        teacherRepository.save(teacher);
    }


    public void deleteTeacher(Long teacherId) {
        boolean exists = teacherRepository.existsById(teacherId);
        if (!exists)
            throw new ApiRequestException("Teacher with id "+teacherId+" does not exist");
        else
            teacherRepository.deleteById(teacherId);

    }

    @Transactional
    public Teacher updateTeacher(Long teacherId, String name, String email, LocalDate dob) {
        Teacher teacher= teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ApiRequestException("Teacher with id "+teacherId+" does not exist"));
        if(email != null)
            teacher.setEmail(email);
        if (name != null)
            teacher.setName(name);
        if(dob != null)
            teacher.setDob(dob);

        return teacher;

    }

    public Teacher getTeacher(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() ->  new ApiRequestException("Teacher with id "+id+"  does not exist"));
    }
}
