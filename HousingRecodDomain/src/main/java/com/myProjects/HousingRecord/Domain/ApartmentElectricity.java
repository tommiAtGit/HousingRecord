package com.myProjects.HousingRecord.Domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ApartmentElectricity") 
public class ApartmentElectricity implements Serializable {

	/**
	 * DTO object for electricity consumption values
	 */
	private static final long serialVersionUID = 1L;
	private long id = 0;
	private double cumulativeValue;
	private double measuredValue;
	private Date measureDate;
	private HousingApartment housingApartment;
	
	public ApartmentElectricity() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * Cumulative value of the measured electricity
	 * @return
	 */
	@Column(name="CumulativeValue") 
	public double getCumulativeValue() {
		return cumulativeValue;
	}
	public void setCumulativeValue(double cumulativeValue) {
		this.cumulativeValue = cumulativeValue;
	}
	/**
	 * Measured value of electricity consumption
	 * @return
	 */
	@Column(name="MeasuredValue")
	public double getMeasuredValue() {
		return measuredValue;
	}

	public void setMeasuredValue(double measuredValue) {
		this.measuredValue = measuredValue;
	}

	@Column(name="MeasureDate") 
	public Date getMeasureDate() {
		return measureDate;
	}
	public void setMeasureDate(Date measureDate) {
		this.measureDate = measureDate;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	public HousingApartment getHousingApartment() {
		return housingApartment;
	}
	public void setHousingApartment(HousingApartment housingApartment) {
		this.housingApartment = housingApartment;
	}
	
	
	

}
