package com.bicentenario.hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Enfermedad")
public class Enfermedad {

	@Id
	@Column(name="ID_ENFERMEDAD")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_enfermedad;
	@Column(name="NOMB_ENFERMEDAD")
	private String nomb_enfermedad;
	@Column(name="SINTOMAS")
	private String sintomas;

	public Integer getId_enfermedad() {
		return id_enfermedad;
	}

	public void setId_enfermedad(Integer id_enfermedad) {
		this.id_enfermedad = id_enfermedad;
	}

	public String getNomb_enfermedad() {
		return nomb_enfermedad;
	}

	public void setNomb_enfermedad(String nomb_enfermedad) {
		this.nomb_enfermedad = nomb_enfermedad;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

}
