package pris.project.airfly.dto;



import java.util.Date;

public class FlightDTO {

	private String departureAirport;

	private String arrivalAirport;	
	
	private Date goingDate;
	
	private Date returnDate;
	
	public FlightDTO(String departureAirport, String arrivalAirport, Date goingDate, Date returnDate) {
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.goingDate = goingDate;
		this.returnDate = returnDate;
	}
	
	public FlightDTO() {}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public Date getGoingDate() {
		return goingDate;
	}

	public void setGoingDate(Date goingDate) {
		this.goingDate = goingDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	
}
