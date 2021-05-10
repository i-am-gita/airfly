package pris.project.airfly.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int flightid;

	private int availabletickets;

	@Temporal(TemporalType.DATE)
	private Date takeoffdate;

	private int typee;

	@ManyToOne
	@JoinColumn(name="airline_airlineid")
	private Airline airline;

	@ManyToOne
	@JoinColumn(name="destination_destinationid")
	private Destination destination;

//	@OneToMany(mappedBy="flight")
//	private List<Ticket> tickets;

	public Flight() {
	}

	public int getFlightid() {
		return this.flightid;
	}

	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}

	public int getAvailabletickets() {
		return this.availabletickets;
	}

	public void setAvailabletickets(int availabletickets) {
		this.availabletickets = availabletickets;
	}

	public Date getTakeoffdate() {
		return this.takeoffdate;
	}

	public void setTakeoffDate(Date takeoffdate) {
		this.takeoffdate = takeoffdate;
	}

	public int getType() {
		return this.typee;
	}

	public void setType(int typee) {
		this.typee = typee;
	}

	public Airline getAirline() {
		return this.airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Destination getDestination() {
		return this.destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
//
//	public List<Ticket> getTickets() {
//		return this.tickets;
//	}
//
//	public void setTickets(List<Ticket> tickets) {
//		this.tickets = tickets;
//	}

}
