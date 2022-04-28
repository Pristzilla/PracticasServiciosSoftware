package es.unican.ss.ssjornadas.entidadespartido;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class EquipoPartido {
	private String nombre;
	private List<Gol> goles;
	List<TarjetaAmarilla> tAmarillas;
	List<TarjetaRoja> tRojas;
	
	public EquipoPartido() {
		this.tAmarillas = new LinkedList<TarjetaAmarilla>();
		this.tRojas = new LinkedList<TarjetaRoja>();
	}

	@XmlAttribute
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name ="gol")
	public List<Gol> getGoles() {
		return goles;
	}

	public void setGoles(List<Gol> goles) {
		this.goles = goles;
	}
	@XmlElement(name="tarjetaAmarilla")
	public List<TarjetaAmarilla> getTAmarillas() {
		return tAmarillas;
	}

	public void setTAmarillas(List<TarjetaAmarilla> tAmarillas) {
		this.tAmarillas = tAmarillas;
	}
	
	@XmlElement(name="tarjetaRoja")
	public List<TarjetaRoja> getTRojas() {
		return tRojas;
	}

	public void setTRojas(List<TarjetaRoja> tRojas) {
		this.tRojas = tRojas;
	}
	
	@Override
	public String toString() {
		String st = "";
		st += this.nombre +"\n";
		if(!this.goles.isEmpty()) {
		for(Gol g: this.goles) {
			st+= "-gol: " + g.toString();
		}}
		if(!this.tAmarillas.isEmpty()) {
		for(TarjetaAmarilla ta: this.tAmarillas) {
			st+= "-tAmarilla: " + ta.toString();
		}}
		if(!this.tRojas.isEmpty()) {
		for(TarjetaRoja tr: this.tRojas) {
			st+= "-tRoja: " + tr.toString();
		}}
		return st;
	}
	
	

}
