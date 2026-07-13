package com.axsos.studentroster.services;

import com.axsos.studentroster.models.Dorm;
import com.axsos.studentroster.models.Student;
import com.axsos.studentroster.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAllByOrderByFirstNameAscLastNameAsc();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public Student assignToDorm(Student student, Dorm dorm) {
        student.setDorm(dorm);
        return studentRepository.save(student);
    }

    public Student removeFromDorm(Student student) {
        student.setDorm(null);
        return studentRepository.save(student);
    }
}
