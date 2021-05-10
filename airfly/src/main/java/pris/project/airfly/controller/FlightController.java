package pris.project.airfly.controller;



import java.text.DateFormat;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import pris.project.airfly.dto.FlightDTO;
import pris.project.airfly.entity.Flight;
import pris.project.airfly.entity.Ticket;
import pris.project.airfly.repository.FlightRepository;


@Controller
@RequestMapping(value="/flight")
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {

	@Autowired
	FlightRepository flightRepository;
	
	@GetMapping(value="/getAllFlights", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Flight>> getFlights(){
		System.out.println(flightRepository.findAll());
		
//		List<Flight> flts = flightRepository.findAll();
//		
//		for(Flight f : flts) {
//			System.out.println(f.getAvailabletickets() + f.getType() + f.getAirline().getName() + f.getTakeoffdate() +f.getDestination().getName() + f.getDestination().getAirport1().getCity() + f.getDestination().getAirport2().getCity());
//		}
		return new ResponseEntity<List<Flight>>(flightRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(value="/getFlightsForGoingDate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Flight>> getFlightsForGoingDate(HttpServletRequest request, @RequestBody FlightDTO flight) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formatedDateString = sdf.format(flight.getGoingDate());
		flight.setGoingDate(sdf.parse(formatedDateString));
		List<Flight> fls =flightRepository.getFlightByAirportAndDate(flight.getArrivalAirport(), flight.getDepartureAirport(), flight.getGoingDate());
		for(Flight f : fls) {
			System.out.println(f.getAvailabletickets() + f.getType() + f.getAirline().getName() + f.getTakeoffdate() +f.getDestination().getName() + f.getDestination().getAirport1().getCity() + f.getDestination().getAirport2().getCity());

		}
		return new ResponseEntity<List<Flight>>(flightRepository.getFlightByAirportAndDate(flight.getArrivalAirport(), flight.getDepartureAirport(), flight.getGoingDate()), HttpStatus.OK);
	}
	
	@PostMapping(value="/getFlightsForGoingAndReturningDate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Flight>> getFlightsForGoingAndReturningDate(HttpServletRequest request, @RequestBody FlightDTO flight) throws ParseException {	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formatedDateString = sdf.format(flight.getGoingDate());
		flight.setGoingDate(sdf.parse(formatedDateString));

		formatedDateString = sdf.format(flight.getReturnDate());
		flight.setReturnDate(sdf.parse(formatedDateString));
		System.out.println(flightRepository.getFlightByAirportAndDates(flight.getArrivalAirport(), flight.getDepartureAirport(), flight.getGoingDate(), flight.getReturnDate()));
		
		return new ResponseEntity<List<Flight>>(flightRepository.getFlightByAirportAndDates(flight.getArrivalAirport(), flight.getDepartureAirport(), flight.getGoingDate(), flight.getReturnDate()), HttpStatus.OK);
	}
	
	
}
