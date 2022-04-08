package es.unican.ss.ssjornadas.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import es.unican.ss.ssjornadas.entidades.Jugador;

@XmlRootElement(name="jugador")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class JugadorDTO {

	private int dorsal;
	private int goles;
	private String nombre;
	private int tAmarillas;
	private int tRojas;
	private String juegaEn;

	public JugadorDTO() {};
	public JugadorDTO (Jugador j) {
		this.dorsal = j.getDorsal();
		this.nombre = j.getNombre();
		this.goles = j.getGoles();
		this.tAmarillas = j.gettAmarillas();
		this.tRojas = j.gettRojas();
		this.juegaEn = j.getJuegaEn();
	}
	@XmlElement()
	public int getDorsal() {
		return dorsal;
	}
	@XmlElement()
	public int getGoles() {
		return goles;
	}
	@XmlElement()
	public String getNombre() {
		return nombre;
	}
	@XmlElement()
	public int gettAmarillas() {
		return tAmarillas;
	}
	@XmlElement()
	public int gettRojas() {
		return tRojas;
	}
	@XmlElement()
	public String getJuegaEn() {
		return juegaEn;
	}
	
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	public void setGoles(int goles) {
		this.goles = goles;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void settAmarillas(int tAmarillas) {
		this.tAmarillas = tAmarillas;
	}
	public void settRojas(int tRojas) {
		this.tRojas = tRojas;
	}
	public void setJuegaEn(String juegaEn) {
		this.juegaEn = juegaEn;
	}

}
