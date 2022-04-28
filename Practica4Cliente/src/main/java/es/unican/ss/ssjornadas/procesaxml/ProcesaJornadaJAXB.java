package es.unican.ss.ssjornadas.procesaxml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import es.unican.ss.ssjornadas.entidades.Jornada;

public class ProcesaJornadaJAXB {

	private Jornada jornada = null;

	JAXBContext jaxbctx = null;
	String ruta;
	public Jornada procesaFichero(String ordenadorDe) {
		
		if(ordenadorDe.equals("sara")) {
			ruta="C:/Users/Sara/Desktop/Uni/SS/jornada37.xml";
		}
		else {
			ruta = "/Users/barquinj/GitHub/PracticasServiciosSoftware/jornada37.xml";
		}
		try {
			jaxbctx = JAXBContext.newInstance(Jornada.class);

			// Se procesa el documento (Unmarshall)
			Unmarshaller unmarshaller = jaxbctx.createUnmarshaller();
			jornada = (Jornada) unmarshaller.unmarshal(new File(ruta));
			return jornada;
		}catch(JAXBException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
