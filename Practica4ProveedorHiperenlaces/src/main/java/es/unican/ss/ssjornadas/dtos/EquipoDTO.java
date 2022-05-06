package es.unican.ss.ssjornadas.dtos;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import es.unican.ss.ssjornadas.entidades.AtomLink;
import es.unican.ss.ssjornadas.entidades.Equipo;
import es.unican.ss.ssjornadas.entidades.Jugador;

@XmlRootElement(name = "equipo")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class EquipoDTO {

	private Equipo equipo;
	private List<AtomLink> jugadores;
	private AtomLink self = null;
																
	private AtomLink next = null;
	private AtomLink previous = null;

	public EquipoDTO() {
		this.jugadores = new LinkedList<AtomLink>();
	};

	public EquipoDTO(Equipo e, UriInfo uri) {
		this.jugadores = new LinkedList<AtomLink>();
		this.equipo = e;
		for (Jugador j : e.getJugadores()) {
			AtomLink jugadorLink = new AtomLink ("jugador", uri.getAbsolutePathBuilder().path("jugadores/"+j.getDorsal()).build().toString());
			jugadores.add(jugadorLink);
		}
	}

	@XmlElement()
	public String getNombre() {
		return equipo.getNombre();
	}

	public void setNombre(String nombre) {
		this.equipo.setNombre(nombre);
	}

	@XmlElement()
	public int getPuntos() {
		return equipo.getPuntos();
	}

	public void setPuntos(int puntos) {
		this.equipo.setPuntos(puntos);
	}

	@XmlElement()
	public int getPartidosGanados() {
		return this.equipo.getPartidosGanados();
	}

	public void setPartidosGanados(int partidosGanados) {
		this.equipo.setPartidosGanados(partidosGanados);
	}

	@XmlElement()
	public int getPartidosJugados() {
		return this.equipo.getPartidosJugados();
	}

	public void setPartidosJugados(int partidosJugados) {
		this.equipo.setPartidosJugados(partidosJugados);
	}

	@XmlElement()
	public int getPartidosPerdidos() {
		return this.equipo.getPartidosPerdidos();
	}

	public void setPartidosPerdidos(int partidosPerdidos) {
		this.equipo.setPartidosPerdidos(partidosPerdidos);
	}

	// TODO: preguntar de donde sale esta clase
	// esta puesto en el seminario Jaxrs para implementar
	@XmlElement(name = "jugador")
	public List<AtomLink> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<AtomLink> jugadores) {
		this.jugadores = jugadores;
	}

	@XmlElement
	public AtomLink getSelf() {
		return self;
	}

	public void setSelf(AtomLink self) {
		this.self = self;
	}

	@XmlElement
	public AtomLink getNext() {
		return next;
	}

	public void setNext(AtomLink next) {
		this.next = next;
	}

	@XmlElement
	public AtomLink getPrevious() {
		return previous;
	}

	public void setPrevious(AtomLink previous) {
		this.previous = previous;
	}

}
