package pris.project.airfly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pris.project.airfly.entity.Flight;
import pris.project.airfly.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

	@Query("SELECT t FROM Ticket t WHERE t.flight = :flight AND t.user.userid = :admin")
	Ticket findByFlight(@Param("flight")Flight flight, int admin);
	
	@Query("SELECT t FROM Ticket t WHERE t.user.userid = :userId")
	List<Ticket> findByUser(@Param("userId")Integer id);

}
