package com.myProjects.HousingRecord.Repository.Service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.myProjects.HousingRecord.Domain.HousingCooperative;
import com.myProjects.HousingRecord.Repository.DAO.HousingCooperativeDAOImpl;
import com.myProjects.HousingRecord.Repository.DAOIF.HousingCooperativeDAO;
import com.myProjects.HousingRecord.Repository.Service.HousingCooperativeService;
import com.myProjects.HousingRecord.Repository.Service.impl.HousingCooperativeServiceImp;

public class HousingCooperativeServiceTest {

	private HousingCooperativeService hcService;
	private HousingCooperativeDAO hcDAO;
	@Before
	public void setUp() throws Exception {
		
		hcDAO = new HousingCooperativeDAOImpl("HOUSINGRECORD_TEST");
		hcService = new HousingCooperativeServiceImp(hcDAO);
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testAddHousingCooperative() {
		
		HousingCooperative ActualHc = null;
		HousingCooperative ExpectedHc = this.createFirstHousingCooperative();
		
		ActualHc = hcService.addHousingCooperative(ExpectedHc);
		assertNotNull(ActualHc);
		assertTrue("uups", ActualHc.getId() >=1 );
		assertEquals(ExpectedHc.getName(), ActualHc.getName());
	
	}

	@Test
	public void testGetHousingCooperatives() {
		int expectedcount = 2;
		HousingCooperative ActualHc = null;
		HousingCooperative firstExpectedHc = this.createFirstHousingCooperative();
		HousingCooperative secondExpectedHc = this.createSecondHousingCooperative();
		
		ActualHc = hcService.addHousingCooperative(firstExpectedHc);
		assertNotNull(ActualHc);
		assertTrue("uups", ActualHc.getId() >=1 );
		assertEquals(firstExpectedHc.getName(), ActualHc.getName());
		
		ActualHc = hcService.addHousingCooperative(secondExpectedHc);
		assertNotNull(ActualHc);
		assertTrue("uups", ActualHc.getId() >=1 );
		assertEquals(secondExpectedHc.getName(), ActualHc.getName());
		
		List<HousingCooperative> hcList = null;
		
		hcList = hcService.getHousingCooperatives();
		assertNotNull(hcList);
		assertEquals(expectedcount, hcList.size());
		assertEquals(firstExpectedHc.getName(), hcList.get(0).getName());
		assertEquals(secondExpectedHc.getName(), hcList.get(1).getName());
		
	}

	@Test
	public void testGetHousingCooperative() {
		
		HousingCooperative ActualHc = null;
		HousingCooperative ExpectedHc = this.createFirstHousingCooperative();
		
		ActualHc = hcService.addHousingCooperative(ExpectedHc);
		assertNotNull(ActualHc);
		assertTrue("uups", ActualHc.getId() >=1 );
		assertEquals(ExpectedHc.getName(), ActualHc.getName());

		HousingCooperative aHC = null;
		aHC = hcService.getHousingCooperative(ExpectedHc.getAddress());
		assertNotNull(aHC);
		assertTrue("uups", aHC.getId() >=1 );
		assertEquals(ExpectedHc.getName(), aHC.getName());

	}

	@Test
	public void testRemoveHousingCooperative() {
		HousingCooperative ActualHc = null;
		HousingCooperative ExpectedHc = this.createFirstHousingCooperative();
		
		ActualHc = hcService.addHousingCooperative(ExpectedHc);
		assertNotNull(ActualHc);
		assertTrue("uups", ActualHc.getId() >=1 );
		assertEquals(ExpectedHc.getName(), ActualHc.getName());
		
		HousingCooperative aHC = null;
		hcService.removeHousingCooperative(ActualHc);
		aHC = hcService.getHousingCooperative(ExpectedHc.getAddress());
		assertNull(aHC);
	}
	
	private HousingCooperative createFirstHousingCooperative() {
		HousingCooperative hc = new HousingCooperative();
		hc.setName("Helmi Tommi Landia");
		hc.setAddress("Koukonkuja 3");
		hc.setPostNumber("40400");
		hc.setCity("Jyväskylä");
		hc.setBankaccount("123456-234567");
		
		return hc;
	}
	
	private HousingCooperative createSecondHousingCooperative() {
		HousingCooperative hc = new HousingCooperative();
		hc.setName("Mäntlehto");
		hc.setAddress("Koukonkuja 12");
		hc.setPostNumber("40400");
		hc.setCity("Jyväskylä");
		hc.setBankaccount("123456-234567");
		
		return hc;
	}
}
