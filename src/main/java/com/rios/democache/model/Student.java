package com.rios.democache.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Student implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    private String id;
    private String name;
    private String grade;
    
}