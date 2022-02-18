package es.unican.ss.InsuranceSchema;

import java.util.Date;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Parte {
	
	@XmlElement(required= true)
	private Seguro seguro;
	@XmlAttribute(required= true)
	private double importe;
	@XmlAttribute(required= true)
	private Date fecha;
	// TODO: los partes no se identifican no? para estar seguros
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
