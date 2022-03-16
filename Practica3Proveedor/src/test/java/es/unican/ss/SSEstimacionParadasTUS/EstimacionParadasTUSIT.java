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
//		Endpoint endpoint = Endpoint.publish("http://localhost:8080/SSEstimacionParadasTUS", new EstimacionParadasTUS());
//		URL url = null;
//		try {
//			url = new URL("http://localhost:8080/SSEstimacionParadasTUS?wsdl");
//
//		} catch(MalformedURLException e) {
//			e.printStackTrace();
//		}
//
//		QName serviceQName = new QName("http://www.unican.es/ss/SSEstimacionParadasTUS", "EstimacionParadasTUSService");
//		QName portQName = new QName("http://www.unican.es/ss/SSEstimacionParadasTUS", "EstimacionParadasTUSPort");
//
//		Service service = Service.create(url, serviceQName);
//		IEstimacionParadasTUS sut = service.getPort(portQName, IEstimacionParadasTUS.class);
//		// IGIC1.a Parada y linea corresponden
		IEstimacionParadasTUS sut = new EstimacionParadasTUS();
		try {
			
			String nombreParada = "AVENIDA CANTABRIA 43";
			int linea = 61;
			
			EstimacionTUS estimacion = sut.getEstimacionSiguienteBus(nombreParada, linea);
			assertEquals("1", estimacion.getDireccion());

		} catch (ParadaNoValidaException e) {
			// No tiene que entrar aqui
			fail("No tiene que llegar a ParadaNOValida en IGIC1.a");
			e.printStackTrace();
			
		} catch (DatosNoDisponiblesException e) {
			// No tiene que entrar aqui
			fail("No tiene que llegar a DatosNODisponibles en IGIC1.b");
			e.printStackTrace();
		}
		// IGIC1.b Parada y linea no corresponden
		try {

			String nombreParada = "AVENIDA CANTABRIA 100";
			int linea = 61;

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
		try {

			String nombreParada = "AVENIDA CANTABRIA 43";
			int linea = 61;

			EstimacionTUS estimacion = sut.getEstimacionSiguienteBus(nombreParada, linea);
			fail("No tiene que llegar aqui en IGIC1.c");

		} catch (ParadaNoValidaException e) {
			// No tiene que llegar aqui
			fail("No tiene que llegar a ParadaNoValida en IGIC1.c");
		} catch (DatosNoDisponiblesException e) {
			// Tiene que entrar aqui
			System.out.println("DatosNoValidos: OK");

		}


//		endpoint.stop();
	}

}