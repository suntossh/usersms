package com.suntossh.springboot.users.model;

import java.io.Serializable;

public class UserResponseModel implements Serializable {

	private static final long serialVersionUID = -7377650745119906357L;

	private String firstName;
	private String lastName;
	private String email;
	private String userid;

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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
