package com.bicentenario.hospital.model;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	//Declaramos la variable con el nombre de la unidad de la persistencia 
	private static final String PERSISTENCE_UNIT_NAME="HospitalUnit";
	
	//creamos una variable de tipo EntityMangerFactory
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		//if(factory==null) {
			
			//Referenciamos la unidad de persistencia para gestionar las entidades
			factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		//}
		return factory;
	}
	public static void shutdown() {
		if(factory!=null) {
			factory.close();
		}
	}
	

}
