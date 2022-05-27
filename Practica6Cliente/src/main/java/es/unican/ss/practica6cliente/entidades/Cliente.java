package es.unican.ss.practica6cliente.entidades;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;




public class Cliente implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	private String dni;
	private String nombre;

	private String email;
	
	private List<Seguro> seguros; 

	private List<Parte> partes;

	public Cliente() { 
		seguros = new LinkedList<>();
		partes = new LinkedList<>();
	}
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
		return dni;
	}
	public void setDNI(String dNI) {
		dni = dNI;
	}
	public List<Seguro> getSeguros() {
		return this.seguros;
	}
	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}
	public List<Parte> getPartes() {
		return this.partes;
	}
	public void setPartes(List<Parte> partes) {
		this.partes = partes;
	}
	public double totalAPagar() {
		double totalAPagar = 0.0;
		for (Seguro s: this.seguros) {
			totalAPagar += s.getPrecio();
		}
		return totalAPagar;
	}
	public boolean anhadeSeguro(Seguro s) {
		if (s != null) {
			return seguros.add(s);
		}
		return false;
	} 

}
