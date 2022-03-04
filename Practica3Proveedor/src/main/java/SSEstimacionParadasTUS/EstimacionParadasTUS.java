package SSEstimacionParadasTUS;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.jws.WebService;

@WebService(endpointInterface = "es.unican.ss.SSEstimacionParadasTUS.IEstimacionParadasTUS",
targetNamespace = "http://unican.es/ss/SSEstimacionParadasTUS")
public class EstimacionParadasTUS implements IEstimacionParadasTUS {
	private final String urlParada = "http://datos.santander.es/api/rest/datasets/lineas_bus_secuencia.json?query=ayto|:Linea:";

	public EstimacionTUS getEstimacionSiguienteBus(String nombreParada, int linea)
			throws ParadaNoValidaException, DatosNoDisponiblesException {
		try {
			URL url = new URL(urlParada+linea);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET"); 

			InputStream respuesta = conn.getInputStream(); 
		}
		catch(IOException e){
			e.printStackTrace();
		}
		EstimacionTUS est = new EstimacionTUS();
		return est;

	}



}
