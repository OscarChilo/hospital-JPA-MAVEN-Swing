package com.bicentenario.hospital.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Paciente")
public class Paciente {
	@Id
	@Column(name="ID_PACIENTE")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_paciente;
	@Column(name="DNI")
	private String dni;
	@Column(name="NOMBRES")
	private String nomb_paciente;
	@Column(name="APELLIDOS")
	private String Apell_paciente;
	@Column(name="FNACIMIENTO")
	private Date fech_nacimiento;
	@Column(name="EDAD")
	private int edad;
	@Column(name="TELEFONO")
	private String telefono;

	public Integer getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Integer id_paciente) {
		this.id_paciente = id_paciente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomb_paciente() {
		return nomb_paciente;
	}

	public void setNomb_paciente(String nomb_paciente) {
		this.nomb_paciente = nomb_paciente;
	}

	public String getApell_paciente() {
		return Apell_paciente;
	}

	public void setApell_paciente(String apell_paciente) {
		Apell_paciente = apell_paciente;
	}

	public Date getFech_nacimiento() {
		return fech_nacimiento;
	}

	public void setFech_nacimiento(Date fech_nacimiento) {
		this.fech_nacimiento = fech_nacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/*@Override
	public String toString() {
		return "Paciente [id_paciente=" + id_paciente + ", dni=" + dni + ", nomb_paciente=" + nomb_paciente
				+ ", Apell_paciente=" + Apell_paciente + ", edad=" + edad + ", telefono=" + telefono + "]";
	}*/

}
