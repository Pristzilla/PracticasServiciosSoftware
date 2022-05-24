package es.unican.ss.Practica6Proveedor.dtos;


import es.unican.ss.Practica6Proveedor.entidades.Seguro;
import es.unican.ss.Practica6Proveedor.entidades.Terceros;
import es.unican.ss.Practica6Proveedor.entidades.TodoRiesgo;
import es.unican.ss.Practica6Proveedor.entidades.TodoRiesgoFranquicia;
import es.unican.ss.Practica6Proveedor.entidades.Vehiculo;


public class SeguroDTO {

	private Vehiculo vehiculo;
	private String tipo;
	private Seguro seguro;

	public SeguroDTO() {
	}
	public SeguroDTO(Vehiculo v, String tipo) {
		this.vehiculo = v;
		this.tipo = tipo;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	private boolean convierteASeguro() {
		if(tipo==null) {
			return false;
		}
		if(tipo.equals("TERCEROS")) {
			this.setSeguro(new Terceros(this.vehiculo));
		}
		else if(tipo.equals("TODO_RIESGO")) {
			this.setSeguro(new TodoRiesgo(this.vehiculo));
		}
		else if(tipo.equals("TODO_RIESGO_FRQ")) {
			this.setSeguro(new TodoRiesgoFranquicia(this.vehiculo));
		}
		else {
			return false;
		}
		return true;
	}
	public Seguro getSeguro() {
		if(seguro == null) {
			convierteASeguro();
		}
		return seguro;
	}
	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
}
