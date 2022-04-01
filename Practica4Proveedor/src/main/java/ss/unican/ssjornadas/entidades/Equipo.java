package ss.unican.ssjornadas.entidades;

import java.util.Collections;
import java.util.List;

public class Equipo implements Comparable<Equipo> {

	private String nombre;
	private int puntos;
	private int partidosGanados;
	private int partidosJugados;
	private int partidosPerdidos;
	private List<Jugador> jugadores;

	public Equipo() {};

	public Equipo(String nombre) {
		this.nombre = nombre;
		this.puntos= 0;
		this.partidosGanados = 0;
		this.partidosJugados = 0;
		this.partidosPerdidos = 0;
		this.jugadores = Collections.emptyList();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getPartidosGanados() {
		return partidosGanados;
	}

	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}

	public int getPartidosJugados() {
		return partidosJugados;
	}

	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}

	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}

	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Jugador getJugador(int dorsal) {
		for(Jugador j: this.jugadores) {
			if (j.getDorsal() == dorsal) {
				return j;
			}
		}
		return null;
	}


	public Jugador modificaJugador(Jugador jugador) {
		for(Jugador j: this.jugadores) {
			if(j.getNombre().equals(jugador.getNombre())){
				this.jugadores.remove(j);
				if(this.jugadores.add(jugador)) {
					return jugador;
				}
			}
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Equipo other = (Equipo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}


	public int compareTo(Equipo e)
	{
		if (this.puntos > e.puntos) {

			// if current object is greater,then return 1
			return 1;
		}
		else if (this.puntos < e.puntos) {

			// if current object is greater,then return -1
			return -1;
		}
		else {

			// if current object is equal to o,then return 0
			return 0;
		}
	}

	public Jugador eliminaJugador(int dorsal) {
		for(int i = jugadores.size(); i >=0; i--) {
			if (jugadores.get(i).getDorsal() == dorsal) {
				return jugadores.remove(i);
			}
		}
		return null;
	}
	public Jugador addJugador(Jugador jugador) { 
		if (jugador != null && jugadores.add(jugador)) {
			return jugador;
		}
		return null;
	}


}
