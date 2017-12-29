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

		try {
			em.persist(userAddress);
			em.getTransaction().commit();
		}
		catch(Exception ex) {
			//Do some thing
		}
		
		
	    return userAddress;
	    
	}

	@SuppressWarnings("unchecked")
	public List<UserInformation> getAllUsers() {
		
		Query q = em.createQuery("Select u From UserInfo UInfo");
		List<UserInformation> userInfoList = q.getResultList();
		  
		return userInfoList;
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
