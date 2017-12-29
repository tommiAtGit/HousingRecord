package com.myProjects.HousingRecord.Repository.Service.test;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.myProjects.HousingRecord.Domain.UserAddress;
import com.myProjects.HousingRecord.Domain.UserInformation;
import com.myProjects.HousingRecord.Repository.Service.UserService;
import com.myProjects.HousingRecord.Repository.Service.impl.UserServiceImpl;

public class UserServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addUserTest() {
		UserAddress Expected = this.createUserAddress();
		UserService useService = new UserServiceImpl();
		
		UserAddress Actual = useService.addUser(Expected);
		assertNotNull(Actual);
		assertNotNull(Actual.getId());
		
		
		
	}
	
	private UserAddress createUserAddress() {
		
		UserAddress userAddress = new UserAddress();
		userAddress.setFistName("Tommi");
		userAddress.setLastName("Pommi");
		userAddress.setEMail("tommi.pommi@heittaapmmin.com");
		userAddress.setPhoneNumber("555-12345");
		UserInformation userInformation = new UserInformation();
		userInformation.setUserName("PommiUser");
		userInformation.setPassWord("PommiPass");
		userInformation.setMessageNotice(1);
		userAddress.setUserInformation(userInformation);
		return userAddress;
		
	}

}
