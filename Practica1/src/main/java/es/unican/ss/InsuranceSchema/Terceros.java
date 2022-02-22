package es.unican.ss.InsuranceSchema;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Terceros")
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
		return PRECIO_BASE + this.getVehiculoAsegurado().getPotencia() * 1.5;

	}


}
