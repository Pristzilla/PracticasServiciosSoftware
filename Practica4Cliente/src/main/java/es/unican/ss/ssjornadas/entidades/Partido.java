package es.unican.ss.ssjornadas.entidades;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class Partido {
	
	private EquipoPartido local;
	private EquipoPartido visitante;
	
	public Partido() {}
	
	public Partido(EquipoPartido local, EquipoPartido visitante) {
		this.setLocal(local);
		this.setVisitante(visitante);
	}

	@XmlElement
	public EquipoPartido getLocal() {
		return local;
	}

	public void setLocal(EquipoPartido local) {
		this.local = local;
	}
	@XmlElement
	public EquipoPartido getVisitante() {
		return visitante;
	}

	public void setVisitante(EquipoPartido visitante) {
		this.visitante = visitante;
	}
	@Override
	public String toString() {
		return "Local: " + this.local.toString() + "\nVistante: " +  this.visitante.toString();
		
	}
	
	

}
