package es.unican.ss.Practica6Proveedor.entidades;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TODORIESGO")
public class TodoRiesgo extends Seguro implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final double PRECIO_BASE = 600.0;
	
	public TodoRiesgo() {
		super();
	}
	public TodoRiesgo(String id, Vehiculo vehiculoAsegurado) {
		super(id, vehiculoAsegurado);
	}
	
	@Override
	public double getPrecio() {
		if(this.precio == 0.0) {
			this.precio = PRECIO_BASE + this.getVehiculoAsegurado().getPotencia() * 1.5;
			if(this.getVehiculoAsegurado().getUsoProfesional()) {
				this.precio+=100;
			}
		}
		return this.precio;

	}
	
	


}
