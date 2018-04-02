package com.myProjects.HousingRecord.Repository.Service;

import java.util.List;

import com.myProjects.HousingRecord.Domain.HousingCooperative;

public interface HousingCooperativeService {

	/**
	 * Add new housing cooperative
	 * @param cooperative
	 * @return HousingCooperative
	 */
	HousingCooperative addHousingCooperative(HousingCooperative cooperative);

	/**
	 * Get list of housing cooperatives 
	 * @return
	 */
	List<HousingCooperative> getHousingCooperatives();

	/**
	 * Get housing cooperative with house address
	 * @param address
	 * @return
	 */
	HousingCooperative getHousingCooperative(String address);

	/**
	 * Remove housing cooperative
	 * @param cooperative
	 */
	void removeHousingCooperative(HousingCooperative cooperative);

}