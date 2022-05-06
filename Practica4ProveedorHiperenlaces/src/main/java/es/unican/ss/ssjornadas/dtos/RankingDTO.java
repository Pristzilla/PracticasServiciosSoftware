package es.unican.ss.ssjornadas.dtos;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import es.unican.ss.ssjornadas.entidades.AtomLink;
import es.unican.ss.ssjornadas.entidades.Jugador;

@XmlRootElement(name = "ranking")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class RankingDTO {
	private List<AtomLink> jugadoresDTO;
	private AtomLink self = null;
	private AtomLink next = null;
	private AtomLink previous = null;

	public RankingDTO() {
	};

	public RankingDTO(List<Jugador> rankingJugadores, UriInfo uri) {
		JugadorDTO jug = null;
		this.jugadoresDTO = new LinkedList<AtomLink>();
		for (Jugador j : rankingJugadores) {
			jug = new JugadorDTO(j, uri);
			AtomLink jugadorLink = new AtomLink("jugador", uri.getAbsolutePathBuilder().path("ranking/").build().toString());
			jugadoresDTO.add(jugadorLink);
		}
	}

	@XmlElement(name = "jugador")
	public List<AtomLink> getJugadoresDTO() {
		return jugadoresDTO;
	}

	public void setJugadoresDTO(List<AtomLink> jugadoresDTO) {
		this.jugadoresDTO = jugadoresDTO;
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
