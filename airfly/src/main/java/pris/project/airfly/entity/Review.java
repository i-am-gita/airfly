package pris.project.airfly.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="hibernate_sequence")
	@SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", initialValue = 1, allocationSize=1)
	private Integer reviewid;

	private String description;

	private int grade;
	
	@ManyToOne
	@JoinColumn(name="airline_airlineid")
	private Airline airline;
	
	@ManyToOne
    @JoinColumn(name = "user_userid")
	private Userr user;

	public Review() {
	}
	
	
	

	public Integer getReviewid() {
		return reviewid;
	}




	public void setReviewid(Integer reviewid) {
		this.reviewid = reviewid;
	}




	public Userr getUser() {
		return user;
	}



	public void setUser(Userr user) {
		this.user = user;
	}




	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGrade() {
		return this.grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Airline getAirline() {
		return this.airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

}
