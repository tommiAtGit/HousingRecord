package com.myProjects.HousingRecord.Repository.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProjects.HousingRecord.Domain.HousingApartment;
import com.myProjects.HousingRecord.Repository.DAOIF.HousingApartmentDAO;

@Service
public class HousingApartmentServiceImpl {

private HousingApartmentDAO haDAO;
	
	@Autowired
	public HousingApartmentServiceImpl(HousingApartmentDAO haDAO) {
		this.haDAO = haDAO;
	}

	/**
	 * Add new apartment. 
	 * @param apartment
	 * @return
	 */
	public HousingApartment addHousingApartment(HousingApartment apartment) {
		HousingApartment ha = null;
		if (apartment != null) {
			ha = haDAO.addHousingApartment(apartment);
		}
		return ha;
	}
	
	/**
	 * Get apratment by name
	 * @param haName
	 * @return
	 */
	public HousingApartment getHousingApartment(String haName) {
		HousingApartment ha = null;
		
		if(haName.isEmpty() || haName != null){
			ha = haDAO.getHousingApartment(haName);
		}
		return ha;
	}
	
}
