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

	@Autowired UserDao userDao;
	
	
	@Transactional
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
	@Transactional
	public List<UserInformation> getAllUsers() {
		
		List<UserInformation> userLst = userDao.getAllUsers();
		
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
