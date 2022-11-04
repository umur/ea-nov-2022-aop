package miu.edu.lab4.repository;

import miu.edu.lab4.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {

    List<Product> findProductsByPriceGreaterThan(Double minPrice);


}

