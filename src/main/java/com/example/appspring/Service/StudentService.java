package com.example.appspring.Service;

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

    public Optional<Student> getStudent(Long id){
        return studentRepository.findById(id);
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent())
            throw new IllegalStateException("email taken");
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
    boolean exists = studentRepository.existsById(studentId);
    if (!exists)
        throw new IllegalStateException("student with id "+studentId+" does not exist");
    else
        studentRepository.deleteById(studentId);

    }

    @Transactional
    public void updateStudentEmailName(Long studentId, String name, String email) {
        Student student= studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student with id "+studentId+" does not exist"));
        if(email != null)
            student.setEmail(email);
        if (name != null)
            student.setName(name);

    }
}



