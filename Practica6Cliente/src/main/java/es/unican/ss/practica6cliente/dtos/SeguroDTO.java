package es.unican.ss.practica6cliente.dtos;


import es.unican.ss.practica6cliente.entidades.Seguro;
import es.unican.ss.practica6cliente.entidades.Terceros;
import es.unican.ss.practica6cliente.entidades.TodoRiesgo;
import es.unican.ss.practica6cliente.entidades.TodoRiesgoFranquicia;
import es.unican.ss.practica6cliente.entidades.Vehiculo;


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

	public SeguroDTO(Seguro s) {
		this.vehiculo = s.getVehiculoAsegurado();
		if(s instanceof TodoRiesgo) {
			this.tipo = "TODO_RIESGO";
		} else if (s instanceof TodoRiesgoFranquicia) {
			this.tipo = "TODO_RIESGO_FRQ";
		}
		else {
			this.tipo = "TERCEROS";
		}
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
	public Seguro seguro() {
		if(seguro == null) {
			convierteASeguro();
		}
		return seguro;
	}
	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
	


}

