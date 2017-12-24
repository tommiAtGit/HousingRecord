package com.myProjects.HousingRecord.Domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Water reading of the apartment
 * @author tommi
 *
 */
@Entity
@Table(name="ApartmentWater") 
public class ApartmentWater implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id = 0;
	private Date recordDate;
	private double coldWaterValue;
	private double hotWaterValue;
	private HousingApartment housingApartment;
	
	public ApartmentWater(){
		
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
	@Column(name="RecordDate")
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recondDate) {
		this.recordDate = recondDate;
	}
	@Column(name="ColdWaterValue")
	public double getColdWaterValue() {
		return coldWaterValue;
	}
	public void setColdWaterValue(double coldWaterValue) {
		this.coldWaterValue = coldWaterValue;
	}
	@Column(name="HotWaterValue")
	public double getHotWaterValue() {
		return hotWaterValue;
	}
	public void setHotWaterValue(double hotWaterValue) {
		this.hotWaterValue = hotWaterValue;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	public HousingApartment getHousingApartment() {
		return housingApartment;
	}
	public void setHousingApartment(HousingApartment housingApartment) {
		this.housingApartment = housingApartment;
	}
}

