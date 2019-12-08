package com.suntossh.springboot.users.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequestModel implements Serializable {

	private static final long serialVersionUID = -6874512173282169227L;

	@NotNull(message = "firstName cannot be null")
	@Size(max = 50)
	private String firstName;

	@NotNull(message = "lastName cannot be null")
	@Size(max = 50)
	private String lastName;

	@NotNull(message = "email cannot be null")
	@Size(max = 120)
	@Email
	private String email;

	@NotNull(message = "firstName cannot be null")
	@Size(max = 100)
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserRequestModel [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}

	
}
