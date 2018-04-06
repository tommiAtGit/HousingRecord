package com.myProjects.HousingRecord.Domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HousingCooperative")
public class HousingCooperative implements Serializable {

	/**
	 * Housing cooperative information. 
	 */
	private static final long serialVersionUID = 1L;
	private long id = 0;
	private String name;
	private String address;
	private String postNumber;
	private String city;
	private String bankAccount;
	
	public HousingCooperative()
	{
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="postNumber")
	public String getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(String postNumber) {
		this.postNumber = postNumber;
	}
	@Column(name="city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Column(name="bankaccount")
	public String getBankaccount() {
		return bankAccount;
	}
	public void setBankaccount(String pankacount) {
		this.bankAccount = pankacount;
	}

}
