/**
 *
 * Author: Javier Barquin
 * Date: 25 mar. 2022
 *
 */
package es.unican.ss.ssjornadas.controlador;


import java.net.URI;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import es.unican.ss.ssjornadas.dtos.ClasificacionDTO;
import es.unican.ss.ssjornadas.dtos.EquipoDTO;
import es.unican.ss.ssjornadas.dtos.JugadorDTO;
import es.unican.ss.ssjornadas.dtos.RankingDTO;
import es.unican.ss.ssjornadas.entidades.Equipo;
import es.unican.ss.ssjornadas.entidades.Grupo;
import es.unican.ss.ssjornadas.entidades.Jugador;
import es.unican.ss.ssjornadas.persistencia.ILigaDAO;
import es.unican.ss.ssjornadas.persistencia.LigaDAO;

/**
 * @author barquinj
 *
 */
@Path("/liga/grupo/{id}")
public class LigaController {

	private ILigaDAO ligaDAO;

	public LigaController() {
		ligaDAO = new LigaDAO();
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getClasificacionActual(@PathParam("id") String idGrupo) {
		Response.ResponseBuilder builder;
		List<Equipo> equipos;
		Grupo g = ligaDAO.getGrupo(idGrupo);

		if(g != null) {
			equipos = ligaDAO.getEquipos(idGrupo);
			Collections.sort(equipos);
			ClasificacionDTO clasificacion = new ClasificacionDTO(equipos);
			builder = Response.ok(clasificacion);
		}
		else {
			builder = Response.status(Response.Status.NOT_FOUND);
		}

		return builder.build();
	}

	@GET
	@Path("/ranking")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getRankingGoleadoresGrupo(@PathParam("id") String idGrupo) {
		Response.ResponseBuilder builder;
		List<Jugador> rankingJugadores = Collections.emptyList();
		List<Equipo> equipos;
		Grupo g = ligaDAO.getGrupo(idGrupo);
		if(g != null) {
			equipos = ligaDAO.getEquipos(idGrupo);
			for(Equipo e: equipos) {
				rankingJugadores.addAll(e.getJugadores());
			}
			Collections.sort(rankingJugadores);
			RankingDTO ranking = new RankingDTO(rankingJugadores);
			builder = Response.ok(ranking);
		}
		else {
			builder = Response.status(Response.Status.NOT_FOUND);
		}

		return builder.build();
	}

	@GET
	@Path("/{nombre}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getEquipo(@PathParam("id")String idGrupo, @PathParam("nombre") String nombreEquipo) {
		Response.ResponseBuilder builder;
		Equipo e;
		Grupo g = ligaDAO.getGrupo(idGrupo);

		if(g != null) {
			e = ligaDAO.getEquipo(nombreEquipo);
			if(e != null) {
				EquipoDTO equipo = new EquipoDTO(e);
				builder = Response.ok(equipo);
			}
			else {
				builder = Response.status(Response.Status.NOT_FOUND);
			}
		}
		else {
			builder = Response.status(Response.Status.NOT_FOUND);
		}

		return builder.build();
	}

	@PUT
	@Path("/{nombre}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response modifyEquipo(@PathParam("id")String idGrupo, @PathParam("nombre") 
	String nombreEquipo, Equipo equipo) {
		Response.ResponseBuilder builder;
		Equipo e;
		Grupo g = ligaDAO.getGrupo(idGrupo);
		if (g!= null) {
			e = ligaDAO.getEquipo(nombreEquipo);
			if (e != null) {
				e = ligaDAO.actualizaEquipo(equipo);
				EquipoDTO equipoActualizado = new EquipoDTO(e);
				builder = Response.ok(equipoActualizado);
			}
			else {
				builder = Response.status(Response.Status.NOT_FOUND);
			}
		}
		else {
			builder = Response.status(Response.Status.NOT_FOUND);
		}
		return builder.build();
	}

	@GET
	@Path("/{nombre}/ranking")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getRankingGoleadoresEquipo(@PathParam("id") String idGrupo,
			@PathParam("nombre") String nombreEquipo) {
		Response.ResponseBuilder builder;
		List<Jugador> rankingJugadores;
		Equipo equipo;
		Grupo g = ligaDAO.getGrupo(idGrupo);
		if(g != null) {
			equipo = ligaDAO.getEquipo(nombreEquipo);
			if(equipo != null) {
				rankingJugadores = equipo.getJugadores();
				Collections.sort(rankingJugadores);
				RankingDTO ranking = new RankingDTO(rankingJugadores);
				builder = Response.ok(ranking);
			}
			else {
				builder = Response.status(Response.Status.NOT_FOUND);
			}
		}
		else {
			builder = Response.status(Response.Status.NOT_FOUND);
		}

		return builder.build();
	}


	@GET
	@Path("/{nombre}/jugadores/{dorsal}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getJugador(@PathParam("id") String idGrupo,
			@PathParam("nombre") String nombreEquipo, @PathParam("dorsal") String dorsal) {
		Response.ResponseBuilder builder;
		Jugador j;
		Grupo g = ligaDAO.getGrupo(idGrupo);
		if (g!= null) {
			j = ligaDAO.getJugador(nombreEquipo, Integer.parseInt(dorsal));
			if (j != null) {
				JugadorDTO jugador = new JugadorDTO(j);
				builder = Response.ok(jugador);
			} else {
				builder = Response.status(Response.Status.NOT_FOUND);
			}
		}
		else {
			builder = Response.status(Response.Status.NOT_FOUND);
		}
		return builder.build();
	}

	@PUT
	@Path("/{nombre}/jugadores/{dorsal}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response addJugador(@PathParam("id") String idGrupo, @PathParam("nombre") String nombreEquipo,
			@PathParam("dorsal") String dorsal, @Context UriInfo uriInfo, Jugador jugador) {
		Response.ResponseBuilder builder;
		Jugador j;
		Grupo g = ligaDAO.getGrupo(idGrupo);
		if (g!= null) {
			j = ligaDAO.getJugador(nombreEquipo, Integer.parseInt(dorsal));
			if (j == null) {
				ligaDAO.anhadeJugador(nombreEquipo, jugador);
				URI location = uriInfo.getAbsolutePathBuilder().build();
				builder = Response.created(location);
			} else {
				j = ligaDAO.actualizaJugador(nombreEquipo, jugador);
				JugadorDTO jugadorActualizado = new JugadorDTO(j);
				builder = Response.ok(jugadorActualizado);
			}
		}
		else {
			builder = Response.status(Response.Status.NOT_FOUND);
		}
		return builder.build();
	}


	@DELETE
	@Path("/{nombre}/jugadores/{dorsal}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response deleteJugador(@PathParam("id") String idGrupo, @PathParam("nombre") String nombreEquipo,
			@PathParam("dorsal") String dorsal) {
		Response.ResponseBuilder builder;
		Jugador j;
		Grupo g = ligaDAO.getGrupo(idGrupo);
		if (g!= null) {
			j = ligaDAO.getJugador(nombreEquipo, Integer.parseInt(dorsal));
			if (j != null) {
				j = ligaDAO.eliminaJugador(nombreEquipo, Integer.parseInt(dorsal));
				JugadorDTO jugador = new JugadorDTO(j);
				builder = Response.ok(jugador);
			} else {
				builder = Response.status(Response.Status.NOT_FOUND);
			}
		}
		else {
			builder = Response.status(Response.Status.NOT_FOUND);
		}
		return builder.build();
	}

}

