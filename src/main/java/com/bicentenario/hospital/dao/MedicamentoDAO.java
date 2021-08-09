package com.bicentenario.hospital.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bicentenario.hospital.model.Medicamento;
import com.bicentenario.hospital.model.JPAUtil;

public class MedicamentoDAO {

EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar Medicamento
	public void guardar(Medicamento medicamento) {
		entity.getTransaction().begin();
		entity.persist(medicamento);
		entity.getTransaction().commit();
	}
	
	//Editar Medicamento
	public void editar(Medicamento medicamento) {
		entity.getTransaction().begin();
		entity.merge(medicamento);
		entity.getTransaction().commit();
	}
	
	//Buscar Medicamento
	public Medicamento buscar(int id) {
		Medicamento m = new Medicamento();
		m =entity.find(Medicamento.class, id);
		
		return m;
	}
	
	//Eliminar Medicamento
	public void eliminar(Integer id) {
		Medicamento m = new Medicamento();
		m = entity.find(Medicamento.class, id);
		entity.getTransaction().begin();
		entity.remove(m);
		entity.getTransaction().commit();
	}
	
	//Obtener tods los Medicamentos
	public List<Medicamento> obtenerMedicamentos(){
		List<Medicamento> listaMedicamentos = new ArrayList<>();
		Query q = entity.createQuery("SELECT m FROM Medicamento m");
		listaMedicamentos = q.getResultList();
		
		return listaMedicamentos;
	}

}