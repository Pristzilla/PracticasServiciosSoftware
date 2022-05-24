package es.unican.ss.Practica6Proveedor.entidades;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TODOFRQ")
public class TodoRiesgoFranquicia extends Seguro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public TodoRiesgoFranquicia() {
		super();
	}
	public TodoRiesgoFranquicia(int id, Vehiculo vehiculoAsegurado) {
		super(id, vehiculoAsegurado);
	}
	
	public TodoRiesgoFranquicia(Vehiculo vehiculo) {
		super(vehiculo);
	}
	@Override
	public double getPrecio() {
		if(this.precio == 0.0) {
			this.precio = this.getVehiculoAsegurado().getPotencia() * 1.5;
			if(this.getVehiculoAsegurado().getUsoProfesional()) {
				this.precio+=100;
			}
		}
		return this.precio;

	}


}
