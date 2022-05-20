package es.unican.ss.Practica6Proveedor.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


@Entity
public abstract class Seguro implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected String id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Vehiculo_FK")
	protected Vehiculo vehiculoAsegurado;
	@Transient
	protected double precio;

	protected Seguro() {}
	protected Seguro (String id, Vehiculo vehiculoAsegurado) {
		this.id = id;
		this.vehiculoAsegurado = vehiculoAsegurado;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public abstract double getPrecio();
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Vehiculo getVehiculoAsegurado() {
		return vehiculoAsegurado;
	}
	public void setVehiculoAsegurado(Vehiculo vehiculoAsegurado) {
		this.vehiculoAsegurado = vehiculoAsegurado;
	}

	
}
