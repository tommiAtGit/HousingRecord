package com.myProjects.HousingRecord.Repository.Service.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.myProjects.HousingRecord.Domain.HousingApartment;
import com.myProjects.HousingRecord.Domain.HousingCooperative;
import com.myProjects.HousingRecord.Domain.UserInformation;

public class HousingApartmentServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHousingApartmentServiceImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddHousingApartment() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHousingApartment() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHousingApartmentsOfHousingCooperative() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHousingApartmentOfUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveHousingApartment() {
		fail("Not yet implemented");
	}
	
	private HousingApartment createHousingApartment() {
		
		HousingCooperative hc = new HousingCooperative();
		hc.setName("Helmi Tommi Landia");
		hc.setAddress("Koukonkuja 3");
		hc.setPostNumber("40400");
		hc.setCity("Jyväskylä");
		hc.setBankaccount("123456-234567");
		
		UserInformation userInformation = new UserInformation();
		userInformation.setUserName("PommiUser");
		userInformation.setPassWord("PommiPass");
		
		HousingApartment apartment = new HousingApartment();
		apartment.setApartment("A 3");
		apartment.setHousingCooperative(hc);
		apartment.setUserInformation(userInformation);
		
		return apartment;
	}

}
