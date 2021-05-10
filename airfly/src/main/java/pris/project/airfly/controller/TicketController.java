package pris.project.airfly.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pris.project.airfly.dto.FlightDTO;
import pris.project.airfly.entity.Flight;
import pris.project.airfly.entity.Ticket;
import pris.project.airfly.repository.TicketRepository;

@Controller
@RequestMapping(value="/ticket")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@PostMapping(value="/getTicketForFlight", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ticket> getTicketForFlight(HttpServletRequest request, @RequestBody Flight flight) throws ParseException {
		
		return new ResponseEntity<Ticket>(ticketRepository.findByFlight(flight), HttpStatus.OK);
	}
	
	@GetMapping(value="/checkDiscount", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> checkDiscount(HttpServletRequest request, @RequestParam("userId") Integer userId) throws ParseException {	
		List<Ticket> usersTickets = ticketRepository.findByUser(userId);
	
		return new ResponseEntity<Boolean>(usersTickets.size() % 5 == 0, HttpStatus.OK);
	}

}
