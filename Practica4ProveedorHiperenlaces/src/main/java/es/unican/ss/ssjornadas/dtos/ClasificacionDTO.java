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

	public ClasificacionDTO(List<Equipo> equiposParam, UriInfo uri) {
		EquipoDTO eq = null;
		for (Equipo e : equiposParam) {
			eq = new EquipoDTO(e, uri);
			AtomLink equipoLink = new AtomLink("equipo", uri.getAbsolutePathBuilder().path(eq.getNombre()).build().toString());
			equipos.add(equipoLink);
		}
		
		self = new AtomLink();
		self.setRel("self");
		self.setHref(uri.getAbsolutePathBuilder().build().toString());
		self.setType("application/xml");
		next = new AtomLink();
		next.setRel("self");
		next.setHref(uri.getAbsolutePathBuilder().build().toString());
		next.setType("application/xml");
		previous = new AtomLink();
		previous.setRel("self");
		previous.setHref(uri.getAbsolutePathBuilder().build().toString());
		previous.setType("application/xml");
		
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
