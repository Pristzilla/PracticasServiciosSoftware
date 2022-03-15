package es.unican.ss.SSEstimacionParadasTUS;

import javax.jws.WebService;

@WebService(targetNamespace = "http://www.unican.es/ss/SSEstimacionParadasTUS")
public interface IEstimacionParadasTUS {

	public EstimacionTUS getEstimacionSiguienteBus(String nombreParada, int linea) throws ParadaNoValidaException, DatosNoDisponiblesException;

}
