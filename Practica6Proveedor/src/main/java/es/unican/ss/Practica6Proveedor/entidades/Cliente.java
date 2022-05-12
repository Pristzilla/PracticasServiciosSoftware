package es.unican.ss.Practica6Proveedor.entidades;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import org.springframework.data.annotation.Id;




@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	
	private String email;
	@Id
	private String DNI;
	
	private List<Seguro> seguros; 
	
	private List<Parte> partes;
	
	public Cliente() { /* constructor vacio */ }
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public List<Seguro> getSeguros() {
		if(seguros == null) {
			seguros = new LinkedList<>();
		}
		return this.seguros;
	}
	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}
	public List<Parte> getPartes() {
		if(partes == null) {
			partes = new LinkedList<>();
		}
		return this.partes;
	}
	public void setPartes(List<Parte> partes) {
		this.partes = partes;
	}
	public double getTotalAPagar() {
		// TODO Auto-generated method stub
		return 0;
	} 
	
}
