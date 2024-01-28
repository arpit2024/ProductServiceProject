package com.example.productserviceproject.practiceInheritanceMapping.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "joined_table_mentor")
@PrimaryKeyJoinColumn(name="user_id")

//In this particular mentors table, I will have a column called user_id, which acts as both primary & foreign key to the user table
public class Mentor extends User{

    private double AverageRating;
}
