package es.unican.ss.practica6cliente.entidades;

import java.io.Serializable;


public abstract class Seguro implements Serializable {

	private static final long serialVersionUID = 1L;
	protected int id;
	protected Vehiculo vehiculoAsegurado;
	protected double precio;

	protected Seguro() {}
	protected Seguro (int id, Vehiculo vehiculoAsegurado) {
		this.id = id;
		this.vehiculoAsegurado = vehiculoAsegurado;
	}
	protected Seguro(Vehiculo vehiculoAsegurado) {
		this.vehiculoAsegurado = vehiculoAsegurado;
	}
	public int Id() {
		return id;
	}
	public void setId(int id) {
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

	@Override
	public String toString() {
		return "Seguro: " + this.id + ".\t Vehiculo: " + this.vehiculoAsegurado.getMatricula() + ". Precio: " + this.precio + "€.\n";
	}

	
}
