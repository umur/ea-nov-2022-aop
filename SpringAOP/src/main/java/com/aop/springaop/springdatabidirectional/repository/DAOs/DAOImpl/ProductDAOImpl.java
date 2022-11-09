package com.aop.springaop.springdatabidirectional.repository.DAOs.DAOImpl;//package com.springdata.springdatabidirectional.repository.DAOs.DAOImpl;
//
//import com.springdata.springdatabidirectional.entity.Product;
//import com.springdata.springdatabidirectional.repository.DAOs.ProductDAO;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProductDAOImpl implements ProductDAO {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//    CriteriaQuery<Product> query = cb.createQuery(Product.class);
//    Root<Product> root= query.from(Product.class);
//    List<Predicate> predicates= new ArrayList<Predicate>();
//    @Override
//    public List<Product> findProductsByPriceIsGreaterThan(double minPrice) {
//
//        if(minPrice!=0){
//            predicates.add(cb.greaterThan(root.get("price"), minPrice));
//        }
//
//        query.where(predicates.toArray(new Predicate[0]));
//
//        var result= entityManager.createQuery(query).getResultList();
//
//        return result;
//    }
//
//    @Override
//    public List<Product> findProductsByPriceIsLessThan(double maxPrice) {
//
//        if(maxPrice!=0){
//            predicates.add(cb.lessThan(root.get("price"), maxPrice));
//        }
//        query.where(predicates.toArray(new Predicate[0]));
//
//        var result= entityManager.createQuery(query).getResultList();
//
//        return result;
//    }
//
//    @Override
//    public List<Product> findProductsByNameIsLikeIgnoreCase(String name) {
//        if(name!=null){
//            predicates.add(cb.like(root.get("name"), name));
//        }
//        query.where(predicates.toArray(new Predicate[0]));
//
//        var result= entityManager.createQuery(query).getResultList();
//        return result;
//    }
//}
