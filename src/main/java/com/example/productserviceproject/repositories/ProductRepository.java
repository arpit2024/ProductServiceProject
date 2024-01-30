package com.example.productserviceproject.repositories;

import com.example.productserviceproject.models.Category;
import com.example.productserviceproject.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByTitleContaining(String word);


    long deleteByTitleIgnoreCase(String title);

    List<Product> findByCategory(Category category);
    //So here we cannot use or search my join type/method

    Optional<Product> findById(Long id);

    Product save(Product product);
    //The return value of the save method is product that is saved(product with id)


}

/*Q)let us say we are given a category id, you have to find the products
whose category id is equal to the given category id.
-> we will do this by two different queries
1)CategoryRepository.findById(id) -> this will give us the category object
2)ProductRepository.findByCategory(category) -> this will give us the list of products

Problem:
But here there is a problem, we are making two different queries to the database
since DB will be hit twice,(Api) will be a bit slow and inefficient

Solution:
JPA provides us with a way to do this in a single query
-> we can go inside Attribute of that Object and then search for the id
ex- List<Products> findByCategory_Id(Long id);
here we get all the attributes of the category_...id,name,created_at,updated_at.....
 */

