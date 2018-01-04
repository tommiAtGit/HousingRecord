package com.myProjects.HousingRecord.Repository.DAOIF;

import java.util.List;

import com.myProjects.HousingRecord.Domain.UserAddress;
import com.myProjects.HousingRecord.Domain.UserInformation;


public interface UserDao {
	
	  	UserAddress addUser(UserAddress userInfo);

	  	List<UserAddress> getAllUsers();

	    UserInformation getUser(String userName, String password);

	    UserInformation removeUser(double userId);

	    UserInformation userLogin(String userName, String password);
}
