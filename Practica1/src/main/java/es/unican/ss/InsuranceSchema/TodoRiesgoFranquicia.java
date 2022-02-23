package es.unican.ss.InsuranceSchema;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

@XmlType(name="TodoRiesgoFranquicia")
@XmlAccessorType(XmlAccessType.FIELD)
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
		if(this.precio == 0.0) {
			this.precio = this.getVehiculoAsegurado().getPotencia() * 1.5;
			if(this.getVehiculoAsegurado().getUsoProfesional()) {
				this.precio+=100;
			}
		}
		return this.precio;

	}


}
