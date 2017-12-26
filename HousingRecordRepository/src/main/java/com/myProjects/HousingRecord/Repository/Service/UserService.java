package com.myProjects.HousingRecord.Repository.Service;

import java.util.List;

import com.myProjects.HousingRecord.Domain.UserAddress;
import com.myProjects.HousingRecord.Domain.UserInformation;

public interface UserService {

	public UserInformation userLogIn(String userName, String password);
	public List<UserInformation> getAllUsers();
	public UserAddress getUser(String userName, String password);
	public UserAddress addUser(UserAddress theUser);
	public UserInformation removeUser(double userId);
	
	
	
}
