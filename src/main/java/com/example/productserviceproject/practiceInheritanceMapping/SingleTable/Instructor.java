package com.example.productserviceproject.practiceInheritanceMapping.SingleTable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//here mentioning the table name within entity doesn't matter as we are using single table
// strategy- it will create a table called user_single_table

@DiscriminatorValue(value="2")

public class Instructor extends User {
    private String favoriteStudent;
}
