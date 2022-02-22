package es.unican.ss.InsuranceSchema;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

@XmlType(name="TodoRiesgo")
@XmlAccessorType(XmlAccessType.FIELD)
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
		double prec = PRECIO_BASE + this.getVehiculoAsegurado().getPotencia() * 1.5;
		if(this.getVehiculoAsegurado().getUsoProfesional()) {
			prec+=100;
		}
		
		return prec;
	}
	
	


}
