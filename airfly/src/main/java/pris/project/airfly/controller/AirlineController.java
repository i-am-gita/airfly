package pris.project.airfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pris.project.airfly.entity.Airline;
import pris.project.airfly.entity.Flight;
import pris.project.airfly.repository.AirlineRepository;
import pris.project.airfly.repository.FlightRepository;

@Controller
@RequestMapping(value="/airline")
@CrossOrigin(origins = "http://localhost:4200")
public class AirlineController {

	@Autowired
	AirlineRepository airlineRepository;
	
	@GetMapping(value="/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Airline>> getFlights(){
		
//		List<Flight> flts = flightRepository.findAll();
//		
//		for(Flight f : flts) {
//			System.out.println(f.getAvailabletickets() + f.getType() + f.getAirline().getName() + f.getTakeoffdate() +f.getDestination().getName() + f.getDestination().getAirport1().getCity() + f.getDestination().getAirport2().getCity());
//		}
		return new ResponseEntity<List<Airline>>(airlineRepository.findAll(), HttpStatus.OK);
	}
}
