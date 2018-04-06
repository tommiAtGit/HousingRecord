package com.myProjects.HousingRecord.Repository.DAOIF;

import java.util.List;

import com.myProjects.HousingRecord.Domain.HousingApartment;
import com.myProjects.HousingRecord.Domain.HousingCooperative;
import com.myProjects.HousingRecord.Domain.UserInformation;

public interface HousingApartmentDAO {

	/**
	 * Add new HousingApartment hA = null;
	 * @param housingApartment
	 * @return
	 */
	HousingApartment addHousingApartment(HousingApartment housingApartment);

	/**
	 * Get information of selected housing appartment
	 * @param apartment
	 * @return
	 */
	HousingApartment getHousingApartment(String apartment);

	/**
	 * Get housing apartment of selected housing cooperative
	 * @param housingCooperative
	 * @return
	 */
	List<HousingApartment> getHousingApartments(HousingCooperative housingCooperative);

	/**
	 * Get HousingApartment of selected user
	 * @param userInfo
	 * @return
	 */
	HousingApartment getUserHousingApartment(UserInformation userInfo);

	/**
	 * Remove selected apartment
	 * @param apartment
	 */
	void removeHousingApartment(HousingApartment apartment);

}