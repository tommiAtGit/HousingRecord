package com.myProjects.HousingRecord.Domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="HousingApartment")
public class HousingApartment implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id = 0;
	private UserInformation userInfo;
	private HousingCooperative housingCooperative;
	private String apartment;
	
	public HousingApartment()
	{
		
	}
	@Id
	@GeneratedValue
	@Column(name="id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@OneToOne(cascade = CascadeType.ALL)	
	public UserInformation getUserInformation() {
		return userInfo;
	}

	public void setUserInformation(UserInformation userInfo) {
		this.userInfo = userInfo;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	public HousingCooperative getHousingCooperative() {
		return housingCooperative;
	}

	public void setHousingCooperative(HousingCooperative housingCooperative) {
		this.housingCooperative = housingCooperative;
	}

	@Column(name="Apartment")
	public String getApartment() {
		return apartment;
	}
	
	public void setApartment(String apartment) {
		this.apartment = apartment;
	}
}
