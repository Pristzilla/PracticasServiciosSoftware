package es.unican.ss.SSEstimacionParadasTUS;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.jws.WebService;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.ws.Holder;
import org.tempuri.ArrayOfPasoParada;
import org.tempuri.Dinamica;
import org.tempuri.DinamicaSoap;
import org.tempuri.PasoParada;
import org.xml.sax.SAXException;



@WebService(
		endpointInterface = "es.unican.ss.SSEstimacionParadasTUS.IEstimacionParadasTUS",
		targetNamespace = "http://www.unican.es/ss/SSEstimacionParadasTUS")
public class EstimacionParadasTUS implements IEstimacionParadasTUS {

	private final String urlServicio1 = "http://datos.santander.es/api/rest/datasets/lineas_bus_secuencia.xml?query=ayto\\:Linea:";

	/**
	 * 
	 */
	public EstimacionParadasTUS() {
	}

	public EstimacionTUS getEstimacionSiguienteBus(String nombreParada, int linea)
			throws ParadaNoValidaException, DatosNoDisponiblesException {

		class SAXTerminationException extends SAXException {};

		// Primer servicio
		URL url = null;
		try {
			System.out.println(urlServicio1+linea);
			url = new URL(urlServicio1+linea);
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		}
		// Obtenemos el fichero XML con los datos
		HttpURLConnection conn = null;
		InputStream respuesta = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			respuesta = conn.getInputStream(); 
		} catch (IOException e) {
			e.printStackTrace();
		}		

		// Leemos el fichero XML
		HandlerNumeroParadaSAX handler = null; 

		try {

			// Instanciar el parser
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			// Crear el manejador
			handler = new HandlerNumeroParadaSAX(nombreParada);
			saxParser.parse(respuesta, handler);
		}
		//		catch (SAXTerminationException e) {
		//		System.out.println("SAXTERMINexception");
		//	}
		catch (SAXException e) {
			//System.out.println("SAXXexception");
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		// Comprobamos la validez de la parada
		if (!handler.paradaValida()) {
			throw new ParadaNoValidaException();
		}

		String numParada = handler.getNumeroParada();
		// Segundo servicio
		DinamicaSoap pasoParadaService = new Dinamica().getDinamicaSoap();
		Holder<ArrayOfPasoParada> resultado = new Holder<ArrayOfPasoParada>();
		Holder<Integer> status = new Holder<Integer>();
		status.value = 0;
		String nlinea = Integer.toString(linea);
		System.out.println("linea:" + nlinea + "numpa:" + numParada );
		pasoParadaService.getPasoParada(nlinea, numParada, status, resultado);
		List<PasoParada> lista = resultado.value.getPasoParada();
		if (lista.isEmpty()) {
			throw new DatosNoDisponiblesException();
		}
		PasoParada paso = lista.get(0);
		return new EstimacionTUS(paso.getE1().getMinutos(), paso.getE2().getMinutos(), paso.getRuta());



	}
}
