package pris.project.airfly.controller;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import pris.project.airfly.dto.FlightWithPriceDTO;
import pris.project.airfly.dto.NewFlightDTO;
import pris.project.airfly.entity.Airline;
import pris.project.airfly.entity.Airport;
import pris.project.airfly.entity.Destination;
import pris.project.airfly.entity.Flight;
import pris.project.airfly.entity.Ticket;
import pris.project.airfly.repository.AirlineRepository;
import pris.project.airfly.repository.AirportRepository;
import pris.project.airfly.repository.DestinationRepository;
import pris.project.airfly.repository.FlightRepository;
import pris.project.airfly.repository.TicketRepository;
import pris.project.airfly.repository.UserrRepository;


@Controller
@RequestMapping(value="/flight")
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	AirportRepository airportRepository;
	
	@Autowired
	DestinationRepository destinationRepository;
	
	@Autowired
	AirlineRepository airlineRepository;
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	UserrRepository userRepository;
	
	@PostMapping(value="/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Flight> addFlight(HttpServletRequest request, @RequestBody NewFlightDTO flight) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formatedDateString = sdf.format(flight.getTakeOffDate());
		
		Airport departureAir = new Airport();
		departureAir.setCity(flight.getDepartureCity());
		departureAir.setName(flight.getDepartureAirportName());
		airportRepository.save(departureAir);
		
		Airport arrivalAir = new Airport();
		arrivalAir.setCity(flight.getArrivalCity());
		arrivalAir.setName(flight.getArrivalAirportName());
		airportRepository.save(arrivalAir);
		
		Destination destination = new Destination();
		destination.setAirport1(departureAir);
		destination.setAirport2(arrivalAir);
		destination.setName(flight.getArrivalAirportName()+" " + flight.getDepartureAirportName());
		destinationRepository.save(destination);
		
		Airline selectedAirline = airlineRepository.findById(flight.getSelectedAirline()).get();
	
		
		
		
		Flight newFlight = new Flight();
		newFlight.setTakeoffDate(sdf.parse(formatedDateString));
		newFlight.setAvailabletickets(flight.getTicketNumber());
		newFlight.setType(flight.getFlightType());
		newFlight.setDestination(destination);
		newFlight.setAirline(selectedAirline);
		flightRepository.save(newFlight);
		
		Ticket ticket = new Ticket();
		ticket.setFlight(newFlight);
		ticket.setPricebusiness(flight.getPriceFirstClass());
		ticket.setPriceeconomics(flight.getPriceEconomics());
		ticket.setUser(userRepository.findById(1).get());
		ticketRepository.save(ticket);
		
		return new ResponseEntity<Flight>(newFlight, HttpStatus.OK);
	}
	
	
	@GetMapping(value="/getAllFlights", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Flight>> getFlights(){
		return new ResponseEntity<List<Flight>>(flightRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/getSortedFlights", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FlightWithPriceDTO>> getSortedFlights(){
		
		List<Flight> allFlights = flightRepository.findAll();
		List<FlightWithPriceDTO> sortedFlights = new ArrayList<>();
		
		for(Flight flight : allFlights) {
			Ticket ticket = ticketRepository.findByFlight(flight, 1);
			
			FlightWithPriceDTO mappedFlight = new FlightWithPriceDTO();
			mappedFlight.setAirline(flight.getAirline());
			mappedFlight.setAvailabletickets(flight.getAvailabletickets());
			mappedFlight.setDestination(flight.getDestination());
			mappedFlight.setFlightid(flight.getFlightid());
			mappedFlight.setPlane(flight.getPlane());
			mappedFlight.setTakeoffdate(flight.getTakeoffdate());
			mappedFlight.setTypee(flight.getType());
			if(ticket != null) {
				mappedFlight.setTicketPrice(ticket.getPriceeconomics());
			} else {
				System.err.println("YOYOYO");
			}
			sortedFlights.add(mappedFlight);
		}
		
		Collections.sort(sortedFlights, Collections.reverseOrder());

		return new ResponseEntity<List<FlightWithPriceDTO>>(sortedFlights, HttpStatus.OK);
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
