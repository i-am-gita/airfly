package pris.project.airfly.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleid;
	
	//private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole description;
	
//	@OneToMany(mappedBy="role")
//	private List<Userr> users;
	
	public Role() {	
	}
	
	public int getRoleid() {
		return roleid;
	}

	public ERole getDescription() {
		return description;
	}
	public void setRoleid(int roleid) {
		roleid = this.roleid;
	}

	public void setDescription(ERole description) {
	    description = this.description;
	}
}
