package pris.project.airfly.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ticketid;

	private int pricebusiness;

	private int priceeconomics;
	
	@ManyToOne
	@JoinColumn(name="userr_userid")
	private Userr user;
	
	@ManyToOne
	@JoinColumn(name="flight_flightid")
	private Flight flight;
	
	public Ticket() {
	}

	public int getTicketid() {
		return this.ticketid;
	}

	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}

	public int getPricebusiness() {
		return this.pricebusiness;
	}

	public void setPricebusiness(int pricebusiness) {
		this.pricebusiness = pricebusiness;
	}

	public int getPriceeconomics() {
		return this.priceeconomics;
	}

	public void setPriceeconomics(int priceeconomics) {
		this.priceeconomics = priceeconomics;
	}

	public Flight getFlight() {
		return this.flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Userr getUser() {
		return user;
	}

	public void setUser(Userr user) {
		this.user = user;
	}
	
	

}
