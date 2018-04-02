package com.myProjects.HousingRecord.Repository.DAOIF;

import java.util.List;

import com.myProjects.HousingRecord.Domain.HousingCooperative;

public interface HousingCooperativeDAO {

	/***
	 * Add new housing cooperative information
	 * @param cooperative
	 * @return
	 */
	HousingCooperative addHousingCooperative(HousingCooperative cooperative);

	/**
	 * Return information of all housing cooperatives
	 * @return
	 */
	List<HousingCooperative> getHousingCooperatives();

	/**
	 * Return information of single housing cooperative	
	 * @param address
	 * @return
	 */
	HousingCooperative getHousingCooperative(String address);

	/**
	 * Remove information of housing cooperative
	 * @param cooperative
	 */
	void removeHousingCooperative(HousingCooperative cooperative);

}