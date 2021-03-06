/**
 *
 * Author: Javier Barquin
 * Date: 25 mar. 2022
 *
 */
package es.unican.ss.ssjornadas.persistencia;

import java.util.List;

import es.unican.ss.ssjornadas.entidades.Equipo;
import es.unican.ss.ssjornadas.entidades.Grupo;
import es.unican.ss.ssjornadas.entidades.Jugador;
import es.unican.ss.ssjornadas.entidades.PrimeraRFEF;
import es.unican.ss.ssjornadas.procesaxml.ProcesaJornadasJAXB;


/**
 * @author barquinj
 *
 */

public class LigaDAO implements ILigaDAO {

	private ProcesaJornadasJAXB procesador;
	private PrimeraRFEF liga;
	String ordenador;

	public LigaDAO() {
		this.procesador = new ProcesaJornadasJAXB();
		this.ordenador = "javi";
	}

	public LigaDAO(String ordenador) {
		this.procesador = new ProcesaJornadasJAXB();
		this.ordenador = ordenador;

	}


	//grupos 
	public Grupo getGrupo(String idGrupo) {
		this.liga = this.procesador.procesaFichero(ordenador);
		return this.liga.getGrupo(idGrupo);
	}

	// equipos 
	public List<Equipo> getEquipos(String idGrupo) {
		this.liga = this.procesador.procesaFichero(ordenador);
		return this.liga.getEquipos(idGrupo);
	}

	public Equipo getEquipo(String nombreEquipo) {
		this.liga = this.procesador.procesaFichero(ordenador);
		return this.liga.getEquipo(nombreEquipo);
	}

	public Equipo actualizaEquipo(Equipo e) {
		this.liga = this.procesador.procesaFichero(ordenador);
		if(e!=null) {
			Equipo equipo = this.liga.getEquipo(e.getNombre());
			if (equipo != null && this.liga.modificaEquipo(e)) {
				this.procesador.escribeFichero(liga,ordenador);
				return  e;
			}
		}

		return null;
	}


	public Jugador getJugador(String nombreEquipo, int dorsal) {
		this.liga = this.procesador.procesaFichero(ordenador);
		Jugador jugador = null;
		Equipo equipo = this.liga.getEquipo(nombreEquipo);
		if(equipo != null) {
			return equipo.getJugador(dorsal);
		}
		return jugador;
	}

	public Jugador actualizaJugador(String nombreEquipo, Jugador j) {
		this.liga = this.procesador.procesaFichero(ordenador);
		Jugador jugador = null;
		Equipo equipo = this.liga.getEquipo(nombreEquipo);
		if(equipo != null) {
			jugador = equipo.modificaJugador(j);
			this.procesador.escribeFichero(liga,ordenador);
		}
		return jugador;
	}


	public Jugador eliminaJugador(String nombreEquipo, int dorsal) {
		this.liga = this.procesador.procesaFichero(ordenador);
		Jugador j = this.liga.getEquipo(nombreEquipo).eliminaJugador(dorsal);
		if(j != null) {
			this.procesador.escribeFichero(liga,ordenador);
		}
		return j;

	}

	public Jugador anhadeJugador(String nombreEquipo, Jugador jugador) {
		this.liga = this.procesador.procesaFichero(ordenador);
		Equipo e = this.liga.getEquipo(nombreEquipo);
		if (e != null) {
			Jugador j = e.getJugador(jugador.getDorsal());
			if(j == null) {
				Jugador jug = this.liga.getEquipo(nombreEquipo).addJugador(jugador);
				if (jug != null) this.procesador.escribeFichero(liga,ordenador);
				return jug;
			}
		}
		return null;
	}

}
