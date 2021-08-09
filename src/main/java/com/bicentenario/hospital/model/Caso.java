package com.bicentenario.hospital.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Caso")
public class Caso {

	@Id
	@Column(name="ID_CASO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_caso;
	
	@Column(name="ID_PACIENTE")
	private Integer id_paciente;
	
	@Column(name="APELLIDOS")
	private String apellidos;
	
	@Column(name="ID_ENFERMEDAD")
	private  Integer id_enfermedad;
	
	@Column(name="NOMB_ENFERMEDAD")
	private String nomb_enfermedad;
	
	@Column(name="ID_MEDICO")
	private Integer id_medico;
	
	@Column(name="ID_MEDICAMENTO")
	private Integer id_medicamento;
	
	@Column(name="TEMPERATURA")
	private double temperatura;
	
	@Column(name="SATURACION")
	private int saturacion;
	
	@Column(name="FECHA")
	private Date fecha;

	public Integer getId_caso() {
		return id_caso;
	}

	public void setId_caso(Integer id_caso) {
		this.id_caso = id_caso;
	}

	public Integer getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Integer id_paciente) {
		this.id_paciente = id_paciente;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

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

	public Integer getId_medico() {
		return id_medico;
	}

	public void setId_medico(Integer id_medico) {
		this.id_medico = id_medico;
	}

	public Integer getId_medicamento() {
		return id_medicamento;
	}

	public void setId_medicamento(Integer id_medicamento) {
		this.id_medicamento = id_medicamento;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public int getSaturacion() {
		return saturacion;
	}

	public void setSaturacion(int saturacion) {
		this.saturacion = saturacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
