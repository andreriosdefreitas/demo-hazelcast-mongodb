package com.rios.democache.service;

import java.util.List;
import java.util.UUID;

import com.rios.democache.model.Student;
import com.rios.democache.repository.StudentRepository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    private final StudentRepository studentRepository;

    public StudentService(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(final Student student) {
        student.setId(UUID.randomUUID().toString());
        return studentRepository.save(student);
    }

    public Student updateStudent(final Student student) {
        return studentRepository.save(student);
    }

    @Cacheable("students")
    public Student findStudent(final String id) throws NotFoundException {
        return studentRepository.findById(id).orElse(null);
    }

    @Cacheable("books")
    public String getBookNameByIsbn(String isbn) {
        return findBookInSlowSource(isbn);
    }

    private String findBookInSlowSource(String isbn) {
        // some long processing
        sleep();
        return "Sample Book Name";
    }

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String deleteStudent(final String id) {
        studentRepository.deleteById(id);
        return "Student with id: " + id + " deleted successfully";
    }
}