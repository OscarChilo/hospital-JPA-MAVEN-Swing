package com.bicentenario.hospital.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bicentenario.hospital.model.Medico;
import com.bicentenario.hospital.model.JPAUtil;

public class MedicoDAO {

	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar médico
	public void guardar(Medico medico) {
		entity.getTransaction().begin();
		entity.persist(medico);
		entity.getTransaction().commit();
	}
	
	//Editar médico
	public void editar(Medico medico) {
		entity.getTransaction().begin();
		entity.merge(medico);
		entity.getTransaction().commit();
	}
	
	//Buscar médico
	public Medico buscar(int id) {
		Medico m = new Medico();
		m = entity.find(Medico.class, id);
		
		return m;
	}
	
	//Eliminar médico
	public void eliminar(Integer id) {
		Medico m = new Medico();
		m = entity.find(Medico.class, id);
		entity.getTransaction().begin();
		entity.remove(m);
		entity.getTransaction().commit();
	}
	
	//Obtener a todos los médicos
	
	public List<Medico> obtenerMedicos(){
		List<Medico> listaEnfermedades = new ArrayList<>();
		Query q = entity.createQuery("SELECT m FROM Medico m");
		listaEnfermedades = q.getResultList();
		
		return listaEnfermedades;
	}

}
