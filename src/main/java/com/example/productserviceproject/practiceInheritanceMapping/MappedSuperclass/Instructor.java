package com.example.productserviceproject.practiceInheritanceMapping.MappedSuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_instructor")
//can also be written as @Entity(name="ms_instructor") to change the name of the table in the database
public class Instructor extends User {
//    @Id
//    private Long id;
    private String favoriteStudent;
}
