package com.myProjects.HousingRecord.Domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customerLevel")
public class CustomerLevel implements Serializable {

	/**
	 * DTO for customer level handling
	 */
	private static final long serialVersionUID = 1L;
	private int id = 0;
	private int securityLevel;
	private String levelName;
	
	public CustomerLevel()
	{
	
	}
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="securityLevel")
	public int getSecurityLevel() {
		return securityLevel;
	}
	
	public void setSecurityLevel(int levelValue) {
		this.securityLevel = levelValue;
	}
	@Column(name="levelName")
	public String getLevelName() {
		return levelName;
	}
	
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}


}
