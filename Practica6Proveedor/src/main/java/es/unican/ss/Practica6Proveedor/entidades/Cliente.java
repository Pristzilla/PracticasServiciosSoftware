package es.unican.ss.Practica6Proveedor.entidades;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class Cliente implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	private String dni;
	private String nombre;

	private String email;
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="Cliente_FK")
	private List<Seguro> seguros; 

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="Cliente_FK")
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
	public double getTotalAPagar() {
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
