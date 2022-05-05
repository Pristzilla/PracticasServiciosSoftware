package es.unican.ss.ssjornadas.cliente;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.unican.ss.ssjornadas.entidades.Equipo;
import es.unican.ss.ssjornadas.entidadespartido.EquipoPartido;
import es.unican.ss.ssjornadas.entidadespartido.Gol;
import es.unican.ss.ssjornadas.entidades.Grupo;
import es.unican.ss.ssjornadas.entidadespartido.Jornada;
import es.unican.ss.ssjornadas.entidades.Jugador;
import es.unican.ss.ssjornadas.entidadespartido.Partido;
import es.unican.ss.ssjornadas.entidadespartido.Tarjeta;
import es.unican.ss.ssjornadas.procesaxml.ProcesaJornadaJAXB;

public class PrimeraRFEFCliente {

	public static void main(String[] args) {

		ProcesaJornadaJAXB procesaxml = new ProcesaJornadaJAXB();
		Jornada jornada = procesaxml.procesaFichero("javi");
//				System.out.println("Jornada num: "+ jornada.getNumJornada() + "\t Grupo: " + jornada.getGrupo());
//				for(Partido p: jornada.getPartidos()) {
//					System.out.println(p.toString());
//				}

		// Creamos el Client
		Client client = ClientBuilder.newClient();
		// Creamos el WebTarget base (raíz del servicio o recurso raíz)
		WebTarget base = client.target("http://localhost:8080/SSPrimeraRFEF/liga/"); 

		String idgrupo = jornada.getGrupo();

		// Enviamos petición a GrupoI (existe)
		WebTarget resourceGrupo = base.path(idgrupo);


		for(Partido p: jornada.getPartidos()) {
			String nombreLocal = p.getLocal().getNombre();
			String nombreVisitante = p.getVisitante().getNombre();

			// actualizamos paths LOCAL y Visitante
			WebTarget resourceLocal = resourceGrupo.path(nombreLocal);
			WebTarget resourceVisitante = resourceGrupo.path(nombreVisitante);

			// pedimos equipo LOCAL
			Response responseLocal = resourceLocal.request(MediaType.APPLICATION_JSON).get(); 
			Equipo eLocal = procesaRespuestaEquipo(responseLocal);
			// peticion al equipo VISITANTE
			Response responseVisitante = resourceVisitante.request(MediaType.APPLICATION_JSON).get(); 
			Equipo eVisitante = procesaRespuestaEquipo(responseVisitante);

			if(eLocal != null) {
				procesaPartidos(p, eLocal, resourceLocal); 
				if(!p.getLocal().getGoles().isEmpty()) {
					// recorro goles LOCAL
					procesaGoles(p.getLocal(), resourceLocal);
				}
				
				if(!p.getLocal().getTAmarillas().isEmpty()) {
					// recorro amarillas LOCAL
					procesaTarjetas(p.getLocal().getTAmarillas(), resourceLocal);
				}
				if(!p.getLocal().getTRojas().isEmpty()) {
					// recorro rojas LOCAL
					procesaTarjetas(p.getLocal().getTRojas(), resourceLocal);
				}
			}
			else {
				System.out.println("Error: equipo local con nombre: " + p.getLocal().getNombre() + " no encontrado." + resourceLocal.getUri());
			}
			if(eVisitante!=null) {
				procesaPartidos(p, eVisitante, resourceVisitante); 
				if(!p.getVisitante().getGoles().isEmpty()) {
					// recorro goles VISITANTE
					procesaGoles(p.getVisitante(), resourceVisitante);
				}
				
				if(!p.getVisitante().getTAmarillas().isEmpty()) {
					// recorro amarillas VISITANTE
					procesaTarjetas(p.getVisitante().getTAmarillas(), resourceVisitante);
				}
				if(!p.getVisitante().getTRojas().isEmpty()) {
					// recorro rojas VISITANTE
					procesaTarjetas(p.getVisitante().getTRojas(), resourceVisitante);
				}

			}else {
				System.out.println("Error: equipo visitante con nombre: " + p.getVisitante().getNombre() + " no encontrado." + resourceVisitante.getUri());
			}
		}
	}

