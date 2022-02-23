package es.unican.ss.InsuranceSchema;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

@XmlType(name = "Terceros")
@XmlAccessorType(XmlAccessType.FIELD)
public class Terceros extends Seguro implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final double PRECIO_BASE = 200.0;
	
	public Terceros() {
		super();
	}
	
	public Terceros(String id, Vehiculo vehiculoAsegurado) {
		super(id, vehiculoAsegurado);
	}
	
	@Override
	public double getPrecio() {
		if(this.precio == 0.0) {
			this.precio = PRECIO_BASE + this.getVehiculoAsegurado().getPotencia() * 1.5;
		}
		return precio;

	}


}
