package pris.project.airfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pris.project.airfly.entity.Airport;

public interface AirportRepository extends JpaRepository<Airport, Integer>{

}
