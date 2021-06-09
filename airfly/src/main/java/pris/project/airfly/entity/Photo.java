package pris.project.airfly.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Photo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int photoid;

	private String description;

	private String url;
	
	@ManyToOne
	@JoinColumn(name="plane_planeid")
	private Plane plane;
	
	public Photo() {
	}

	public int getPhotoid() {
		return this.photoid;
	}

	public void setPhotoid(int photoid) {
		this.photoid = photoid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Plane getPlane() {
		return this.plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

}
