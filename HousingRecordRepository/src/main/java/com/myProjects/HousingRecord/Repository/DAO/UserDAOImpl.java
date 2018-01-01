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

	public UserInformation addUser(UserInformation userAddress) {

		if (userAddress != null) {
			try {
				
				em.getTransaction().begin();
				em.persist(userAddress);
				em.getTransaction().commit();
				em.close();
			}
			catch(Exception ex) {
				//TODO: Replace me with some kind of logging
				System.out.println(this.getClass().getName() + ": Error occured: " + ex.getMessage());
			}
			return userAddress;
		}
		else {
			System.out.println(this.getClass().getName() + ": Error occured: UserAddress is null");
			return null;
		}
	    
	}

	public UserAddress addUser(UserAddress userAddress) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInformation> getAllUsers() {
		
		Query q = em.createQuery("Select u From UserInformation u");
		List<UserInformation> userInfoList = q.getResultList();
		  
		return userInfoList;
	}

	public UserInformation getUser(String userName, String password) {
		
		Query q  = em.createQuery("Select u From UserInformation u where u.userName :userName AND u.passWord = :password");
		
		UserInformation userInfo  = (UserInformation) q.getSingleResult(); 
		
		return userInfo;
	}

	public UserInformation removeUser(double userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserInformation userLogin(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}


}
