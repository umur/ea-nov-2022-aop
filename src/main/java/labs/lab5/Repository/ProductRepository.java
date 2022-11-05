package labs.lab5.Repository;

import labs.lab5.Entity.UniProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<UniProduct, String> {
    List<UniProduct> findAll();
    List<UniProduct> findAllByPriceGreaterThan(double minPrice);

    @Query( nativeQuery = true,
            value = "select * from uni_product inner join uni_category on uni_product.category_id=uni_category.id  where uni_category.name=:cat and uni_product.price < :maxPrice"
    )
    List<UniProduct> findAllByCategoryAndAndPriceLessThan(String cat, double maxPrice);
    List<UniProduct> findAllByNameContaining(String keyword);
}
