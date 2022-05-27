package es.unican.ss.practica6cliente.entidades;

import java.util.Date;



public class Parte {

	private Long id;
	
	private Seguro seguro;
	
	private double importe;
	
	private Date fecha;
	
	public Parte() { /* constructor vacio */ }
	
	public Seguro getSeguro() {
		return seguro;
	}
	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
