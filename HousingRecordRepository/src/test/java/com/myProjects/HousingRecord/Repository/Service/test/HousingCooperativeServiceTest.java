package com.myProjects.HousingRecord.Repository.Service.test;

import static org.junit.Assert.fail;

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
		fail("Not yet implemented");
	}

	@Test
	public void testGetHousingCooperatives() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHousingCooperative() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveHousingCooperative() {
		fail("Not yet implemented");
	}
	
	private HousingCooperative createNewHousingCooperative() {
		HousingCooperative hc = new HousingCooperative();
		hc.setName("Helmi Tommi Landia");
		hc.setAddress("Koukonkuja 3");
		hc.setPostNumber("40400");
		
		return hc;
	}
}
