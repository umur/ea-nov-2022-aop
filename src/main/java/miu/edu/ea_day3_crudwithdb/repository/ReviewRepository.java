package miu.edu.ea_day3_crudwithdb.repository;

import miu.edu.ea_day3_crudwithdb.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
