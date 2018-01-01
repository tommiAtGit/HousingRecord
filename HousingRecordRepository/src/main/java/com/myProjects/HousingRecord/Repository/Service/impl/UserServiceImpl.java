package com.myProjects.HousingRecord.Repository.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myProjects.HousingRecord.Domain.UserAddress;
import com.myProjects.HousingRecord.Domain.UserInformation;
import com.myProjects.HousingRecord.Repository.DAOIF.UserDao;
import com.myProjects.HousingRecord.Repository.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	public UserInformation userLogIn(String userName, String password) {
		UserInformation userInfo = null;
		
		if (!userName.equals(null)|| !password.equals(null)) {
			userInfo = userDao.userLogin(userName, password);
		}
		else {
			userInfo = null;
		}
			
		return userInfo;
	}
	
	public List<UserInformation> getAllUsers() {
		
		List<UserInformation> userLst = null;
		
		if (userDao != null) {
			userLst = userDao.getAllUsers();
		}
		else {
			//TODO: Add some kind of loggin here
			System.out.println("Error: UserDAO not found");
		}
		return userLst;
	}

	public UserAddress getUser(String userName, String password) {
		
		UserAddress userAdr = null;
		if (!userName.equals(null)|| !password.equals(null)) {
			userAdr = userDao.getUser(userName, password);
		}
		
		return userAdr;
	}

	public UserAddress addUser(UserAddress theUser) {
		
		UserAddress userAddress = null;
		if (theUser != null) {
			userAddress = userDao.addUser(theUser);
		}
		return userAddress;	
	}

	public UserInformation removeUser(double userId) {
		
		UserInformation userInfo = null;
		if(userId >= 0 ) {
			userInfo = userDao.removeUser(userId);
		}
		return userInfo;
	}

}
