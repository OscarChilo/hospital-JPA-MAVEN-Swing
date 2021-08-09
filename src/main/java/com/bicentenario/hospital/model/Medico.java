package com.bicentenario.hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Medico")
public class Medico {
	@Id
	@Column(name="ID_MEDICO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_medico;
	@Column(name="NOMBRES")
	private String nombres;
	@Column(name="APELLIDOS")
	private String apellidos;
	@Column(name="ESPECIALIDAD")
	private String especialidad;
	@Column(name="TELEFONO")
	private String telefono;
	
	public Integer getId_medico() {
		return id_medico;
	}
	public void setId_medico(Integer id_medico) {
		this.id_medico = id_medico;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres_medico) {
		this.nombres = nombres_medico;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}