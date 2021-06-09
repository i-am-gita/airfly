package pris.project.airfly.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import pris.project.airfly.util.MapUtil;

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
	
	@GetMapping(value="/getBestRatedAirlines", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Double>> getBestRatedAirlines(){
		
		LocalDateTime monthBeforeNow = LocalDateTime.now().minusDays(30);
		
		List<Rating> pastMonthRatings = ratingRepository.getPastMonthRatings(monthBeforeNow);
		
		Map<Airline, List<Integer>> ratingsForAirlines = new HashMap<>();
		
		for(Rating rate : pastMonthRatings) {
			if(ratingsForAirlines.containsKey(rate.getAirline())) {
				ratingsForAirlines.get(rate.getAirline()).add(rate.getGrade());
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(rate.getGrade());
				ratingsForAirlines.put(rate.getAirline(), list);
			}
		}
		
		Map<String, Double> averagePastMonthRating = new HashMap<>();
		
		for(Airline air : ratingsForAirlines.keySet()) {
			int sum = 0;
			for(int rating : ratingsForAirlines.get(air)) {
				sum+= rating;
			}
			averagePastMonthRating.put(air.getName(), (double) sum/ratingsForAirlines.get(air).size());
		}
		
		return new ResponseEntity<Map<String, Double>>(MapUtil.sortByValue(averagePastMonthRating), HttpStatus.OK);
	}
	
}
