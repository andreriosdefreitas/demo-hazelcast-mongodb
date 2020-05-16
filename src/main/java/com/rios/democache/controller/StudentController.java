package com.rios.democache.controller;

import java.util.List;
import java.util.UUID;

import javax.websocket.server.PathParam;

import com.rios.democache.model.Student;
import com.rios.democache.service.StudentService;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = studentService.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findById(@PathVariable String id) throws NotFoundException {
        studentService.getBookNameByIsbn(id);
        return new ResponseEntity<>(studentService.findStudent(id), HttpStatus.OK);
    }
 
    @PostMapping("/student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student s = studentService.saveStudent(student);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }
 
    @PutMapping("/student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student s = studentService.updateStudent(student);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }
 
    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        String message = studentService.deleteStudent(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    
}