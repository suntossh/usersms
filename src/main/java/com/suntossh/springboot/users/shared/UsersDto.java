package com.suntossh.springboot.users.shared;

import java.io.Serializable;

public class UsersDto implements Serializable {

	private static final long serialVersionUID = 6905624840444875598L;

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String userid;
	private String encryptedPwd;

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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getEncryptedPwd() {
		return encryptedPwd;
	}

	public void setEncryptedPwd(String encryptedPwd) {
		this.encryptedPwd = encryptedPwd;
	}

	@Override
	public String toString() {
		return "UsersDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", userid=" + userid + ", encryptedPwd=" + encryptedPwd + "]";
	}

}
