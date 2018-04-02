package com.myProject.HousingRecord.ApplicationControler.AppartmentControler;

import java.util.List;

import com.myProjects.HousingRecord.Domain.HousingApartment;

public interface HousingCooperative {
	public HousingCooperative getHousingCooperative(String Name);
	public List<HousingCooperative>getHousingCooperatives();
	public HousingCooperative addHousingCooperative(HousingCooperative cooperative);
	public void deleteHousingCooperative(HousingCooperative cooperative);
	public HousingApartment getApparment(HousingCooperative cooperative);
	

}
