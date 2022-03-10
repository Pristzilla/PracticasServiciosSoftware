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

import SSEstimacionParadasTUS.DatosNoDisponiblesException;
import SSEstimacionParadasTUS.EstimacionParadasTUS;
import SSEstimacionParadasTUS.EstimacionTUS;
import SSEstimacionParadasTUS.IEstimacionParadasTUS;
import SSEstimacionParadasTUS.ParadaNoValidaException;

public class EstimacionParadasTUSIT {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testGetEstimacionSiguienteBus()  {
		Endpoint endpoint = Endpoint.publish("http://unican.es/ss/SSEstimacionPatadasTUS", new EstimacionParadasTUS());
		try {
			URL url = new URL("http://unican.es/ss/SSEstimacionPatadasTUS?wsdl");
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			QName serviceQName = new QName("http://unican.es/ss/SSEstimacionPatadasTUS", "EstimacionParadasTUSService");
			QName portQName = new QName("http://unican.es/ss/SSEstimacionPatadasTUS", "EstimacionParadasTUSPort");
			
			URL url;
			Service service = Service.create(url, serviceQName);
			IEstimacionParadasTUS sut = service.getPort(portQName, IEstimacionParadasTUS.class);
			
			String nombreParada = "AVENIDA CANTABRIA 43";
			int linea = 62;
			// IGIC1.a Parada y linea corresponden
			
			EstimacionTUS estimacion = sut.getEstimacionSiguienteBus(nombreParada, linea);
			assertEquals(estimacion.getEstimacion1(), 1);

		 catch (ParadaNoValidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatosNoDisponiblesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		endpoint.stop();
	}

}
