package com.myProjects.HousingRecord.Repository.DAO;

import java.util.List;

import javax.persistence.Query;

import com.myProjects.HousingRecord.Domain.HousingApartment;
import com.myProjects.HousingRecord.Domain.HousingCooperative;
import com.myProjects.HousingRecord.Domain.UserInformation;
import com.myProjects.HousingRecord.Repository.DAOIF.HousingApartmentDAO;

public class HousingApartmentDAOImpl extends DAOBase implements HousingApartmentDAO {

	public HousingApartmentDAOImpl(String persistenceUnit) {
		super(persistenceUnit);
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.HousingRecord.Repository.DAO.HousingApartmentDAO#addHousingApartment(com.myProjects.HousingRecord.Domain.HousingApartment)
	 */
	public HousingApartment addHousingApartment(HousingApartment housingApartment ) {
		
		if (housingApartment != null) {
			try {
				
				em.getTransaction().begin();
				em.persist(housingApartment);
				em.getTransaction().commit();
				//em.close();
				
			}
			catch(Exception ex) {
				//TODO: Replace me with some kind of logging
				System.out.println(this.getClass().getName() + "-- addHousingApartment(): Error occured: " + ex.getMessage());
				ex.printStackTrace();
				
			}
			return housingApartment;
		}
		else {
			System.out.println(this.getClass().getName() + ": Error occured: housingApartment is null");
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.HousingRecord.Repository.DAO.HousingApartmentDAO#getHousingApartment(java.lang.String)
	 */
	public HousingApartment getHousingApartment(String apartment){
		HousingApartment hA = null;
		if (!apartment.isEmpty() || !(apartment==null)) {
			Query q  = em.createQuery("Select h From HousingApartment h JOIN h.userInfo i JOIN h.housingCooperative j where h.apartment = :apartment");
			q.setParameter("apartment", apartment);
			try {
				hA = (HousingApartment) q.getSingleResult();	
			}
			catch(Exception ex) {
				//TODO: Replace me with some kind of logging
				System.out.println(this.getClass().getName() + "-- getHousingApartment(): Error occured: " + ex.getMessage());
				ex.printStackTrace(); 
			}
		}
		return hA;
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.HousingRecord.Repository.DAO.HousingApartmentDAO#getHousingApartments(com.myProjects.HousingRecord.Domain.HousingCooperative)
	 */
	@SuppressWarnings("unchecked")
	public List<HousingApartment> getHousingApartments(HousingCooperative housingCooperative){
		List<HousingApartment> haList = null;
		
		if (housingCooperative != null) {
			Query q  = em.createQuery("Select h From HousingApartment h JOIN h.userInfo i JOIN h.housingCooperative j where h.housingCooperative = :housingCooperative");
			q.setParameter("housingCooperative", housingCooperative);
			try {
				haList = (List<HousingApartment>) q.getResultList();
			}
			catch(Exception ex) {
				//TODO: Replace me with some kind of logging
				System.out.println(this.getClass().getName() + "-- getHousingApartments(): Error occured: " + ex.getMessage());
				ex.printStackTrace(); 
			}
		}
		return haList;
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.HousingRecord.Repository.DAO.HousingApartmentDAO#getUserHousingApartment(com.myProjects.HousingRecord.Domain.UserInformation)
	 */
	public HousingApartment getUserHousingApartment(UserInformation userInfo) {
		HousingApartment hA = null;
		if (userInfo != null) {
			Query q  = em.createQuery("Select h From HousingApartment h JOIN h.userInfo i JOIN h.housingCooperative j where h.userInfo = :userInfo");
			q.setParameter("userInfo", userInfo);
			try {
				hA = (HousingApartment) q.getSingleResult();
			}
			catch(Exception ex) {
				//TODO: Replace me with some kind of logging
				System.out.println(this.getClass().getName() + "-- getHousingApartments(): Error occured: " + ex.getMessage());
				ex.printStackTrace(); 
			}
		}
		return hA;
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.HousingRecord.Repository.DAO.HousingApartmentDAO#removeHousingApartment(com.myProjects.HousingRecord.Domain.HousingApartment)
	 */
	public void removeHousingApartment(HousingApartment apartment)
	{
		if(apartment != null) {
			HousingApartment hA = em.find(HousingApartment.class, apartment.getId());
			
			try {
				em.getTransaction().begin();
				em.remove(hA);
				em.getTransaction().commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			
		}
	}
	
	
}
