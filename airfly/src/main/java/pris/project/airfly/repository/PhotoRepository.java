package pris.project.airfly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pris.project.airfly.entity.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer>{
	
	@Query("SELECT p FROM Photo p WHERE p.plane.planeid=:id")
	List<Photo> findPhotosForFlight(@Param("id") Integer id);

}
