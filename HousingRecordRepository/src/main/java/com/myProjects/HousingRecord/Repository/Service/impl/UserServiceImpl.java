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
	
	public List<UserAddress> getAllUsers() {
		
		List<UserAddress> userLst = null;
		
		if (userDao != null) {
			userLst = userDao.getAllUsers();
		}
		else {
			//TODO: Add some kind of loggin here
			System.out.println("Error: UserDAO not found");
		}
		return userLst;
	}

	public UserInformation getUser(String userName, String password) {
		
		UserInformation userInfo = null;
		if (!userName.equals(null)|| !password.equals(null)) {
			userInfo = userDao.getUser(userName, password);
		}
		
		return userInfo;
	}

	public UserAddress addUser(UserAddress theUser) {
		
		UserAddress userAddress = null;
		if (theUser != null) {
			userAddress = userDao.addUser(theUser);
		}
		return userAddress;	
	}

	public void removeUser(UserAddress userAddress) {
		
		if(userAddress != null ) {
			userDao.removeUser(userAddress);
		}
		
	}

}
