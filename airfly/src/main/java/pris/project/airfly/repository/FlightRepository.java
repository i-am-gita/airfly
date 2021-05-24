package pris.project.airfly.repository;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pris.project.airfly.entity.Flight;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{

	List<Flight> findFlightByTakeoffdate(Date date);
	
	@Query("SELECT f FROM Flight f")
	List<Flight> findAllFlights();
	
	@Query("SELECT f FROM Flight f  WHERE f.destination.airport1.city = :arrival AND f.destination.airport2.city = :departure and f.takeoffdate = :date")
	List<Flight> getFlightByAirportAndDate(@Param("arrival") String arrival, @Param("departure") String departure, @Param("date") Date date);
	
	@Query("SELECT f From Flight f  WHERE (f.destination.airport1.city = :arrival AND f.destination.airport2.city = :departure AND f.takeoffdate = :goingDate) OR"
			+ "(f.destination.airport2.city = :arrival AND f.destination.airport1.city = :departure AND f.takeoffdate = :returnDate) ")
	List<Flight> getFlightByAirportAndDates(@Param("arrival") String arrival, @Param("departure") String departure, @Param("goingDate") Date dateOfDeparture, @Param("returnDate")Date returnDate);


}
