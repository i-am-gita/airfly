package pris.project.airfly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pris.project.airfly.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer>{
	
	
	@Query("SELECT r FROM Rating r WHERE r.airline.airlineid=:id")
	List<Rating> getRatingForAirlineId(@Param("id") Integer id);
	
	@Query("SELECT r FROM Rating r WHERE r.airline.airlineid=:id AND r.user.userid=:user")
	Rating checkRatingForUser(@Param("id") Integer id, @Param("user") Integer userId);

}
