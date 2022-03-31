package ss.unican.ssjornadas.procesaXML;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ss.unican.ssjornadas.entidades.PrimeraRFEF;

public class ProcesaJornadasJAXB {
	
	public static void main(String[] args) {

		JAXBContext jaxbctx = null;
		try {
			jaxbctx = JAXBContext.newInstance(PrimeraRFEF.class);

			// Se procesa el documento (Unmarshall)
			Unmarshaller unmarshaller = jaxbctx.createUnmarshaller();
			PrimeraRFEF liga = (PrimeraRFEF) unmarshaller.unmarshal(new File("src/main/resources/InsuranceElements.xml"));
		}catch(JAXBException e) {
			e.printStackTrace();
		}

	}
}
