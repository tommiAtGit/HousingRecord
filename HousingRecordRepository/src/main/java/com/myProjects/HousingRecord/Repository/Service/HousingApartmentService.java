package com.myProjects.HousingRecord.Repository.Service;

import java.util.List;

import com.myProjects.HousingRecord.Domain.HousingApartment;
import com.myProjects.HousingRecord.Domain.HousingCooperative;
import com.myProjects.HousingRecord.Domain.UserInformation;

public interface HousingApartmentService {

	/**
	 * Add new apartment. 
	 * @param apartment
	 * @return
	 */
	HousingApartment addHousingApartment(HousingApartment apartment);

	/**
	 * Get apratment by name
	 * @param haName
	 * @return
	 */
	HousingApartment getHousingApartment(String haName);

	/**
	 * Get housing apartments in selected housing cooperative.
	 * @param housingCooperative
	 * @return
	 */
	List<HousingApartment> getHousingApartmentsOfHousingCooperative(HousingCooperative housingCooperative);

	/**
	 * Get housing apartment information of selected user.
	 * @param userInformation
	 * @return
	 */
	HousingApartment getHousingApartmentOfUser(UserInformation userInformation);

	/**
	 * Remove select selected housing apartment
	 * @param housingApartment
	 */
	void removeHousingApartment(HousingApartment housingApartment);

}