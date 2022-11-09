package com.example.lab3springdata.repo;

import com.example.lab3springdata.model.uni_directional.Category;
import com.example.lab3springdata.model.uni_directional.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

//    List<Product> findAllByCategory(@NonNull Category category);
//    List<Product> findAllByCategoryId(int id);
//    List<Product> findAllByCategoryIdAndIdLessThan(int category_id, int id);

//    List<Product> findAllByCategoryId(int category_id);
//    List<Product> findAllByCategory(Category category);

    List<Product> findAllByPriceGreaterThan(double price);

    List<Product> findAllByCategory_NameAndPriceIsLessThan(String name, double price);

    List<Product> findAllByNameContaining(String name);

    // implement using JPQL


}
