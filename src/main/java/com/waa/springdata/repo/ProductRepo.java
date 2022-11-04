package com.waa.springdata.repo;

import com.waa.springdata.dto.SimpleProductDto;
import com.waa.springdata.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {

    List<Product> findAllByPriceGreaterThan(int price);
    List<Product> findAll();
    List<Product> findByPriceGreaterThan(int minPrice);

    /**
     *
     * The @Query annotation takes precedence over named queries,
     * which are annotated with @NamedQuery or defined in an orm.xml file.
     */
    // usinq JPQL Java Persistence Query Language
    // add nativeQuery = true to use Native SQL instead of JPQL which is default
    @Query(value = "select p from Product p  " +
            "where p.price = ?1 and p.rating = ?2")
    List<Product> findByPriceAndRating(int price, double rating);

    public List<Product> findAllByPriceGreaterThanEqualAndPriceLessThanEqual(int minPrice, int maxPrice);

    @Query(value = "select p from Product p  " +
            "where p.category.name = ?1 and  p.price < ?2")
    List<Product> findByCategoryNameAndPriceLessThan(String categoryName, int maxPrice);

    // using native query, i.e SQL. Removing the Query would also give
    // the same result. It's just b/c Query has higher precedence
    @Query( nativeQuery = true, value = "select * from Product p  " +
            "where p.name like '%'|| ?1||'%'")
    List<Product> findByNameContainingSQL(String keyword);
    // using JPQL
    @Query(value = "select p from Product p  " +
            "where p.name like %?1%")
    List<Product> findByNameContainingJQPL(String keyword);
    // using Naming convention
    List<Product> findByNameContaining(String keyword);
    //using DTO projection
    @Query(value = "select new com.waa.springdata.dto.SimpleProductDto(p.id, p.name, p.price, p.rating, c.id, c.name)  from Product p " +
            "join Category c on c.id = p.category.id")
    List<SimpleProductDto> fetchSimpleProduct();

}
