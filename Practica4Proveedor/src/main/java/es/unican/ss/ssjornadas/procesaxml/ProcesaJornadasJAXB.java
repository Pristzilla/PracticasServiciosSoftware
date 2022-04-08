package es.unican.ss.ssjornadas.procesaxml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import es.unican.ss.ssjornadas.entidades.PrimeraRFEF;

public class ProcesaJornadasJAXB {
	
	private PrimeraRFEF liga = null;

	JAXBContext jaxbctx = null;
	String ruta;
	public PrimeraRFEF procesaFichero(String ordenadorDe) {
		
		if(ordenadorDe.equals("sara")) {
			ruta="C:/Users/Sara/Desktop/Uni/SS/primeraRFEF.xml";
		}
		else {
			ruta = "/Users/barquinj/GitHub/PracticasServiciosSoftware/primeraRFEF.xml";
		}
		try {
			jaxbctx = JAXBContext.newInstance(PrimeraRFEF.class);

			// Se procesa el documento (Unmarshall)
			Unmarshaller unmarshaller = jaxbctx.createUnmarshaller();
			liga = (PrimeraRFEF) unmarshaller.unmarshal(new File(ruta));
			return liga;
		}catch(JAXBException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public PrimeraRFEF escribeFichero(PrimeraRFEF ligaAGuardar, String ordenadorDe) {
		liga = ligaAGuardar;
		if(ordenadorDe.equals("sara")) {
			ruta="C:/Users/Sara/Desktop/Uni/SS/primeraRFEF.xml";
		}
		else {
			ruta = "/Users/barquinj/GitHub/PracticasServiciosSoftware/primeraRFEFcopia.xml";
		}
		try {
			jaxbctx = JAXBContext.newInstance(PrimeraRFEF.class);

			// Se procesa el documento (Unmarshall)
			// Se vuelca en un nuevo fichero XML
			Marshaller marshaller = jaxbctx.createMarshaller();
			marshaller.marshal(liga, new File(ruta));
			return liga;
		}catch(JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
}
