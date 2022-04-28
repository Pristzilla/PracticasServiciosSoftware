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
import es.unican.ss.ssjornadas.entidades.Gol;
import es.unican.ss.ssjornadas.entidades.Grupo;
import es.unican.ss.ssjornadas.entidades.Jornada;
import es.unican.ss.ssjornadas.entidades.Jugador;
import es.unican.ss.ssjornadas.entidades.Partido;
import es.unican.ss.ssjornadas.entidades.TarjetaAmarilla;
import es.unican.ss.ssjornadas.entidades.TarjetaRoja;
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
		WebTarget resource = base.path(idgrupo);
		Response response = resource.request(MediaType.APPLICATION_XML).get(); 
		Grupo grupo = procesaRespuestaGrupo(response);
		
		for(Partido p: jornada.getPartidos()) {
			Equipo e = grupo.getEquipo(p.getLocal().getNombre());
			if(e != null) {
				e.setPartidosJugados(e.getPartidosJugados()+1);
				if(p.getLocal().getGoles().size() > p.getVisitante().getGoles().size()) {
					// gana el visitante
					e.setPartidosGanados(e.getPartidosGanados()+1);
				}else {
					e.setPartidosPerdidos(e.getPartidosPerdidos()+1);
				}
				for(Gol g: p.getLocal().getGoles()) {
					Jugador j = e.getJugador(g.getDorsal());
					int golesPrevios = j.getGoles();
					j.setGoles(golesPrevios+1);
					// guardar jugador
				}
				for(TarjetaAmarilla ta: p.getLocal().getTAmarillas()) {
					Jugador j = e.getJugador(ta.getDorsal());
					int amPrevias = j.gettAmarillas();
					j.settAmarillas(amPrevias+1);
				}
				for(TarjetaRoja tr: p.getLocal().getTRojas()) {
					Jugador j = e.getJugador(tr.getDorsal());
					int rjPrevias = j.gettRojas();
					j.settRojas(rjPrevias+1);
				}
				
			}
		}

	
	

	}

	private static Grupo procesaRespuestaGrupo(Response response) {
		if (response.getStatus() == 200) {
			Grupo grupo = response.readEntity(Grupo.class);
			System.out.println(grupo.toString());
			return grupo;
		} else if (response.getStatus() == 404) {
			System.out.println("El grupo indicado no existe");
			return null;
		} else {
			System.out.println(response.getStatus());
			return null;
		}
	}

}
