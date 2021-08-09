package com.bicentenario.hospital.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bicentenario.hospital.model.Caso;
import com.bicentenario.hospital.model.JPAUtil;

public class CasoDAO {
	
EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar Caso
	public void guardar(Caso caso) {
		entity.getTransaction().begin();
		entity.persist(caso);
		entity.getTransaction().commit();
	}
	
	//Buscar Caso
	public Caso buscar(int id) {
		Caso c= new Caso();
		c=entity.find(Caso.class, id);
		
		return c;
	}
	//buscar caso por paciente
	@SuppressWarnings("unchecked")
	public List<Caso> listaCasos(int id) {
		List<Caso> listacasos=new ArrayList<>();
		Query query = entity.createQuery("SELECT c FROM Caso c WHERE c.id_paciente LIKE:id_paciente").setParameter("id_paciente", id);
	
		listacasos = query.getResultList();
		
		return listacasos;
	}
	//Eliminar Caso
	public void eliminar(Integer id) {
		Caso c=new Caso();
		c=entity.find(Caso.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}
	
	//Obtener todos los Caso
	
	@SuppressWarnings("unchecked")
	public List<Caso> obtenerCasos(){
		List<Caso> listaCasos=new ArrayList<>();
		Query q=entity.createQuery("SELECT c FROM Caso c");
		listaCasos=q.getResultList();
		
		return listaCasos;
	}

	@SuppressWarnings("unchecked")
	public List<Caso> listaTemp(int id) {
		List<Caso> listatemperatura=new ArrayList<>();
		Query queryt = entity.createQuery("SELECT c.temperatura FROM Caso c WHERE c.id_paciente LIKE:id_paciente").setParameter("id_paciente", id);
		
		listatemperatura = queryt.getResultList();
		return listatemperatura;
	}

	@SuppressWarnings("unchecked")
	public List<Caso> listaSatu(int id) {
		List<Caso> listasaturacion=new ArrayList<>();
		Query querys = entity.createQuery("SELECT c.saturacion FROM Caso c WHERE c.id_paciente LIKE :id_paciente").setParameter("id_paciente", id);
		
		listasaturacion = querys.getResultList();
		return listasaturacion;
	}

}
