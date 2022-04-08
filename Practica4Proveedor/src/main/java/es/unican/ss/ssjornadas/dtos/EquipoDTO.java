package es.unican.ss.ssjornadas.dtos;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import es.unican.ss.ssjornadas.entidades.Equipo;
import es.unican.ss.ssjornadas.entidades.Jugador;

@XmlRootElement(name="equipo")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class EquipoDTO {

	private String nombre;
	private int puntos;
	private int partidosGanados;
	private int partidosJugados;
	private int partidosPerdidos;
	private List<Jugador> jugadores;
	
	public EquipoDTO () {};
	
	public EquipoDTO(Equipo e) {
		nombre = e.getNombre();
		puntos = e.getPuntos();
		partidosGanados = e.getPartidosGanados();
		partidosPerdidos = e.getPartidosPerdidos();
		partidosJugados = e.getPartidosJugados();
		jugadores = e.getJugadores();	
	}

	@XmlElement()
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement()
	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	@XmlElement()
	public int getPartidosGanados() {
		return partidosGanados;
	}

	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}
	@XmlElement()
	public int getPartidosJugados() {
		return partidosJugados;
	}

	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}
	@XmlElement()
	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}

	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}
	@XmlElement(name = "jugador")
	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
}
