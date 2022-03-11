package SSEstimacionParadasTUS;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.ws.Holder;

import org.tempuri.ArrayOfInfoAccion;
import org.tempuri.ArrayOfPasoParada;
import org.tempuri.Dinamica;
import org.tempuri.DinamicaSoap;
import org.tempuri.PasoParada;
import org.xml.sax.SAXException;

import SSEstimacionParadasTUS.HandlerNumeroParadaSAX.SAXTerminationException;



@WebService(endpointInterface = "es.unican.ss.SSEstimacionParadasTUS.IEstimacionParadasTUS",
targetNamespace = "http://unican.es/ss/SSEstimacionParadasTUS")
public class EstimacionParadasTUS implements IEstimacionParadasTUS {

	private final String urlServicio1 = "http://datos.santander.es/api/rest/datasets/lineas_bus_secuencia.xml?query=ayto|:Linea:";

	public EstimacionTUS getEstimacionSiguienteBus(String nombreParada, int linea)
			throws ParadaNoValidaException, DatosNoDisponiblesException {

		// Primer servicio
		URL url = compruebaURL(urlServicio1+linea);
		if (url != null) {

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET"); 
			InputStream respuesta = conn.getInputStream(); 

			// Instanciar el parser
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			// Crear el manejador
			HandlerNumeroParadaSAX handler = new HandlerNumeroParadaSAX();

			try {
				saxParser.parse(respuesta, handler);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Comprobamos la validez de la parada
			if (!handler.getIsEqual()) {
				throw new ParadaNoValidaException();
			}

			String numParada = handler.getNumeroParada();

			// Segundo servicio
			// TODO: establecer conexion 
			DinamicaSoap pasoParadaService = new Dinamica().getDinamicaSoap();
			Holder<ArrayOfPasoParada> resultado = new Holder<ArrayOfPasoParada>();
			pasoParadaService.getPasoParada(nombreParada, numParada, 0, resultado);
			List<PasoParada> lista = resultado.value.getPasoParada();
			if (lista.isEmpty()) {
				throw new DatosNoDisponiblesException();
			}
			PasoParada pp = lista.get(0);
			
			return new EstimacionTUS(pp.getE1().getMinutos(), pp.getE2().getMinutos(), pp.getRuta());

		} else {
			throw new DatosNoDisponiblesException();
		}
	}

	private URL compruebaURL(String direccion) {
		URL url;
		try {
			url = new URL(direccion);
		} catch (MalformedURLException e) {
			url = null;
			e.printStackTrace();
		}
		return url;
	}

}
