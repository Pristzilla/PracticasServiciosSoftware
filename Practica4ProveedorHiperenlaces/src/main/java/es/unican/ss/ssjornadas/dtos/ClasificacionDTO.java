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
import es.unican.ss.ssjornadas.entidades.Grupo;
import es.unican.ss.ssjornadas.entidades.Jugador;

@XmlRootElement(name = "clasificacion")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ClasificacionDTO {

	private List<AtomLink> equipos;
	private AtomLink self = null;
	private AtomLink next = null;
	private AtomLink previous = null;

	public ClasificacionDTO() {
	};

	public ClasificacionDTO(List<EquipoDTO> equiposParam, UriInfo uri) {
		for (EquipoDTO e : equiposParam) {
			AtomLink equipoLink = new AtomLink("equipo", uri.getAbsolutePathBuilder().path(e.getNombre()).build().toString());
			equipos.add(equipoLink);
		}
	}

	@XmlElement(name = "equipo")
	public List<AtomLink> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<AtomLink> equipos) {
		this.equipos = equipos;
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
