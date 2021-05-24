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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pris.project.airfly.dto.FlightDTO;
import pris.project.airfly.dto.ReviewDTO;
import pris.project.airfly.entity.Airline;
import pris.project.airfly.entity.Flight;
import pris.project.airfly.entity.Review;
import pris.project.airfly.entity.Userr;
import pris.project.airfly.repository.AirlineRepository;
import pris.project.airfly.repository.ReviewRepository;
import pris.project.airfly.repository.UserrRepository;

@Controller
@RequestMapping(value="/review")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	UserrRepository userRepository;
	
	@Autowired
	AirlineRepository airlineRepository;
	
	@GetMapping(value="/getAirlineReviews/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Review>> getReviewsForAirlineID(@PathVariable("id") Integer id){

		return new ResponseEntity<List<Review>>(reviewRepository.getAllReviewsForGivenAirlineId(id), HttpStatus.OK);
	}
	
	@PostMapping(value="/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Review> createReview(HttpServletRequest request, @RequestBody ReviewDTO reviewDTO) throws ParseException {	
				
				Userr user = userRepository.findById(reviewDTO.getUserId()).get();
				Airline airline = airlineRepository.findById(reviewDTO.getAirlineId()).get();
				
				if(user != null && airline != null) {
					Review newReview = new Review();
					newReview.setAirline(airline);
					newReview.setDescription(reviewDTO.getDescription());
					newReview.setUser(user);
					reviewRepository.save(newReview);
					return new ResponseEntity<Review>(newReview, HttpStatus.OK);
				}
				return null;
				
		}

}
