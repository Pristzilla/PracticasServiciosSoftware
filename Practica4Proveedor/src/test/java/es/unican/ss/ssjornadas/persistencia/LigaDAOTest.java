package es.unican.ss.ssjornadas.persistencia;

import static org.junit.Assert.*;

import java.util.List;


import org.junit.Test;

import es.unican.ss.ssjornadas.entidades.Equipo;
import es.unican.ss.ssjornadas.entidades.Grupo;

public class LigaDAOTest {
/*
	private ILigaDAO sut = new LigaDAO();



	@Test
	public void testGetGrupo() {

		String idGrupo;
		Grupo grupo;
		// IGIC1.A Grupo que existe
		idGrupo = "I";
		grupo = sut.getGrupo(idGrupo);
		assertEquals("I", grupo.getId());

		// IGIC1.b Grupo que no existe
		idGrupo = "III";
		grupo = sut.getGrupo(idGrupo);
		assertEquals(null, grupo);

		// IGIC1.b Grupo que no existe
		idGrupo = null;
		grupo = sut.getGrupo(idGrupo);
		assertEquals(null, grupo);		

	}

	@Test
	public void testGetEquipos() {
		List<Equipo> equipos;
		String idGrupo;
		//IGIC2.a IdGrupo que existe
		idGrupo = "I";
		equipos = sut.getEquipos(idGrupo);
		assertEquals("Racing de Santander", equipos.get(0).getNombre());
		assertEquals("UD Logroñes", equipos.get(3).getNombre());

		//IGIC2.a IdGrupo que NO existe
		idGrupo = "III";
		equipos = sut.getEquipos(idGrupo);
		assertEquals(null, equipos);


	}

	@Test
	public void testGetEquipo() {
		String nombreEquipo;
		Equipo e;
		// IGIC3.a nombreEquipo que existe
		nombreEquipo = "RC Deportivo";
		e = sut.getEquipo(nombreEquipo);
		assertEquals("RC Deportivo", e.getNombre());
		assertEquals(54, e.getPuntos());

		// IGIC3.b nombreEquipo que NO existe
		nombreEquipo = "Real Madrid";
		e = sut.getEquipo(nombreEquipo);
		assertNull(e);
	}

	@Test
	public void testActualizaEquipo() {

		Equipo eNuevo;
		// IGIC4.a nombreEquipo
		Equipo ePrevio = sut.getEquipo("Racing de Santander");
		int pGanadosPrevios = ePrevio.getPartidosGanados();
		int pJugadosPrevios = ePrevio.getPartidosJugados();
		int puntosPrevios = ePrevio.getPuntos();

		ePrevio.setPartidosGanados(pGanadosPrevios+1);
		ePrevio.setPartidosJugados(pJugadosPrevios+1);
		ePrevio.setPuntos(puntosPrevios +1);

		eNuevo = sut.actualizaEquipo(ePrevio);
		assertEquals("Racing de Santander", eNuevo.getNombre());
		assertEquals(61, eNuevo.getPuntos());
		assertEquals(19, eNuevo.getPartidosGanados());
		assertEquals(29, eNuevo.getPartidosJugados());

		// IGIC4.a nombreEquipo

		eNuevo = sut.actualizaEquipo(null);
		assertEquals(null, eNuevo);
//		assertEquals(61, eNuevo.getPuntos());
//		assertEquals(19, eNuevo.getPartidosGanados());
//		assertEquals(29, eNuevo.getPartidosJugados());


	}

	//	@Test
	//	public void testGetJugador() {
	//		fail("Not yet implemented");
	//	}
	//
	//	@Test
	//	public void testActualizaJugador() {
	//		fail("Not yet implemented");
	//	}
	//
	//	@Test
	//	public void testEliminaJugador() {
	//		fail("Not yet implemented");
	//	}
	//
	//	@Test
	//	public void testAnhadeJugador() {
	//		fail("Not yet implemented");
	//	}
*/
}
