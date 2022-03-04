package SSEstimacionParadasTUS;

import javax.jws.WebService;

@WebService(targetNamespace = "http://unican.es/ss/SSEstimacionParadasTUS")
public interface IEstimacionParadasTUS {

	public EstimacionTUS getEstimacionSiguienteBus(String nombreParada, int linea) throws ParadaNoValidaException, DatosNoDisponiblesException;

}
