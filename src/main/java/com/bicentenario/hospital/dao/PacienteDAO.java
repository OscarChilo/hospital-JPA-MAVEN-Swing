package com.bicentenario.hospital.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bicentenario.hospital.model.JPAUtil;
import com.bicentenario.hospital.model.Paciente;

public class PacienteDAO {
	
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar Paciente
	public void guardar(Paciente paciente) {
		entity.getTransaction().begin();
		entity.persist(paciente);
		entity.getTransaction().commit();
	}
	
	//Editar  Paciente
	public void editar(Paciente paciente) {
		entity.getTransaction().begin();
		entity.merge(paciente);
		entity.getTransaction().commit();
	}
	
	//Buscar Paciente
	public Paciente buscar(int id) {
		Paciente p= new Paciente();
		p=entity.find(Paciente.class, id);
		
		return p;
	}
	
	//Eliminar paciente
	public void eliminar(Integer id) {
		Paciente p=new Paciente();
		p=entity.find(Paciente.class, id);
		entity.getTransaction().begin();
		entity.remove(p);
		entity.getTransaction().commit();
	}
	
	//Obtener todos los pacientess 
	
	public List<Paciente> obtenerPacientes(){
		List<Paciente> listaPacientes=new ArrayList<>();
		Query q=entity.createQuery("SELECT p FROM Paciente p");
		listaPacientes=q.getResultList();
		
		return listaPacientes;
	}
	

}
