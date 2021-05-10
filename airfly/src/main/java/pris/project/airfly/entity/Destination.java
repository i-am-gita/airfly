package pris.project.airfly.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Destination {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int destinationid;

	private String name;

	@ManyToOne
	@JoinColumn(name="airport_airportid")
	private Airport airport1;
	
	@ManyToOne
	@JoinColumn(name="airport_airportid1")
	private Airport airport2;
	
//	@OneToMany(mappedBy="destination")
//	private List<Flight> flights;

	public Destination() {
	}

	public int getDestinationid() {
		return this.destinationid;
	}

	public void setDestinationid(int destinationid) {
		this.destinationid = destinationid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Airport getAirport1() {
		return this.airport1;
	}

	public void setAirport1(Airport airport1) {
		this.airport1 = airport1;
	}

	public Airport getAirport2() {
		return this.airport2;
	}

	public void setAirport2(Airport airport2) {
		this.airport2 = airport2;
	}

//	public List<Flight> getFlights() {
//		return this.flights;
//	}
//
//	public void setFlights(List<Flight> flights) {
//		this.flights = flights;
//	}

//	public Flight addFlight(Flight flight) {
//		getFlights().add(flight);
//		flight.setDestination(this);
//
//		return flight;
//	}
//
//	public Flight removeFlight(Flight flight) {
//		getFlights().remove(flight);
//		flight.setDestination(null);
//
//		return flight;
//	}
}
