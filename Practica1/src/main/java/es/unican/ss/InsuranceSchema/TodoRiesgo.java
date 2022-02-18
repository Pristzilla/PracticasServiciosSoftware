package es.unican.ss.InsuranceSchema;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class TodoRiesgo extends Seguro {

	public TodoRiesgo() {
		super();
	}
	public TodoRiesgo(String id, Vehiculo vehiculoAsegurado) {
		super(id, vehiculoAsegurado);
	}
	private static final long serialVersionUID = 1L;
	private static final double PRECIO_BASE = 600.0;
	
	@Override
	public double getPrecio() {
		double prec = PRECIO_BASE + this.getVehiculoAsegurado().getPotencia() * 1.5;
		if(this.getVehiculoAsegurado().getUsoProfesional()) {
			prec+=100;
		}
		
		return prec;
	}
	
	


}
