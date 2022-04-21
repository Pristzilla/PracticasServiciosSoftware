package es.unican.ss.ssjornadas.procesaxml;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.unican.ss.ssjornadas.entidades.Equipo;
import es.unican.ss.ssjornadas.entidades.Grupo;
import es.unican.ss.ssjornadas.entidades.Jugador;
import es.unican.ss.ssjornadas.entidades.PrimeraRFEF;

public class ProcesaJornadasJAXBTest {
/*
	private ProcesaJornadasJAXB sut = new ProcesaJornadasJAXB();
	

	@Test
	public void testProcesaFichero() {
		PrimeraRFEF liga = sut.procesaFichero("javi");
		for(Grupo g: liga.getGrupos()) {
			System.out.println(g.getId());
			for(Equipo e: g.getEquipos()){
				System.out.println("\t"+ e.getNombre());
				for(Jugador j : e.getJugadores()) {
					System.out.println("\t\t"+ j.getNombre() + " ---dorsal: " + j.getDorsal());
				}
			}
		}
		assertEquals("I", "I");
		//fail("Not yet implemented");
	}

	@Test
	public void testEscribeFichero() {
		PrimeraRFEF liga = sut.procesaFichero("javi");
		List<Equipo> ranking = liga.getEquipos("I");
		Collections.sort(ranking);
		liga.getGrupo("I").setEquipos(ranking);
		sut.escribeFichero(liga, "javi");
		assertEquals("I", "I");
	}
*/
}
