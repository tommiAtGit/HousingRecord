package com.myProjects.HousingRecord.Repository.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProjects.HousingRecord.Domain.HousingCooperative;
import com.myProjects.HousingRecord.Repository.DAOIF.HousingCooperativeDAO;
import com.myProjects.HousingRecord.Repository.Service.HousingCooperativeService;

@Service
public class HousingCooperativeServiceImp implements HousingCooperativeService{

	private HousingCooperativeDAO hcDAO;
	
	@Autowired
	public HousingCooperativeServiceImp(HousingCooperativeDAO hcDAO) {
		this.hcDAO = hcDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.HousingRecord.Repository.Service.impl.HousingCooperativeService#addHousingCooperative(com.myProjects.HousingRecord.Domain.HousingCooperative)
	 */
	
	public HousingCooperative addHousingCooperative(HousingCooperative cooperative) {
		
		HousingCooperative hc = null;
		if (cooperative != null) {
			hc = hcDAO.addHousingCooperative(cooperative);
		}
		return hc;
	}

	/* (non-Javadoc)
	 * @see com.myProjects.HousingRecord.Repository.Service.impl.HousingCooperativeService#getHousingCooperatives()
	 */
	
	public List<HousingCooperative> getHousingCooperatives(){
		List<HousingCooperative> hcs = null;
		hcs = hcDAO.getHousingCooperatives();
		return hcs;
	}

	/* (non-Javadoc)
	 * @see com.myProjects.HousingRecord.Repository.Service.impl.HousingCooperativeService#getHousingCooperative(java.lang.String)
	 */

	public HousingCooperative getHousingCooperative(String address) {
		HousingCooperative hc = null;
		if(address.isEmpty() || address != null)
		{
			hc = hcDAO.getHousingCooperative(address);
		}
		return hc;
	}

	/* (non-Javadoc)
	 * @see com.myProjects.HousingRecord.Repository.Service.impl.HousingCooperativeService#removeHousingCooperative(com.myProjects.HousingRecord.Domain.HousingCooperative)
	 */

	public void removeHousingCooperative(HousingCooperative cooperative) {
		hcDAO.removeHousingCooperative(cooperative);
	}
	
}
