package com.example.productserviceproject.practiceInheritanceMapping.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "joined_table_instructor")
@PrimaryKeyJoinColumn(name="user_id")
//we will have an additional column called user_id, which acts as both primary & foreign key to the Parent table
public class Instructor extends User{
    private String favoriteStudent;
}
