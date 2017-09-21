package pl.sda.nordea.registration.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {

	@Id
	private String username;
	private String password;
	private boolean enabled = true;

	public Users() {
	};

	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean enabled() {
		return enabled;
	}

	public void setActive(boolean enabled) {
		this.enabled = enabled;
	}

}
