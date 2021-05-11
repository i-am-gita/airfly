package pris.project.airfly.dto;

public class TicketDTO {
	
	private Integer flightId;
	private Integer userId;
	private Integer priceEconomics;
	private Integer priceBusiness;
	
	public TicketDTO() {}
	
	public TicketDTO(Integer flightId, Integer userId, Integer priceEconomics, Integer priceBusiness) {
		super();
		this.flightId = flightId;
		this.userId = userId;
		this.priceEconomics = priceEconomics;
		this.priceBusiness = priceBusiness;
	}
	public Integer getPriceEconomics() {
		return priceEconomics;
	}
	public void setPriceEconomics(Integer priceEconomics) {
		this.priceEconomics = priceEconomics;
	}
	public Integer getPriceBusiness() {
		return priceBusiness;
	}
	public void setPriceBusiness(Integer priceBusiness) {
		this.priceBusiness = priceBusiness;
	}
	public Integer getFlightId() {
		return flightId;
	}
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	

}
