package SSEstimacionParadasTUS;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.jws.WebService;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import SSEstimacionParadasTUS.HandlerNumeroParadaSAX.SAXTerminationException;



@WebService(endpointInterface = "es.unican.ss.SSEstimacionParadasTUS.IEstimacionParadasTUS",
targetNamespace = "http://unican.es/ss/SSEstimacionParadasTUS")
public class EstimacionParadasTUS implements IEstimacionParadasTUS {
	
	private final String urlServicio1 = "http://datos.santander.es/api/rest/datasets/lineas_bus_secuencia.xml?query=ayto|:Linea:";

	public EstimacionTUS getEstimacionSiguienteBus(String nombreParada, int linea)
			throws ParadaNoValidaException, DatosNoDisponiblesException {
		try {
			// Primer servicio
			URL url = new URL(urlServicio1+linea);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET"); 
			InputStream respuesta = conn.getInputStream(); 
			
			// Instanciar el parser
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			
			// Crear el manejador
			HandlerNumeroParadaSAX handler = new HandlerNumeroParadaSAX();
			
			// Parsear el fichero
			try {
				saxParser.parse(respuesta, handler);
			} catch (SAXTerminationException e) {
				// Ha encontrado el nombre de la parada
			}
			
			// Comprobamos la validez de la parada
			if (!handler.getIsEqual()) {
				throw new ParadaNoValidaException();
			}
			
			String numParada = handler.getNumeroParada();
			
			// Segundo servicio
			// TODO: establecer conexion 
			HelloWorldService helloService = new HelloWorldService();
			HelloInterface aytoPort = helloService.getHelloWorldPort();
			List<String> resultado = aytoPort.getPasoParada(numParada,linea,0);
			
			if (resultado.isEmpty()) {
				throw new DatosNoDisponiblesException();
			}
			
			EstimacionTUS est = new EstimacionTUS(resultado[0], resultado[1], resultado[2]);
			return est;
		}
		catch(IOException e){
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
