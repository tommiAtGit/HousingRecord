package com.myProjects.HousingRecord.Repository.DAO;

import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.myProjects.HousingRecord.Domain.UserAddress;
import com.myProjects.HousingRecord.Domain.UserInformation;
import com.myProjects.HousingRecord.Repository.DAOIF.UserDao;

@Transactional
public class UserDAOImpl extends DAOBase implements UserDao {


	public UserDAOImpl(String persistenceUnit) {
		super(persistenceUnit);
	}

	public UserAddress addUser(UserAddress userAddress) {

		if (userAddress != null) {
			try {
				
				em.getTransaction().begin();
				em.persist(userAddress);
				em.getTransaction().commit();
				//em.close();
				
			}
			catch(Exception ex) {
				//TODO: Replace me with some kind of logging
				System.out.println(this.getClass().getName() + "-- addUser(): Error occured: " + ex.getMessage());
				ex.printStackTrace();
				
			}
			return userAddress;
		}
		else {
			System.out.println(this.getClass().getName() + ": Error occured: UserAddress is null");
			return null;
		}
	    
	}
	
	@SuppressWarnings("unchecked")
	public List<UserAddress> getAllUsers() {
		
		List<UserAddress> userAddressList = null;
		Query q = em.createQuery("SELECT u FROM UserAddress u JOIN u.userInformation i");
		
		try {
			 userAddressList = q.getResultList();	
		}
		catch(Exception ex) {
			//TODO: Replace me with some kind of logging
			System.out.println(this.getClass().getName() + "-- getUser(): Error occured: " + ex.getMessage());
			ex.printStackTrace();  
		}
		return userAddressList;
	}

	public UserInformation getUser(String userName, String password) {
		
		UserInformation userInfo=null;
		
		Query q  = em.createQuery("Select u From UserInformation u where u.userName = :userName AND u.passWord = :password");
		try {
			userInfo  = (UserInformation) q.getSingleResult();	
		}
		catch(Exception ex) {
			//TODO: Replace me with some kind of logging
			System.out.println(this.getClass().getName() + "-- getUser(): Error occured: " + ex.getMessage());
			ex.printStackTrace(); 
		}
		return userInfo;
	}

	public void removeUser(UserAddress userAddress) {
		
		if(userAddress != null) {
			UserAddress uA = em.find(UserAddress.class, userAddress.getId());
			
			try {
				em.getTransaction().begin();
				em.remove(uA);
				em.getTransaction().commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			
		}
	}

	public UserInformation userLogin(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
