package com.myProjects.HousingRecord.Repository.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.myProjects.HousingRecord.Domain.UserAddress;
import com.myProjects.HousingRecord.Domain.UserInformation;
import com.myProjects.HousingRecord.Repository.DAOIF.UserDao;

@Transactional
public class UserDAOImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;
	
	public UserAddress addUser(UserAddress userAddress) {

		try {
			em.persist(userAddress);
		}
		catch(Exception ex) {
			//Do some thing
		}
		
		
	    return userAddress;
	    
	}

	public List<UserInformation> getAllUsers() {
		// TODO Auto-generated method stub
		  
		return null;
	}

	public UserAddress getUser(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
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
