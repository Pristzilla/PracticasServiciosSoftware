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


@XmlRootElement(name="clasificacion")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ClasificacionDTO {
	
	private List<AtomLink> equipos;
	private AtomLink self;
	private AtomLink next;
	private AtomLink previous;
	
	public ClasificacionDTO() {};
	
	
	public ClasificacionDTO(List<EquipoDTO> equiposParam, UriInfo uri) {
		for (EquipoDTO e: equiposParam) {
			// TODO: preguntar si el getBaseUri coge el 'liga/{id}/'
			AtomLink equipoLink = new AtomLink ("equipo", uri.getBaseUriBuilder().path(e.getNombre()).build().toString());
			equipos.add(equipoLink);
		}
	}
	
	@XmlElement(name="equipo")
	public List<NestedReference> getEquipos() {
		return equipos;
	}


	public void setEquipos(List<NestedReference> equipos) {
		this.equipos = equipos;
	}
	
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
