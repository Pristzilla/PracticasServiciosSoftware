package ss.unican.ssjornadas.dtos;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ss.unican.ssjornadas.entidades.Equipo;
import ss.unican.ssjornadas.entidades.Grupo;


@XmlRootElement(name="clasificacion")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ClasificacionDTO {
	
	private List<EquipoDTO> equipos;
	
	public ClasificacionDTO() {};
	
	
	public ClasificacionDTO(Grupo g) {
		equipos = new LinkedList<EquipoDTO>();
		
		for(Equipo e:g.getEquipos()) {
			EquipoDTO dto = new EquipoDTO(e);
			equipos.add(dto);
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
