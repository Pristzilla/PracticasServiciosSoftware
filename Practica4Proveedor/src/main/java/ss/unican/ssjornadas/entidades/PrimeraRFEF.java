package ss.unican.ssjornadas.entidades;


import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="primeraRFEF")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PrimeraRFEF {

	private List<Grupo> grupos;

	public PrimeraRFEF() {
		this.grupos = new LinkedList<Grupo>();
	}

	// Grupos 
	@XmlElement(name="grupo")
	public List<Grupo> getGrupos(){
		return this.grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Grupo addGrupo(Grupo grupo) {
		if (this.grupos.contains(grupo)) return null;
		else this.grupos.add(grupo);
		return grupo;
	}

	public Grupo getGrupo(String idGrupo) {
		for (Grupo g: this.grupos) {
			if(g.getId().equals(idGrupo)) {
				return g;
			}
		}
		return null;
	}

	// Equipos
	public Equipo getEquipo(String nombreEquipo) {
		for(Grupo g: this.grupos) {
			if(g.getEquipo(nombreEquipo)!= null){
				return g.getEquipo(nombreEquipo);
			}
		}
		return null;

	}
	public boolean modificaEquipo(Equipo equipo) {
		for(Grupo g: this.grupos) {
			if(g.getEquipo(equipo.getNombre())!= null){
				g.getEquipos().remove(equipo);
				return g.getEquipos().add(equipo);
			}
		}
		return false;

	}

	public List<Equipo> getEquipos(String idGrupo) {
		return this.getGrupo(idGrupo).getEquipos();
	}





}
