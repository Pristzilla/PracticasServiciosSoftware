package ss.unican.ssjornadas.entidades;

import java.util.LinkedList;
import java.util.List;


public class Grupo {
	private String id;
	private List<Equipo> equipos;
	
	public Grupo() {};
	
	public Grupo(String id) {
		this.id = id;
		equipos = new LinkedList<Equipo>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	public Equipo getEquipo(String nombreEquipo) {
		for(Equipo e: this.equipos) {
			if(e.getNombre().equals(nombreEquipo)) {
				return e;
			}
		}
		return null;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
