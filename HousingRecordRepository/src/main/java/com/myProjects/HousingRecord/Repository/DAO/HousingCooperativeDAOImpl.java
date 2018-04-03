package com.myProjects.HousingRecord.Repository.DAO;

import java.util.List;

import javax.persistence.Query;

import com.myProjects.HousingRecord.Domain.HousingCooperative;
import com.myProjects.HousingRecord.Repository.DAOIF.HousingCooperativeDAO;

public class HousingCooperativeDAOImpl extends DAOBase implements HousingCooperativeDAO {
	
	public HousingCooperativeDAOImpl(String persistenceUnit) {
		super(persistenceUnit);
	}

	/* (non-Javadoc)
	 * @see com.myProjects.HousingRecord.Repository.DAO.HousingCooperativeDAO#addHousingCooperative(com.myProjects.HousingRecord.Domain.HousingCooperative)
	 */

	public HousingCooperative addHousingCooperative(HousingCooperative cooperative) {

		if (cooperative != null) {
			try {
				
				em.getTransaction().begin();
				em.persist(cooperative);
				em.getTransaction().commit();
				//em.close();
				
			}
			catch(Exception ex) {
				//TODO: Replace me with some kind of logging
				System.out.println(this.getClass().getName() + "-- addUser(): Error occured: " + ex.getMessage());
				ex.printStackTrace();
				
			}
			return cooperative;
		}
		else {
			System.out.println(this.getClass().getName() + ": Error occured: UserAddress is null");
			return null;
		}
	    
	}
	/* (non-Javadoc)
	 * @see com.myProjects.HousingRecord.Repository.DAO.HousingCooperativeDAO#getHousingCooperatives()
	 */

	@SuppressWarnings("unchecked")
	public List<HousingCooperative> getHousingCooperatives() {
		
		List<HousingCooperative> housingCooperativeList = null;
		Query q = em.createQuery("FROM HousingCooperative");
												
		
		try {
			housingCooperativeList = q.getResultList();	
		}
		catch(Exception ex) {
			//TODO: Replace me with some kind of logging
			System.out.println(this.getClass().getName() + "-- getHousingCooperatives(): Error occured: " + ex.getMessage());
			ex.printStackTrace();  
		}
		return housingCooperativeList;
	}

	/* (non-Javadoc)
	 * @see com.myProjects.HousingRecord.Repository.DAO.HousingCooperativeDAO#getHousingCooperative(java.lang.String)
	 */
	public HousingCooperative getHousingCooperative(String address) {
		
		HousingCooperative hc=null;
		if (!address.isEmpty() || !(address==null)) {
			
			Query q  = em.createQuery("Select h From HousingCooperative h where h.address = :address");
			q.setParameter("address", address);
			try {
				hc  = (HousingCooperative) q.getSingleResult();	
			}
			catch(Exception ex) {
				//TODO: Replace me with some kind of logging
				System.out.println(this.getClass().getName() + "-- getHousingCooperative(): Error occured: " + ex.getMessage());
				ex.printStackTrace(); 
			}
		}

		return hc;
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.HousingRecord.Repository.DAO.HousingCooperativeDAO#removeHousingCooperative(com.myProjects.HousingRecord.Domain.HousingCooperative)
	 */

	public void removeHousingCooperative(HousingCooperative cooperative) {
		
		if(cooperative != null) {
			HousingCooperative hc = em.find(HousingCooperative.class, cooperative.getId());
			
			try {
				em.getTransaction().begin();
				em.remove(hc);
				em.getTransaction().commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			
		}
	}
}
