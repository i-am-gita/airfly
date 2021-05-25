package pris.project.airfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pris.project.airfly.entity.Airline;
import pris.project.airfly.entity.Flight;
import pris.project.airfly.entity.Rating;
import pris.project.airfly.repository.AirlineRepository;
import pris.project.airfly.repository.FlightRepository;
import pris.project.airfly.repository.RatingRepository;

@Controller
@RequestMapping(value="/airline")
@CrossOrigin(origins = "http://localhost:4200")
public class AirlineController {

	@Autowired
	AirlineRepository airlineRepository;
	
	@Autowired
	RatingRepository ratingRepository;
	
	@GetMapping(value="/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Airline>> getFlights(){
		
		return new ResponseEntity<List<Airline>>(airlineRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/getRating/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> getRatingForAirlineId(@PathVariable("id") Integer id){
		
		List<Rating> ratings = ratingRepository.getRatingForAirlineId(id);
		int sum = 0;
		int counter = 0;
		
		for(Rating rat : ratings) {
			sum += rat.getGrade();
			counter++;
		}
		
		return new ResponseEntity<Double>((double)sum/counter, HttpStatus.OK);
	}
}
