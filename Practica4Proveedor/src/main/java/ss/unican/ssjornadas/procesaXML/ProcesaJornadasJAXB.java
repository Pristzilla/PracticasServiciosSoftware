package ss.unican.ssjornadas.procesaXML;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ss.unican.ssjornadas.entidades.PrimeraRFEF;

public class ProcesaJornadasJAXB {
	
	public PrimeraRFEF procesaFichero(String ordenador) {

		JAXBContext jaxbctx = null;
		PrimeraRFEF liga = null;
		String ruta;
		if(ordenador.equals("sara")) {
			ruta="/Usuarios/Windows/Sara";
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
}
