package com.aop.springaop.springdatabidirectional.repository.DAOs.DAOImpl;//package com.springdata.springdatabidirectional.repository.DAOs.DAOImpl;
//
//import com.springdata.springdatabidirectional.entity.Product;
//import com.springdata.springdatabidirectional.entity.Review;
//import com.springdata.springdatabidirectional.repository.DAOs.ReviewDAO;
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
//public class ReviewDAOImpl implements ReviewDAO {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<Review> findReviewByIdIs(Long id) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Review> query = cb.createQuery(Review.class);
//        Root<Review> root = query.from(Review.class);
//        List<Predicate> predicates = new ArrayList<Predicate>();
//        if (id != 0) {
//            predicates.add(cb.equal(root.get("id"), id));
//        }
//        query.where(predicates.toArray(new Predicate[0]));
//        var result = entityManager.createQuery(query).getResultList();
//        return result;
//    }
//}
