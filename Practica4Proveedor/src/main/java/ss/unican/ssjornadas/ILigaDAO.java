package ss.unican.ssjornadas;

import java.util.List;

public interface ILigaDAO {

	/**
	 * Retorna la lista de equipos inscritos en el 
	 * grupo que se indica como parametro
	 * @param grupo de la liga
	 * @return Lista de equipos del grupo
	 */
	public List<Equipo> getEquipos(String grupo);

	/**
	 * Retorna el equipo cuyo nombre se pasa como parametro
	 * @param Nombre del equipo
	 * @return El equipo o null si no existe
	 */
	public Equipo getEquipo(String equipo);

	/**
	 * Actualiza el equipo con los datos que se pasan
	 * como parametro
	 * @param e Equipo actualizado
	 * @return El equipo actualizado o null si no se puede actualizar
	 */
	public Equipo actualizaEquipo(Equipo e);

	/**
	 * Retorna la lista completa de jugadores del
	 * grupo que se pasa como parametro
	 * @param El grupo
	 * @return Lista de jugadores inscritos en el grupo
	 */
	public List<Jugador> getJugadores(String grupo);

	/**
	 * Retorna el jugador cuyo equipo y dorsal se pasan 
	 * como parametro
	 * @param equipo 
	 * @param dorsal
	 * @return El jugador o null si no existe un jugador
	 * con el dorsal y equipo indicados
	 */
	public Jugador getJugador(String equipo, int dorsal);

	/**
	 * Actualiza el jugador perteneciente al equipo que 
	 * se pasa como parametro
	 * @param equipo El equipo
	 * @param j El jugador actualizado
	 * @return Jugador actualizado o null si no existe
	 */
	public Jugador actualizaJugador(String equipo, Jugador j);

	/**
	 * Retorna el grupo cuyo id se pasa como parametro
	 * @param id del grupo
	 * @return El grupo o null si no existe
	 */
	public Grupo getGrupo(String idGrupo);

	/**
	 * Elimina un jugador que pertenece a un equipo que se pasa
	 * como parametro
	 * @param equipo Equipo
	 * @param dorsal
	 * @return
	 */
	public Jugador eliminaJugador(String equipo, String dorsal);

}
