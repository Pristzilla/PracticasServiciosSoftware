package es.unican.ss.Practica6Proveedor.entidades;

import java.util.Date;
import javax.xml.bind.annotation.*;

@XmlType(name="Parte")
@XmlAccessorType(XmlAccessType.FIELD)
public class Parte {

	@XmlElement(required = true)
	@XmlIDREF
	private Seguro seguro;
	@XmlAttribute(required= true)
	private double importe;
	@XmlAttribute(required= true)
	private Date fecha;
	
	public Parte() { /* constructor vacio */ }
	
	
	
	public Seguro getSeguro() {
		return seguro;
	}
	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
