package pl.sda.nordea.registration.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRoles {

	@Id
	private String username;
	private String role = "ROLE_USER";
	
	
	public UserRoles(String username) {
		super();
		this.username = username;
	}

	

public UserRoles(){};


	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
