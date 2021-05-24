package pris.project.airfly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pris.project.airfly.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{
	
	@Query("SELECT r FROM Review r WHERE r.airline.airlineid=:id")
	List<Review> getAllReviewsForGivenAirlineId(@Param("id") Integer id);
	
}
