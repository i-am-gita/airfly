package pris.project.airfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pris.project.airfly.entity.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Integer>{

}
