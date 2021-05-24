package pris.project.airfly.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pris.project.airfly.dto.TicketDTO;
import pris.project.airfly.entity.Flight;
import pris.project.airfly.entity.Ticket;
import pris.project.airfly.repository.FlightRepository;
import pris.project.airfly.repository.TicketRepository;
import pris.project.airfly.repository.UserrRepository;

@Controller
@RequestMapping(value="/ticket")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	UserrRepository userRepository;
	
	@PostMapping(value="/getTicketForFlight", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ticket> getTicketForFlight(HttpServletRequest request, @RequestBody Flight flight) throws ParseException {
		Ticket wanted = ticketRepository.findByFlight(flight,1);
		System.out.println(wanted.getPricebusiness() + " " + wanted.getFlight().getAvailabletickets() + " " + wanted.getUser().getUsername() + wanted.getFlight().getAirline().getName());
		return new ResponseEntity<Ticket>(wanted, HttpStatus.OK);
	}
	
	@GetMapping(value="/checkDiscount", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> checkDiscount(HttpServletRequest request, @RequestParam("userId") String userId) throws ParseException {	
		Integer id = Integer.parseInt(userId);
		List<Ticket> usersTickets = ticketRepository.findByUser(id);
		
		boolean discount = false;
		
		if(usersTickets.size() % 5 == 0 && usersTickets.size()>0) {
			discount = true;
		}
		
		return new ResponseEntity<Boolean>(discount, HttpStatus.OK);
	}
	
	@PostMapping(value="/createFlightTicket", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ticket> createFlightTicket(HttpServletRequest request, @RequestBody TicketDTO ticketDTO) throws ParseException {
		
		Flight flight = flightRepository.findById(ticketDTO.getFlightId()).get();
		flight.setAvailabletickets(flight.getAvailabletickets() - 1);
		flightRepository.save(flight);
		
		Ticket ticket = new Ticket();
		ticket.setFlight(flight);
		ticket.setUser(userRepository.findById(ticketDTO.getUserId()).get());
		ticket.setPricebusiness(ticketDTO.getPriceBusiness());
		ticket.setPriceeconomics(ticketDTO.getPriceEconomics());
		ticketRepository.save(ticket);
		
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}

}
