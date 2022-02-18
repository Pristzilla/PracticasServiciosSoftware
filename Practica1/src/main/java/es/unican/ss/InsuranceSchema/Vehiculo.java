package es.unican.ss.InsuranceSchema;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Vehiculo implements Serializable {

	private static final long serialVersionUID = 1L;
	@XmlAttribute(required= true)
	@XmlID
	private String matricula;
	@XmlAttribute(required= true)
	private int potencia;
	@XmlAttribute(required= true)
	private Boolean usoProfesional;
	
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
