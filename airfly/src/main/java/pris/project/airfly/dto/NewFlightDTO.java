package pris.project.airfly.dto;

import java.util.Date;

import pris.project.airfly.entity.Airline;

public class NewFlightDTO {

	private Integer flightType;
	private String arrivalAirportName;
	private String arrivalCity;
	private String departureAirportName;
	private String departureCity;
	private Integer priceEconomics;
	private Integer priceFirstClass;
	private Date takeOffDate;
	private Integer ticketNumber;
	private Integer selectedAirline;
	
	public NewFlightDTO() {}
	
	
	public NewFlightDTO(Integer flightType, String arrivalAirportName, String arrivalCity, String departureAirportName,
			Integer priceEconomics, Integer priceFirstClass, Date takeOffDate, Integer ticketNumber) {
		super();
		this.flightType = flightType;
		this.arrivalAirportName = arrivalAirportName;
		this.arrivalCity = arrivalCity;
		this.departureAirportName = departureAirportName;
		this.priceEconomics = priceEconomics;
		this.priceFirstClass = priceFirstClass;
		this.takeOffDate = takeOffDate;
		this.ticketNumber = ticketNumber;
	}
	
	
	
	
	public String getDepartureCity() {
		return departureCity;
	}


	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}


	public Integer getSelectedAirline() {
		return selectedAirline;
	}


	public void setSelectedAirline(Integer selectedAirline) {
		this.selectedAirline = selectedAirline;
	}


	public Integer getFlightType() {
		return flightType;
	}
	public void setFlightType(Integer flightType) {
		this.flightType = flightType;
	}
	public String getArrivalAirportName() {
		return arrivalAirportName;
	}
	public void setArrivalAirportName(String arrivalAirportName) {
		this.arrivalAirportName = arrivalAirportName;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public String getDepartureAirportName() {
		return departureAirportName;
	}
	public void setDepartureAirportName(String departureAirportName) {
		this.departureAirportName = departureAirportName;
	}
	public Integer getPriceEconomics() {
		return priceEconomics;
	}
	public void setPriceEconomics(Integer priceEconomics) {
		this.priceEconomics = priceEconomics;
	}
	public Integer getPriceFirstClass() {
		return priceFirstClass;
	}
	public void setPriceFirstClass(Integer priceFirstClass) {
		this.priceFirstClass = priceFirstClass;
	}
	public Date getTakeOffDate() {
		return takeOffDate;
	}
	public void setTakeOffDate(Date takeOffDate) {
		this.takeOffDate = takeOffDate;
	}
	public Integer getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(Integer ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	
	
}
