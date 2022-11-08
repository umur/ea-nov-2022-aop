package miu.edu.ea_day3_crudwithdb.repository;

import miu.edu.ea_day3_crudwithdb.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
    List<Product>  findAllByPriceGreaterThan(Double minPrice);
    List<Product>  findAllByNameContaining(String keyword);
}
