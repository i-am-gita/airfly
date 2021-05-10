package pris.project.airfly.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import pris.project.airfly.entity.Plane;


public interface PlaneRepository extends JpaRepository<Plane, Integer>{
	
}
