package es.unican.ss.Practica6Proveedor.entidades;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlType(name="Seguro")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({
	Terceros.class,
	TodoRiesgo.class,
	TodoRiesgoFranquicia.class
})
public abstract class Seguro implements Serializable {

	private static final long serialVersionUID = 1L;
	@XmlAttribute(name = "id", required= true)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;
	@XmlElement(required= true)
	protected Vehiculo vehiculoAsegurado;
	@XmlAttribute(required= true)
	protected double precio;

	protected Seguro() {}
	protected Seguro (String id, Vehiculo vehiculoAsegurado) {
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
