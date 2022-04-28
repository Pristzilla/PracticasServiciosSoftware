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
import es.unican.ss.ssjornadas.entidadespartido.Gol;
import es.unican.ss.ssjornadas.entidades.Grupo;
import es.unican.ss.ssjornadas.entidadespartido.Jornada;
import es.unican.ss.ssjornadas.entidades.Jugador;
import es.unican.ss.ssjornadas.entidadespartido.Partido;
import es.unican.ss.ssjornadas.entidadespartido.TarjetaAmarilla;
import es.unican.ss.ssjornadas.entidadespartido.TarjetaRoja;
import es.unican.ss.ssjornadas.procesaxml.ProcesaJornadaJAXB;

public class PrimeraRFEFCliente {

	public static void main(String[] args) {
		
		ProcesaJornadaJAXB procesaxml = new ProcesaJornadaJAXB();
		Jornada jornada = procesaxml.procesaFichero("javi");
//		System.out.println("Jornada num: "+ jornada.getNumJornada() + "\t Grupo: " + jornada.getGrupo());
//		for(Partido p: jornada.getPartidos()) {
//			System.out.println(p.toString());
//		}
		
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
			Response responseLocal = resourceLocal.request(MediaType.APPLICATION_XML).get(); 
			Equipo eLocal = procesaRespuestaEquipo(responseLocal);
			// peticion al equipo VISITANTE
			Response responseVisitante = resourceVisitante.request(MediaType.APPLICATION_XML).get(); 
			Equipo eVisitante = procesaRespuestaEquipo(responseVisitante);
			 
			if(eLocal != null) {
				int jugadoslocal = eLocal.getPartidosJugados();
				eLocal.setPartidosJugados(jugadoslocal+1);
				
				if(ganaLocal(p)) {
					// gana el local
					int ganadoslocal = eLocal.getPartidosGanados();
					eLocal.setPartidosGanados(ganadoslocal+1);
				}else {
					int perdidoslocal = eLocal.getPartidosPerdidos();
					eLocal.setPartidosPerdidos(perdidoslocal+1);
				}
				// Actualizo equipos
				
				// recorro goles
				String dorsalJugador;
				for(Gol g: p.getLocal().getGoles()) {
					dorsalJugador = String.valueOf(g.getDorsal());
					WebTarget resourceJugador = resourceLocal.path(dorsalJugador);
					Response responsejugador = resourceJugador.request(MediaType.APPLICATION_XML).get(); 
					Jugador j = procesaRespuestaJugador(responsejugador);
					if(j!=null) {
						int golesPrevios = j.getGoles();
						j.setGoles(golesPrevios+1);
						// guardar jugador
						responsejugador = resourceJugador.request().put(Entity.xml(j));
						procesaRespuestaJugador(responsejugador);
						
					}
					
					
				}
				for(TarjetaAmarilla ta: p.getLocal().getTAmarillas()) {
					dorsalJugador = String.valueOf(ta.getDorsal());
					int amPrevias = j.gettAmarillas();
					j.settAmarillas(amPrevias+1);
				}
				for(TarjetaRoja tr: p.getLocal().getTRojas()) {
					Jugador j = e.getJugador(tr.getDorsal());
					int rjPrevias = j.gettRojas();
					j.settRojas(rjPrevias+1);
				}
				
			}
			else {
				System.out.println("Error: equipo local con nombre: " + p.getLocal().getNombre() + " no encontrado." + resourceLocal.getUri());
			}
			if(eVisitante!=null) {
				int jugadosvisit = eVisitante.getPartidosJugados();
				
				eVisitante.setPartidosJugados(jugadosvisit+1);
				
				if(ganaLocal(p)) {
					int perdidosvisit = eVisitante.getPartidosPerdidos();
					eVisitante.setPartidosPerdidos(perdidosvisit+1);
				} else {
					int ganadosvisit = eVisitante.getPartidosGanados();
					eVisitante.setPartidosGanados(ganadosvisit+1);

				}

			}else {
				System.out.println("Error: equipo visitante con nombre: " + p.getVisitante().getNombre() + " no encontrado." + resourceVisitante.getUri());
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
			System.out.println("El jugador indicado no existe");
			return null;
		} else {
			System.out.println(response.getStatus());
			return null;
		}
	}
	
	private static boolean ganaLocal(Partido p) {
		return p.getLocal().getGoles().size()>p.getVisitante().getGoles().size();
		
	}

}
