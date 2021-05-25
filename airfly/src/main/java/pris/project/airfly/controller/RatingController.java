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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import pris.project.airfly.dto.FlightDTO;
import pris.project.airfly.dto.RatingDTO;
import pris.project.airfly.entity.Flight;
import pris.project.airfly.entity.Rating;
import pris.project.airfly.repository.AirlineRepository;
import pris.project.airfly.repository.RatingRepository;
import pris.project.airfly.repository.UserrRepository;

@Controller
@RequestMapping(value="/rating")
@CrossOrigin(origins = "http://localhost:4200")
public class RatingController {
	
	@Autowired
	UserrRepository userRepository;
	
	@Autowired
	AirlineRepository airlineRepository;
	
	@Autowired
	RatingRepository ratingRepository;
	
	
	@PostMapping(value="/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> rateAirline(HttpServletRequest request, @RequestBody RatingDTO rating) throws ParseException {
		
		Rating currentRating = ratingRepository.checkRatingForUser(rating.getAirlineId(), rating.getUserId());
		if(currentRating != null) {
			currentRating.setGrade(rating.getRating());
			ratingRepository.save(currentRating);
		} else {
			Rating newRating = new Rating();
			newRating.setAirline(airlineRepository.findById(rating.getAirlineId()).get());
			newRating.setUser(userRepository.findById(rating.getUserId()).get());
			newRating.setGrade(rating.getRating());
			ratingRepository.save(newRating);
		}
		
		List<Rating> airlineRatings = ratingRepository.getRatingForAirlineId(rating.getAirlineId());

		int sum = 0;
		int counter = 0;
		
		for(Rating rat : airlineRatings) {
			sum += rat.getGrade();
			counter++;
		}
		
		return new ResponseEntity<Double>((double)sum/counter, HttpStatus.OK);
		
	}

}
