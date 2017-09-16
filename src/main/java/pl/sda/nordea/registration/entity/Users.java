package pl.sda.nordea.registration.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {

	@Id
	private long userId;
	private String username;
	private String password;
	private String name;
	private String lastName;
	private String birthDate;
	private String history = "";
	private String phoneNumber;
	private boolean enabled = true;

	public Users() {
	};

	public Users(long userId, String username, String password, String name, String lastName, String birthDate, String phoneNumber) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
