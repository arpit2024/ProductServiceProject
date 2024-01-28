package com.example.productserviceproject.practiceInheritanceMapping.SingleTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


 @Getter
 @Setter
 @Entity(name = "user_single_table")
 @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
 @DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.INTEGER)

 //here integer in discriminatorType means create a column of type integer called user_type with datatype as integer

 @DiscriminatorValue(value="0")

 public class User {
     @Id
     private Long id;
    private String name;
    private String email;
}
//we will create a table called user_single_table


//By the way, there can be objects of only user they are neither an instructor nor mentor
//in that case we will have a column called user_type with value 0