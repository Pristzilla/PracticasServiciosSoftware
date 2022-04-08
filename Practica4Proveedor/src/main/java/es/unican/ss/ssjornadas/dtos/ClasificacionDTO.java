package es.unican.ss.ssjornadas.dtos;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import es.unican.ss.ssjornadas.entidades.Equipo;
import es.unican.ss.ssjornadas.entidades.Grupo;


@XmlRootElement(name="clasificacion")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ClasificacionDTO {
	
	private List<EquipoDTO> equipos;
	
	public ClasificacionDTO() {};
	
	
	public ClasificacionDTO(List<Equipo> equiposParam) {
		this.equipos = new LinkedList<EquipoDTO>();
		EquipoDTO eDTO = null;
		for(Equipo e: equiposParam) {
			eDTO = new EquipoDTO(e);
			this.equipos.add(eDTO);
		}
	}
	
	@XmlElement(name="equipo")
	public List<EquipoDTO> getEquipos() {
		return equipos;
	}


	public void setEquipos(List<EquipoDTO> equipos) {
		this.equipos = equipos;
	}
	
}
