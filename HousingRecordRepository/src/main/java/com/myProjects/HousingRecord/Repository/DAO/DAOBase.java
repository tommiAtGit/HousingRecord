package com.myProjects.HousingRecord.Repository.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class DAOBase {
	
	@PersistenceContext
	protected EntityManager em;
	private static EntityManagerFactory factory;
	
	public DAOBase(String persistenceUnit) {
		factory = Persistence.createEntityManagerFactory(persistenceUnit);
		em = factory.createEntityManager();
		
	}
	public void closeEntityFactory() {
		//factory.close();
	}
	
}
