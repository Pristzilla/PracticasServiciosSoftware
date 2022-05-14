package es.unican.ss.Practica6Proveedor.entidades;

import java.io.Serializable;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Vehiculo")
public class Vehiculo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
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
