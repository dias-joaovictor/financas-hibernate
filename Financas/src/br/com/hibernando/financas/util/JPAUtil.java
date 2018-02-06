package br.com.hibernando.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void close() {
		emf.close();
	}
}
