package es.unican.ss.InsuranceSchema;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ProcesaAseguradoraSAX {

	public static void main(String[] args) {

		try {

			// Instanciar el parser
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			
			// Crear el manejador
			AseguradoraHandlerSAX handler = new AseguradoraHandlerSAX();
			
			// Parsear el fichero
			saxParser.parse("src/main/resources/InsuranceElements.xml", handler);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
