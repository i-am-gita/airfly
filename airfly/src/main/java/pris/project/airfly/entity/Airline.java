package pris.project.airfly.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Airline {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int airlineid;

	private String companyinfo;

	private String luggageinfo;

	private String name;
	
//	@OneToMany(mappedBy="airline")
//	private List<Flight> flights;
//
//	@OneToMany(mappedBy="airline")
//	private List<Plane> planes;
//
//	@OneToMany(mappedBy="airline")
//	private List<Review> reviewsSet;

	public Airline() {
	}

	public int getAirlineid() {
		return this.airlineid;
	}

	public void setAirlineid(int airlineid) {
		this.airlineid = airlineid;
	}

	public String getCompanyinfo() {
		return companyinfo;
	}

	public void setCompanyinfo(String companyinfo) {
		this.companyinfo = companyinfo;
	}

	public String getLuggageinfo() {
		return this.luggageinfo;
	}

	public void setLuggageinfo(String luggageinfo) {
		this.luggageinfo = luggageinfo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Flight> getFlights() {
//		return this.flights;
//	}
//
//	public void setFlights(List<Flight> flights) {
//		this.flights = flights;
//	}
//
//	public Flight addFlight(Flight flight) {
//		getFlights().add(flight);
//		flight.setAirline(this);
//
//		return flight;
//	}
//
//	public Flight removeFlight(Flight flight) {
//		getFlights().remove(flight);
//		flight.setAirline(null);
//
//		return flight;
//	}

//	public List<Plane> getPlanes() {
//		return this.planes;
//	}
//
//	public void setPlanes(List<Plane> planes) {
//		this.planes = planes;
//	}
//
//	public Plane addPlane(Plane plane) {
//		getPlanes().add(plane);
//		plane.setAirline(this);
//
//		return plane;
//	}
//
//	public Plane removePlane(Plane plane) {
//		getPlanes().remove(plane);
//		plane.setAirline(null);
//
//		return plane;
//	}
//
//	public List<Review> getReviewsSet() {
//		return this.reviewsSet;
//	}
//
//	public void setReviewsSet(List<Review> reviewsSet) {
//		this.reviewsSet = reviewsSet;
//	}
//
//	public Review addReviewsSet(Review reviewsSet) {
//		getReviewsSet().add(reviewsSet);
//		reviewsSet.setAirline(this);
//
//		return reviewsSet;
//	}
//
//	public Review removeReviewsSet(Review reviewsSet) {
//		getReviewsSet().remove(reviewsSet);
//		reviewsSet.setAirline(null);
//
//		return reviewsSet;
//	}
}
