package es.unican.ss.InsuranceSchema;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlSeeAlso({Terceros.class, TodoRiesgo.class, TodoRiesgoFranquicia.class})
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Seguro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(required= true)
	@XmlID
	private String id;
	@XmlAttribute(required= true)
	private double precio;
	@XmlElement(required= true)
	private Vehiculo vehiculoAsegurado;
	
	public Seguro() {}
	public Seguro (String id, Vehiculo vehiculoAsegurado) {
		this.id = id;
		this.vehiculoAsegurado = vehiculoAsegurado;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public abstract double getPrecio();
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Vehiculo getVehiculoAsegurado() {
		return vehiculoAsegurado;
	}
	public void setVehiculoAsegurado(Vehiculo vehiculoAsegurado) {
		this.vehiculoAsegurado = vehiculoAsegurado;
	}

	
}
