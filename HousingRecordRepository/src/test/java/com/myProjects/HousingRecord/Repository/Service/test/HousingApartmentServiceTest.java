package com.myProjects.HousingRecord.Repository.Service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.myProjects.HousingRecord.Domain.HousingApartment;
import com.myProjects.HousingRecord.Domain.HousingCooperative;
import com.myProjects.HousingRecord.Domain.UserAddress;
import com.myProjects.HousingRecord.Domain.UserInformation;
import com.myProjects.HousingRecord.Repository.DAO.HousingApartmentDAOImpl;
import com.myProjects.HousingRecord.Repository.DAO.HousingCooperativeDAOImpl;
import com.myProjects.HousingRecord.Repository.DAO.UserDAOImpl;
import com.myProjects.HousingRecord.Repository.DAOIF.HousingApartmentDAO;
import com.myProjects.HousingRecord.Repository.DAOIF.HousingCooperativeDAO;
import com.myProjects.HousingRecord.Repository.DAOIF.UserDao;
import com.myProjects.HousingRecord.Repository.Service.HousingApartmentService;
import com.myProjects.HousingRecord.Repository.Service.HousingCooperativeService;
import com.myProjects.HousingRecord.Repository.Service.UserService;
import com.myProjects.HousingRecord.Repository.Service.impl.HousingApartmentServiceImpl;
import com.myProjects.HousingRecord.Repository.Service.impl.HousingCooperativeServiceImp;
import com.myProjects.HousingRecord.Repository.Service.impl.UserServiceImpl;

public class HousingApartmentServiceTest {

	private HousingApartmentService haService;
	private HousingApartmentDAO apartmentDAO = null;
	private HousingCooperativeDAO cooperateDAO = null;
	private UserDao userDAO = null;
	
	private HousingCooperativeService hcService = null;
	private UserService uService = null;
	private HousingCooperative firstHc = null;
	private HousingCooperative theOtherHc = null;
	
	
	
