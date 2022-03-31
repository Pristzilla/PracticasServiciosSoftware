/**
 *
 * Author: Javier Barquin
 * Date: 25 mar. 2022
 *
 */
package ss.unican.ssjornadas.controller;

import java.util.List;

import ss.unican.ssjornadas.entidades.Equipo;
import ss.unican.ssjornadas.entidades.Grupo;
import ss.unican.ssjornadas.entidades.Jugador;



/**
 * @author barquinj
 *
 */

public class LigaDAO implements ILigaDAO {

	public List<Equipo> getEquipos(String grupo) {
		return null;
	}

	public Equipo getEquipo(String equipo) {
		return null;
	}
	
	public Equipo actualizaEquipo(Equipo e) {
		return null;
	}

	
	public List<Jugador> getJugadores(String grupo) {
		return null;
	}

	public Jugador getJugador(String equipo, int dorsal) {
		return null;
	}

	public Jugador actualizaJugador(String equipo, Jugador j) {
		return null;
	}

	public Grupo getGrupo(String idGrupo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Jugador eliminaJugador(String equipo, String dorsal) {
		// TODO Auto-generated method stub
		return null;
	}

	public Jugador anhadeJugador(String nombreEquipo, Jugador jugador) {
		// TODO Auto-generated method stub
		return null;
	}

}
