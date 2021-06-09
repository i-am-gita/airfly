package pris.project.airfly.dto;

import java.util.Date;

import pris.project.airfly.entity.Airline;
import pris.project.airfly.entity.Destination;
import pris.project.airfly.entity.Plane;

public class FlightWithPriceDTO implements Comparable<FlightWithPriceDTO> {

	private Integer ticketPrice;
	private int flightid;
	private int availabletickets;
	private Date takeoffdate;
	private int typee;
	private Airline airline;
	private Destination destination;
	private Plane plane;

	public FlightWithPriceDTO(Integer ticketPrice, int flightid, int availabletickets, Date takeoffdate, int typee,
			Airline airline, Destination destination, Plane plane) {
		super();
		this.ticketPrice = ticketPrice;
		this.flightid = flightid;
		this.availabletickets = availabletickets;
		this.takeoffdate = takeoffdate;
		this.typee = typee;
		this.airline = airline;
		this.destination = destination;
		this.plane = plane;
	}

	public FlightWithPriceDTO() {
	}

	public int getFlightid() {
		return flightid;
	}

	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}

	public int getAvailabletickets() {
		return availabletickets;
	}

	public void setAvailabletickets(int availabletickets) {
		this.availabletickets = availabletickets;
	}

	public Date getTakeoffdate() {
		return takeoffdate;
	}

	public void setTakeoffdate(Date takeoffdate) {
		this.takeoffdate = takeoffdate;
	}

	public int getTypee() {
		return typee;
	}

	public void setTypee(int typee) {
		this.typee = typee;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public Integer getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Integer ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	@Override
	public int compareTo(FlightWithPriceDTO flight) {
		return this.getTicketPrice().compareTo(flight.getTicketPrice());
	}
}