	@Before
	public void setUp() throws Exception {
		apartmentDAO = new HousingApartmentDAOImpl("HOUSINGRECORD_TEST");
		cooperateDAO = new HousingCooperativeDAOImpl("HOUSINGRECORD_TEST");
		userDAO = new UserDAOImpl("HOUSINGRECORD_TEST");
		haService = new HousingApartmentServiceImpl((HousingApartmentDAO) apartmentDAO);
		hcService = new HousingCooperativeServiceImp((HousingCooperativeDAO) cooperateDAO);
		uService = new UserServiceImpl((UserDAOImpl)userDAO);
		
		firstHc = this.createFirstHc();
		theOtherHc = this.createTheOtherHc();
		
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testAddHousingApartment() {
		HousingApartment haActual = null;
		HousingApartment haExpected = this.createHousingApartment();
		
		haActual = haService.addHousingApartment(haExpected);
		
		assertNotNull(haActual);
		assertEquals(0,haActual.getId());
		assertEquals(haExpected.getApartment(), haActual.getApartment());
		
	}

	@Test
	public void testGetHousingApartment() {
		HousingApartment haActual = null;
		HousingApartment haAdded = null;
		HousingApartment haExpected = this.createHousingApartment();
		
		haActual = haService.addHousingApartment(haExpected);
		
		assertNotNull(haActual);
		assertEquals(0,haActual.getId());
		assertEquals(haExpected.getApartment(), haActual.getApartment());
		
		System.out.println("haCatual: "+ haActual.toString());
		haAdded = haService.getHousingApartment(haActual.getApartment());
		assertNotNull(haAdded);
		assertNull(haAdded.getHousingCooperative());
		assertEquals(haExpected.getHousingCooperative().getName(), haAdded.getHousingCooperative());
		assertNull(haAdded.getUserInformation());
		assertEquals(haExpected.getUserInformation().getUserName(),haAdded.getUserInformation().getUserName());
	}

	@Test
	public void testGetHousingApartmentsOfHousingCooperative() {
	
		this.createHousingTopology();
		HousingCooperative expectedHc  = firstHc;
		System.out.println("Fist hc: " + expectedHc.toString()+ "With Id: " + expectedHc.getId() +"With address: " + expectedHc.getAddress());
		List<HousingApartment> haList = haService.getHousingApartmentsOfHousingCooperative(expectedHc);
		
		assertNotNull(haList);
		assertEquals(3,haList.size());
		for (HousingApartment hA : haList) {
			assertEquals(expectedHc.getName(), hA.getHousingCooperative().getName());
			assertEquals(expectedHc.getBankaccount(), hA.getHousingCooperative().getBankaccount());
		}
		

	}

	@Test
	public void testGetHousingApartmentOfUser() {
		fail("Not yet implemented");
	}


	@Test
	public void testRemoveHousingApartment() {
		this.createHousingTopology();
		HousingCooperative expectedHc  = firstHc;
		
		List<HousingApartment> haList = haService.getHousingApartmentsOfHousingCooperative(expectedHc);
		assertNotNull(haList);
		assertEquals(3,haList.size());
		for (HousingApartment hA : haList) {
			assertEquals(expectedHc.getName(), hA.getHousingCooperative().getName());
			assertEquals(expectedHc.getBankaccount(), hA.getHousingCooperative().getBankaccount());
		}
		//Remove one housing apartment
		haService.removeHousingApartment(haList.get(0));
		List<HousingApartment> haActualList = haService.getHousingApartmentsOfHousingCooperative(expectedHc);
		assertNotNull(haActualList);
		assertEquals(2,haActualList.size());
		for (HousingApartment hA : haActualList) {
			assertEquals(expectedHc.getName(), hA.getHousingCooperative().getName());
			assertEquals(expectedHc.getBankaccount(), hA.getHousingCooperative().getBankaccount());
		}
		
		
	}
	
	private HousingCooperative createFirstHc() {
		HousingCooperative hc = new HousingCooperative();
		hc.setName("Helmi Tommi Landia");
		hc.setAddress("Koukonkuja 3");
		hc.setPostNumber("40400");
		hc.setCity("Jyväskylä");
		hc.setBankaccount("123456-234567");
		
		hc = hcService.addHousingCooperative(hc);
		HousingCooperative NewHc = hcService.getHousingCooperative(hc.getAddress());
		System.out.println("Fist hc: " + NewHc.toString()+ "With Id: " + NewHc.getId());
		return NewHc;
	}
	
	private HousingCooperative createTheOtherHc() {
		HousingCooperative hc = new HousingCooperative();
		hc.setName("Mäntylehto");
		hc.setAddress("Koukonkuja 12");
		hc.setPostNumber("40400");
		hc.setCity("Jyväskylä");
		hc.setBankaccount("123456-234567");
		
		hc = hcService.addHousingCooperative(hc);
		HousingCooperative NewHc = hcService.getHousingCooperative(hc.getAddress());
		System.out.println("The Other hc: " + NewHc.toString()+ "With Id: " + NewHc.getId());
		
		return NewHc;
		
	}
	
	private void createHousingTopology() {
		
		HousingApartment haActual = null;
		HousingApartment haActual2 = null;
		HousingApartment haActual3 = null;
		HousingApartment haActualOther = null;
		HousingApartment haExpected = this.createHousingApartment();
		HousingApartment haExpected2 = this.createSecondHousingApartment();
		HousingApartment haExpected3 = this.createThirdHousingApartment();
		HousingApartment haExpectedOther = this.createHousingApartmentWitOtherCooperative();
		
		haActual = haService.addHousingApartment(haExpected);
		assertNotNull(haActual);
		assertEquals(0,haActual.getId());
		assertEquals(haExpected.getApartment(), haActual.getApartment());

		haActual2 = haService.addHousingApartment(haExpected2);
		assertNotNull(haActual2);
		assertEquals(0,haActual2.getId());
		assertEquals(haExpected2.getApartment(), haActual2.getApartment());
		
		haActual3 = haService.addHousingApartment(haExpected3);
		assertNotNull(haActual3);
		assertEquals(0,haActual3.getId());
		assertEquals(haExpected3.getApartment(), haActual3.getApartment());
		
		haActualOther = haService.addHousingApartment(haExpectedOther);
		assertNotNull(haActualOther);
		assertEquals(0,haActualOther.getId());
		assertEquals(haExpectedOther.getApartment(), haActualOther.getApartment());
	}
	

	
	private HousingApartment createHousingApartment() {
		
		//Create and save userInfomation
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
		UserAddress theU = uService.addUser(userAddress);
		if (theU != null)
		{
			HousingApartment apartment = new HousingApartment();
			apartment.setApartment("A 3");
			apartment.setHousingCooperative(firstHc);
			apartment.setUserInformation(theU.getUserInformation());
			return apartment;
		}
		else {
			return null;
		}
		
	}
	private HousingApartment createSecondHousingApartment() {
			
		UserAddress userAddress = new UserAddress();
		userAddress.setFistName("Jari");
		userAddress.setLastName("Pari");
		userAddress.setEMail("jari.pari@kiekonsoi.com");
		userAddress.setPhoneNumber("555-23456");
		UserInformation userInformation = new UserInformation();
		userInformation.setUserName("JARIUser");
		userInformation.setPassWord("JariPass");
		userInformation.setMessageNotice(1);
		userAddress.setUserInformation(userInformation);
		UserAddress theU = uService.addUser(userAddress);
		
		if (theU != null)
		{
			HousingApartment apartment = new HousingApartment();
			apartment.setApartment("B 2");
			apartment.setHousingCooperative(firstHc);
			apartment.setUserInformation(theU.getUserInformation());
			
			return apartment;
		}
		else {
			return null;
		}
		
	}
	
	private HousingApartment createThirdHousingApartment() {
			
		UserAddress userAddress = new UserAddress();
		userAddress.setFistName("Mikko");
		userAddress.setLastName("Kikko");
		userAddress.setEMail("mikko.kikko@kellonsoi.com");
		userAddress.setPhoneNumber("555-3454567");
		UserInformation userInformation = new UserInformation();
		userInformation.setUserName("MikkoUser");
		userInformation.setPassWord("MikkoPass");
		userInformation.setMessageNotice(1);
		userAddress.setUserInformation(userInformation);
		UserAddress theU = uService.addUser(userAddress);
		
		if (theU != null) {
			HousingApartment apartment = new HousingApartment();
			apartment.setApartment("C 2");
			apartment.setHousingCooperative(firstHc);
			apartment.setUserInformation(theU.getUserInformation());
			
			return apartment;

		}
		else {
			return null;
		}
		
}
	
	private HousingApartment createHousingApartmentWitOtherCooperative() {
		
		UserAddress userAddress = new UserAddress();
		userAddress.setFistName("Tar");
		userAddress.setLastName("Juzkaja");
		userAddress.setEMail("tar.juzkaja@ope.com");
		userAddress.setPhoneNumber("555-345673");
		UserInformation userInformation = new UserInformation();
		userInformation.setUserName("TarjaUser");
		userInformation.setPassWord("TarjaPass");
		userInformation.setMessageNotice(1);
		userAddress.setUserInformation(userInformation);
		UserAddress theU = uService.addUser(userAddress);
		
		if (theU != null) {
			HousingApartment apartment = new HousingApartment();
			apartment.setApartment("A 1");
			apartment.setHousingCooperative(theOtherHc);
			apartment.setUserInformation(theU.getUserInformation());
			
			return apartment;
		}
		else {
			return null;
		}
	}
}
