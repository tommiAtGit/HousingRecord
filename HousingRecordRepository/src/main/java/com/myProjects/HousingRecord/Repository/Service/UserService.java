package com.myProjects.HousingRecord.Repository.Service;

import java.util.List;

import com.myProjects.HousingRecord.Domain.UserAddress;
import com.myProjects.HousingRecord.Domain.UserInformation;

public interface UserService {

	public UserInformation userLogIn(String userName, String password);
	public List<UserAddress>  getAllUsers();
	public UserInformation getUser(String userName, String password);
	public UserAddress addUser(UserAddress theUser);
	public void removeUser(UserAddress userAddress);
	
	
	
}
