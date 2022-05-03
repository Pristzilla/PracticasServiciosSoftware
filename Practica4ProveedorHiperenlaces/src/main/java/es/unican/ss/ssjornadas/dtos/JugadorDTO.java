package es.unican.ss.ssjornadas.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import es.unican.ss.ssjornadas.entidades.AtomLink;
import es.unican.ss.ssjornadas.entidades.Jugador;

@XmlRootElement(name="jugador")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class JugadorDTO {

	private Jugador jugador;
	private AtomLink self = null;
	private AtomLink next = null;
	private AtomLink previous = null;

	public JugadorDTO() {};
	public JugadorDTO (Jugador j) {
		this.jugador = j;
	}
	@XmlElement()
	public int getDorsal() {
		return this.jugador.getDorsal();
	}
	@XmlElement()
	public int getGoles() {
		return this.jugador.getGoles();
	}
	@XmlElement()
	public String getNombre() {
		return this.jugador.getNombre();
	}
	@XmlElement()
	public int gettAmarillas() {
		return this.jugador.gettAmarillas();
	}
	@XmlElement()
	public int gettRojas() {
		return this.jugador.gettRojas();
	}
	@XmlElement()
	public String getJuegaEn() {
		return this.jugador.getJuegaEn();
	}
	
	public void setDorsal(int dorsal) {}
	public void setGoles(int goles) {}
	public void setNombre(String nombre) {}
	public void settAmarillas(int tAmarillas) {}
	public void settRojas(int tRojas) {}
	public void setJuegaEn(String juegaEn) {}
	
	@XmlElement
	public AtomLink getSelf() {return self;}
	public void setSelf(AtomLink self) {this.self = self;}

	@XmlElement
	public AtomLink getNext() {return next;}
	public void setNext(AtomLink next) {this.next = next;}
	
	@XmlElement
	public AtomLink getPrevious() {return previous;}
	public void setPrevious(AtomLink previous) {this.previous = previous;}

}
