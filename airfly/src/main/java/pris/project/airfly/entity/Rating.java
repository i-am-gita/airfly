package pris.project.airfly.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Rating {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer grade;
	
	@ManyToOne
	@JoinColumn(name="airline_airlineid")
	private Airline airline;
	
	@ManyToOne
	@JoinColumn(name="userr_userid")
	private Userr user;

	public Rating() {}
	
	public Rating(Integer id, Integer grade, Airline airline) {
		super();
		this.id = id;
		this.grade = grade;
		this.airline = airline;
	}
	
	

	public Userr getUser() {
		return user;
	}

	public void setUser(Userr user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	
	

}
