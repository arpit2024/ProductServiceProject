package com.example.productserviceproject.practiceInheritanceMapping.SingleTable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@DiscriminatorValue(value="1")


public class Mentor extends User {

    private double AverageRating;
}
//single table is going to only include those classes who are being annotated as entity
//Here annotating entity doesn't create a table but just ensure that its atributes are present int the table of parent class

//Now entity is done, we need to define the value of discriminator column