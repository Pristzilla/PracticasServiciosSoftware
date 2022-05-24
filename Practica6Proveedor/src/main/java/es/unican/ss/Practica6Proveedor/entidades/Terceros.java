package es.unican.ss.Practica6Proveedor.entidades;


import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TERCEROS")
public class Terceros extends Seguro implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final double PRECIO_BASE = 200.0;
	
	public Terceros() {
		super();
	}
	
	public Terceros(int id, Vehiculo vehiculoAsegurado) {
		super(id, vehiculoAsegurado);
	}
	
	public Terceros(Vehiculo v) {
		super(v);
	}
	
	@Override
	public double getPrecio() {
		if(this.precio == 0.0) {
			this.precio = PRECIO_BASE + this.getVehiculoAsegurado().getPotencia() * 1.5;
		}
		return precio;

	}


}
