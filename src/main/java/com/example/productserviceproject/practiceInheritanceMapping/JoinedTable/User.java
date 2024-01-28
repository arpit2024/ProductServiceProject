package com.example.productserviceproject.practiceInheritanceMapping.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;


 @Getter
 @Setter
 @Entity(name = "joined_table_user")

 @Inheritance(strategy = InheritanceType.JOINED)
 //Here instead of Inheritance, we can also use different approach
    //Here we are using Joined Table Approach

public class User {
     @Id
     private Long id;
    private String name;
    private String email;
}
