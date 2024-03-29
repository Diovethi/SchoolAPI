package com.example.appspring.repository;


import com.example.appspring.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {



    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

//   @Query("UPDATE Student SET Student.name= name , Student.email=email  WHERE Student.id=id")
//   Optional<Student> updateStudentEmailName(Long id, String name, String email);



}
