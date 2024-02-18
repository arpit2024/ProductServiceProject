package com.example.productserviceproject.repositories;

import com.example.productserviceproject.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//use private entity of this interface in the service class-SelfProductService class
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Override
    List<Category> findAll();
}
