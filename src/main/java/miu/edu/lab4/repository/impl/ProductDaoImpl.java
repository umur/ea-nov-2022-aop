package miu.edu.lab4.repository.impl;

import miu.edu.lab4.entity.Product;
import miu.edu.lab4.repository.ProductDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private EntityManager entityManager;

    @Override
    public List<Product> findProductsByPriceGreaterThan(Double minPrice) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> productRoot = criteriaQuery.from(Product.class);

        if (minPrice >= 0) {
            Predicate predicate = criteriaBuilder.greaterThan(productRoot.get("price"), minPrice);
            criteriaQuery.where(predicate);

            return entityManager.createQuery(criteriaQuery).getResultList();
        }

        // return all products
        return entityManager.createQuery(criteriaQuery).getResultList();



    }

}
