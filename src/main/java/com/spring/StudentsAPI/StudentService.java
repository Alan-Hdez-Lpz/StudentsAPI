package com.spring.StudentsAPI;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Student createStudent(Student student) {
        return repository.save(student);
    }

    // READ
    public Iterable<Student> getAllStudents() {
        return repository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    // UPDATE
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student " + id + " not found"));

        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setAge(studentDetails.getAge());

        return repository.save(student);
    }

    // DELETE
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
