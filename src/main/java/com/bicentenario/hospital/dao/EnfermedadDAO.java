package com.bicentenario.hospital.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bicentenario.hospital.model.Enfermedad;
import com.bicentenario.hospital.model.JPAUtil;

public class EnfermedadDAO {
	
EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar enfermedad
	public void guardar(Enfermedad enfermedad) {
		entity.getTransaction().begin();
		entity.persist(enfermedad);
		entity.getTransaction().commit();
	}
	
	//Editar enfermedad
	public void editar(Enfermedad enfermedad) {
		entity.getTransaction().begin();
		entity.merge(enfermedad);
		entity.getTransaction().commit();
	}
	
	//Buscar enfermedad
	public Enfermedad buscar(int id) {
		Enfermedad e = new Enfermedad();
		e =entity.find(Enfermedad.class, id);
		
		return e;
	}
	
	//Eliminar enfermedad
	public void eliminar(Integer id) {
		Enfermedad e=new Enfermedad();
		e = entity.find(Enfermedad.class, id);
		entity.getTransaction().begin();
		entity.remove(e);
		entity.getTransaction().commit();
	}
	
	//Obtener todas las enfermedades
	
	public List<Enfermedad> obtenerEnfermedades(){
		List<Enfermedad> listaEnfermedades=new ArrayList<>();
		Query q=entity.createQuery("SELECT e FROM Enfermedad e");
		listaEnfermedades=q.getResultList();
		
		return listaEnfermedades;
	}
	
	public List<Enfermedad> obtenerNombres(){
		List<Enfermedad> lista=new ArrayList<>();
		Query q=entity.createQuery("SELECT e.nomb_enfermedad FROM Enfermedad e");
		lista=q.getResultList();
		
		return lista;
	}

}
