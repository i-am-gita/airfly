package pris.project.airfly.dto;

public class RatingDTO {
	
	private Integer userId;
	private Integer airlineId;
	private Integer rating;
	
	public RatingDTO() {}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(Integer airlineId) {
		this.airlineId = airlineId;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	

}
