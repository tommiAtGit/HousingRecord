package com.myProjects.HousingRecord.Repository.Service.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.myProjects.HousingRecord.Domain.UserAddress;
import com.myProjects.HousingRecord.Domain.UserInformation;
import com.myProjects.HousingRecord.Repository.DAO.UserDAOImpl;
import com.myProjects.HousingRecord.Repository.DAOIF.UserDao;
import com.myProjects.HousingRecord.Repository.Service.UserService;
import com.myProjects.HousingRecord.Repository.Service.impl.UserServiceImpl;

public class UserServiceTest {

	private UserService userService;
	private UserDao userD;
	
	@Before
	public void setUp() throws Exception {
		
		userD = new UserDAOImpl("HOUSINGRECORD");
		userService = new UserServiceImpl(userD);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void addUserTest() {
		UserAddress Expected = this.createTestUser();
		
		UserAddress Actual = new UserAddress();
		Actual.setId(-1);
		Actual = userService.addUser(Expected);
		
		assertNotNull(Actual);
		assertNotNull(Actual.getId());
		assertTrue("Id of the addes item:" + Actual.getId(), Actual.getId() != -1);
		
		System.out.println("*****");
		System.out.println("Id value" + Actual.getId());
		System.out.println("*****");
		
		List<UserAddress> actualUsers =  userService.getAllUsers();
		System.out.println("List size:" + actualUsers.size());
		assertTrue("some thing missing", actualUsers.size() == 1);
		
		
	}
	@Ignore
	@Test
	public void testGetUser() {
		
		UserAddress Expected = this.createTestUser();
		UserAddress Actual = new UserAddress();
		Actual.setId(-1);
		Actual = userService.addUser(Expected);
		
		assertNotNull(Actual);
		assertNotNull(Actual.getId());
		assertTrue("Id of the addes item:" + Actual.getId(), Actual.getId() != -1);
		
		System.out.println("*****");
		System.out.println("Id value" + Actual.getId());
		System.out.println("*****");
	
		UserInformation userInfo = userService.getUser(Expected.getUserInformation().getUserName(), Expected.getUserInformation().getPassWord());
		assertNotNull(userInfo);
	}
	
	@Ignore
	@Test
	public void getAllUsersTest() {
		int actualUserCount = 4;
		int itemCount = 0;
		List<UserAddress> expectedUsers = this.CreateTestUsers();
		
		while (itemCount < actualUserCount) {
			UserAddress initalUsers = userService.addUser(expectedUsers.get(itemCount));
			assertNotNull(initalUsers);
			assertNotNull(initalUsers.getId());
			System.out.println("Id value: "+initalUsers.getId());
			itemCount++;
		}
		
		List<UserAddress> actualUsers =  userService.getAllUsers();
		assertTrue("some thing missing", actualUsers.size() != actualUserCount);
		
	}
	
	private UserAddress createTestUser() {
		
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
	/**
	 * This is used to generate some junk test users.
	 * @return
	 */
	private List<UserAddress> CreateTestUsers(){
		
		List<UserAddress> testUsers = new ArrayList<UserAddress>();
		int itemCount  = 0;
		int numberOfItems = 5;
		
		while(itemCount < numberOfItems) {
			UserAddress userAddress = new UserAddress();
			UserInformation userInformation = new UserInformation();
			userInformation.setUserName("PommiUser_"+ numberOfItems);
			userInformation.setPassWord("PommiPass_"+ numberOfItems);
			userInformation.setMessageNotice(numberOfItems);
			userAddress.setUserInformation(userInformation);
			userAddress.setFistName("Tommi_"+ numberOfItems);
			userAddress.setLastName("Pommi_"+ numberOfItems);
			userAddress.setEMail("tommi.pommi"+numberOfItems+"@heittaapmmin.com");
			userAddress.setPhoneNumber("555-12345"+numberOfItems);
			testUsers.add(userAddress);			
			itemCount++;
		}

		
		return testUsers;
	}

}
