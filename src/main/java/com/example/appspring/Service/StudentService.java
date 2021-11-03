package com.example.appspring.Service;

import com.example.appspring.Exceptions.ApiRequestException;
import com.example.appspring.entities.Student;
import com.example.appspring.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(Long id){
        return studentRepository.findById(id).orElseThrow(() -> new ApiRequestException("Student with id "+id+" does not exist"));
    }

    public Student addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent())
            throw new ApiRequestException("email taken");
        studentRepository.save(student);
        return student;
    }

    public void deleteStudent(Long id) {
    boolean exists = studentRepository.existsById(id);
    if (!exists)
        throw new ApiRequestException("Student with id "+id+" does not exist");
    else
        studentRepository.deleteById(id);

    }

    @Transactional
    public void updateStudentEmailName(Long id, String name, String email) {
        Student student= studentRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Student with id "+id+" does not exist"));
        if(email != null)
            student.setEmail(email);
        if (name != null)
            student.setName(name);

    }
}



