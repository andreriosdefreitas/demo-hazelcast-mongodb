package com.rios.democache.repository;

import com.rios.democache.model.Student;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
    
}