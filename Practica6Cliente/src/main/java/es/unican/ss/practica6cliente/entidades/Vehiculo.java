package es.unican.ss.practica6cliente.entidades;

import java.io.Serializable;


public class Vehiculo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String matricula;

	private int potencia;

	private Boolean usoProfesional;
	
	public Vehiculo() {}
	public Vehiculo (String matricula, int potencia, boolean usoProfesional) {
		this.matricula = matricula;
		this.potencia = potencia;
		this.usoProfesional = usoProfesional;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	public Boolean getUsoProfesional() {
		return usoProfesional;
	}
	public void setUsoProfesional(Boolean usoProfesional) {
		this.usoProfesional = usoProfesional;
	}
	
	

}
