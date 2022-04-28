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
	private AtomLink self;
	private AtomLink next;
	private AtomLink previous;

	public RankingDTO() {
	};

	public RankingDTO(List<JugadorDTO> rankingJugadores, UriInfo uri) {
		for (JugadorDTO j : rankingJugadores) {
			// TODO: preguntar como se sabe si el uri base es 'liga/{id}/ranking' o
			// 'liga/{id}/{nombre}/ranking'
			// el base es lo que esta antes de esto (localhost:8080/nombre war) hay que
			// escribir lo que hayamos puesto en el servicio
			AtomLink jugadorLink = new AtomLink("jugador", uri.getBaseUriBuilder().path("ranking/").build().toString());
			jugadoresDTO.add(jugadorLink);
		}
	}

	@XmlElement(name = "jugador")
	public List<NestedReference> getJugadoresDTO() {
		return jugadoresDTO;
	}

	public void setJugadoresDTO(List<NestedReference> jugadoresDTO) {
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
