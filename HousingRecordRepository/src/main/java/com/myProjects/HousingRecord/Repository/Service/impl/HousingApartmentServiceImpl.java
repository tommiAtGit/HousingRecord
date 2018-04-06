package com.myProjects.HousingRecord.Repository.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProjects.HousingRecord.Domain.HousingApartment;
import com.myProjects.HousingRecord.Domain.HousingCooperative;
import com.myProjects.HousingRecord.Domain.UserInformation;
import com.myProjects.HousingRecord.Repository.DAOIF.HousingApartmentDAO;
import com.myProjects.HousingRecord.Repository.Service.HousingApartmentService;

@Service
public class HousingApartmentServiceImpl implements HousingApartmentService {

private HousingApartmentDAO haDAO;
	
	@Autowired
	public HousingApartmentServiceImpl(HousingApartmentDAO haDAO) {
		this.haDAO = haDAO;
	}

	/* (non-Javadoc)
	 * @see com.myProjects.HousingRecord.Repository.Service.impl.HousingApartmentService#addHousingApartment(com.myProjects.HousingRecord.Domain.HousingApartment)
	 */
	public HousingApartment addHousingApartment(HousingApartment apartment) {
		HousingApartment ha = null;
		if (apartment != null) {
			ha = haDAO.addHousingApartment(apartment);
		}
		return ha;
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.HousingRecord.Repository.Service.impl.HousingApartmentService#getHousingApartment(java.lang.String)
	 */
	public HousingApartment getHousingApartment(String haName) {
		HousingApartment hA = null;
		
		if(haName.isEmpty() || haName != null){
			hA = haDAO.getHousingApartment(haName);
		}
		return hA;
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.HousingRecord.Repository.Service.impl.HousingApartmentService#getHousingApartmentsOfHousingCooperative(com.myProjects.HousingRecord.Domain.HousingCooperative)
	 */
	public List<HousingApartment> getHousingApartmentsOfHousingCooperative(HousingCooperative housingCooperative ){
		List<HousingApartment> haList = null;
		
		if (housingCooperative !=null) {
			haList = haDAO.getHousingApartments(housingCooperative);
		}
		return  haList;
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.HousingRecord.Repository.Service.impl.HousingApartmentService#getHousingApartmentOfUser(com.myProjects.HousingRecord.Domain.UserInformation)
	 */
	public HousingApartment getHousingApartmentOfUser(UserInformation userInformation){
		HousingApartment hA = null;
		
		if(userInformation != null) {
			hA = haDAO.getUserHousingApartment(userInformation);
		}
		return hA;
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.HousingRecord.Repository.Service.impl.HousingApartmentService#removeHousingApartment(com.myProjects.HousingRecord.Domain.HousingApartment)
	 */
	public void removeHousingApartment(HousingApartment housingApartment) {
		
		if(housingApartment != null) {
			haDAO.removeHousingApartment(housingApartment);
		}
	}
	
}
