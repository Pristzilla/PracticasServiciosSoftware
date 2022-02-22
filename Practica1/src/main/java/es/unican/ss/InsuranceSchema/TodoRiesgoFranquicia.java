package es.unican.ss.InsuranceSchema;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="TodoRiesgoFranquicia")
public class TodoRiesgoFranquicia extends Seguro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public TodoRiesgoFranquicia() {
		super();
	}
	public TodoRiesgoFranquicia(String id, Vehiculo vehiculoAsegurado) {
		super(id, vehiculoAsegurado);
	}
	
	@Override
	public double getPrecio() {
		double prec = this.getVehiculoAsegurado().getPotencia() * 1.5;
		if(this.getVehiculoAsegurado().getUsoProfesional()) {
			prec+=100;
		}
		
		return prec;
	}


}
