package es.unican.ss.ssjornadas.entidades;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Jugador implements Comparable<Jugador>{
	
	private int dorsal;
	private int goles;
	private String nombre;
	private int tAmarillas;
	private int tRojas;
	private String juegaEn;
	
	public Jugador() {}
	
	public Jugador(int dorsal, String nombre) {
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.goles = 0;
		this.tAmarillas = 0;
		this.tRojas = 0;
		this.juegaEn = "";
	}


	@XmlElement()
	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	@XmlElement()
	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}
	@XmlElement()
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement()
	public int gettAmarillas() {
		return tAmarillas;
	}

	public void settAmarillas(int tAmarillas) {
		this.tAmarillas = tAmarillas;
	}
	@XmlElement()
	public int gettRojas() {
		return tRojas;
	}

	public void settRojas(int tRojas) {
		this.tRojas = tRojas;
	}
	@XmlElement()
	public String getJuegaEn() {
		return juegaEn;
	}

	public void setJuegaEn(String juegaEn) {
		this.juegaEn = juegaEn;
	}

	@Override
	public boolean equals(Object o) {

		// If the object is compared with itself then return true 
		if (o == this) {
			return true;
		}


		if (!(o instanceof Jugador)) {
			return false;
		}

		Jugador j = (Jugador) o;


		return this.dorsal == j.dorsal;     
	}


	public int compareTo(Jugador j){
		if (this.goles < j.goles) {

			// if current object is greater,then return 1
			return 1;
		}
		else if (this.goles > j.goles) {

			// if current object is greater,then return -1
			return -1;
		}
		else {

			// if current object is equal to o,then return 0
			return 0;
		}
	}
	@Override
	public String toString() {
		String st = "";
		st += this.nombre +"\n";
		st += "\tDORSAL: " + this.dorsal +"\n";
		st += "\tGOLES: " + this.goles +"\n";
		st += "\tJuegaEN: " + this.juegaEn +"\n";
		return st;
	}
}
