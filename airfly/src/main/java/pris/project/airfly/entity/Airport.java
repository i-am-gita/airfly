package pris.project.airfly.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.print.attribute.standard.Destination;

@Entity		
public class Airport {

	@Id
	@GeneratedValue
	private int airportid;
	
	@Column
	private String city;
	@Column
	private String name;
	
//	@OneToMany(mappedBy="airport1")
//	private List<Destination> destinations1;
//
//	@OneToMany(mappedBy="airport2")
//	private List<Destination> destinations2;

	public Airport() {
	}

	public int getAirportid() {
		return this.airportid;
	}

	public void setAirportid(int airportid) {
		this.airportid = airportid;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Destination> getDestinations1() {
//		return this.destinations1;
//	}
//
//	public void setDestinations1(List<Destination> destinations1) {
//		this.destinations1 = destinations1;
//	}
//
//	public List<Destination> getDestinations2() {
//		return this.destinations2;
//	}
//
//	public void setDestinations2(List<Destination> destinations2) {
//		this.destinations2 = destinations2;
//	}

}
