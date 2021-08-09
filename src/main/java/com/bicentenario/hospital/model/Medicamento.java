package com.bicentenario.hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Medicamento")
public class Medicamento {
	@Id
	@Column(name="ID_MEDICAMENTO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_medicamento;
	@Column(name="NOMB_MEDICAMENTO")
	private String nomb_medicamento;
	
	public Integer getId_medicamento() {
		return id_medicamento;
	}
	public void setId_medicamento(Integer id_medicamento) {
		this.id_medicamento = id_medicamento;
	}
	public String getNomb_medicamento() {
		return nomb_medicamento;
	}
	public void setNomb_medicamento(String nomb_medicamento) {
		this.nomb_medicamento = nomb_medicamento;
	}
	
}