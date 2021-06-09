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
public class Plane {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int planeid;

	private String description;

	private String name;

	@ManyToOne
	@JoinColumn(name="airline_airlineid")
	private Airline airline;
	
//	@OneToMany(mappedBy = "plane")
//	private List<Flight> flights;
	
//	@OneToMany(mappedBy="plane")
//	private List<Photo> photos;
	
	public Plane() {
	}

	public int getPlaneid() {
		return this.planeid;
	}

	public void setPlaneid(int planeid) {
		this.planeid = planeid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Airline getAirline() {
		return this.airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

//	public List<Photo> getPhotos() {
//		return this.photos;
//	}
//
//	public void setPhotos(List<Photo> photos) {
//		this.photos = photos;
//	}
}
