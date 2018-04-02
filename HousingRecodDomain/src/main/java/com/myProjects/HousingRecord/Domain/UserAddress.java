package com.myProjects.HousingRecord.Domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="UserAddress") 
public class UserAddress implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id = 0;
	private String fistName;
	private String lastName;
	private String eMail;
	private String phoneNumber;
	private UserInformation userInformation;
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id") 
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="FirstName") 
	public String getFistName() {
		return fistName;
	}
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	@Column(name="LastName")
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="eMail")
	public String getEMail() {
		return eMail;
	}
	
	public void setEMail(String mail) {
		eMail = mail;
	}
	
	@Column(name="PhoneNumber") 
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}
	
}
