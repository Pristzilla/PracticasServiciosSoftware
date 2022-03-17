package es.unican.ss.SSEstimacionParadasTUS;
import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.unican.ss.SSEstimacionParadasTUS.DatosNoDisponiblesException;
import es.unican.ss.SSEstimacionParadasTUS.EstimacionParadasTUS;
import es.unican.ss.SSEstimacionParadasTUS.EstimacionTUS;
import es.unican.ss.SSEstimacionParadasTUS.IEstimacionParadasTUS;
import es.unican.ss.SSEstimacionParadasTUS.ParadaNoValidaException;

public class EstimacionParadasTUSIT {

	//	@BeforeClass
	//	public static void setUpBeforeClass() throws Exception {
	//	}
	//
	//	@AfterClass
	//	public static void tearDownAfterClass() throws Exception {
	//	}
	//
	//	@Before
	//	public void setUp() throws Exception {
	//	}
	//
	//	@After
	//	public void tearDown() throws Exception {
	//
	//	}

	@Test
	public void testGetEstimacionSiguienteBus()  {

		// IGIC1.a Parada y linea corresponden
		IEstimacionParadasTUS sut = new EstimacionParadasTUS();
		try {

			String nombreParada = "CORREOS";
			int linea = 1;

			EstimacionTUS estimacion = sut.getEstimacionSiguienteBus(nombreParada, linea);
			assertEquals("A.ODRIOZOLA", estimacion.getDireccion());

		} catch (ParadaNoValidaException e) {
			// No tiene que entrar aqui
			fail("No tiene que llegar a ParadaNOValida en IGIC1.a");
			e.printStackTrace();

		} catch (DatosNoDisponiblesException e) {
			// No tiene que entrar aqui
			fail("No tiene que llegar a DatosNODisponibles en IGIC1.a");
			e.printStackTrace();
		}
		// IGIC1.b Parada y linea no corresponden
		try {

			String nombreParada = "CORREOS";
			int linea = 5;

			EstimacionTUS estimacion = sut.getEstimacionSiguienteBus(nombreParada, linea);
			fail("No tiene que llegar aqui en IGIC1.b");

		} catch (ParadaNoValidaException e) {
			// Tiene que llegar aqui
			System.out.println("Parada no valida: OK");
		} catch (DatosNoDisponiblesException e) {
			// No tiene que entrar aqui
			fail("No tiene que llegar a DatosNODisponibles en IGIC1.b");
			e.printStackTrace();
		}
		// IGIC1.c Parada y linea corresponden pero DATOS NO VALIDOS
		// No se puede probar esta excepcion	

	}

}