	private static void procesaPartidos(Partido p, Equipo equipo, WebTarget resource) {
		int jugadoslocal = equipo.getPartidosJugados();
		equipo.setPartidosJugados(jugadoslocal+1);

		if(ganaLocal(p) == 1) { // gana local
			// gana el local
			int ganadoslocal = equipo.getPartidosGanados();
			equipo.setPartidosGanados(ganadoslocal+1);
		}else if(ganaLocal(p)== -1) { // gana visitante
			int perdidoslocal = equipo.getPartidosPerdidos();
			equipo.setPartidosPerdidos(perdidoslocal+1);
		}
		// Actualizo equipos
		
		Response responseEquipo = resource.request(MediaType.APPLICATION_JSON).put(Entity.json(equipo));
		procesaRespuestaEquipo(responseEquipo);

	}
	private static void procesaGoles(EquipoPartido equipo, WebTarget resource) {
		String dorsalJugador;
		for(Gol g: equipo.getGoles()) {
			dorsalJugador = String.valueOf(g.getDorsal());
			System.out.println("Equipo = " + equipo.getNombre() + " DORSAL: " + dorsalJugador);
			WebTarget resourceJugador = resource.path("jugadores").path(dorsalJugador);
			Response responsejugador = resourceJugador.request(MediaType.APPLICATION_JSON).get(); 
			Jugador j = procesaRespuestaJugador(responsejugador);
			if(j!=null) {
				int golesPrevios = j.getGoles();
				j.setGoles(golesPrevios+1);
				// guardar jugador
				responsejugador = resourceJugador.request().put(Entity.json(j));
				procesaRespuestaJugador(responsejugador);
			}
		}
	}

	private static void procesaTarjetas(List<Tarjeta> listaTarjetas, WebTarget resource){
		String dorsalJugador;
		for(Tarjeta ta: listaTarjetas) {
			dorsalJugador = String.valueOf(ta.getDorsal());
			WebTarget resourceJugador = resource.path("jugadores").path(dorsalJugador);
			Response responsejugador = resourceJugador.request(MediaType.APPLICATION_JSON).get(); 
			Jugador j = procesaRespuestaJugador(responsejugador);
			if(j!=null) {
				int amPrevias = j.gettAmarillas();
				j.settAmarillas(amPrevias+1);
				// guardar jugador
				responsejugador = resourceJugador.request().put(Entity.json(j));
				procesaRespuestaJugador(responsejugador);
			}
		}
	}

	private static Equipo procesaRespuestaEquipo(Response response) {
		if (response.getStatus() == 200) {
			Equipo equip = response.readEntity(Equipo.class);
			System.out.println(equip.toString());
			return equip;
		} else if (response.getStatus() == 404) {
			System.out.println("El equipo indicado no existe");
			return null;
		} else {
			System.out.println(response.getStatus());
			return null;
		}
	}

	private static Jugador procesaRespuestaJugador(Response response) {
		if (response.getStatus() == 200) {
			Jugador jugador = response.readEntity(Jugador.class);
			System.out.println(jugador.toString());
			return jugador;
		} else if (response.getStatus() == 404) {
			System.out.println("El jugador indicado no existe "+ response.toString());
			return null;
		} else {
			System.out.println(response.getStatus());
			return null;
		}
	}

	private static int ganaLocal(Partido p) {
		int goleslocal = p.getLocal().getGoles().size();
		int golesvisit = p.getVisitante().getGoles().size();
		if(goleslocal > golesvisit) {
			return 1;
		}
		if(goleslocal < golesvisit) {
			return -1;
		}
		else {
			return 0;
		}

	}

}
