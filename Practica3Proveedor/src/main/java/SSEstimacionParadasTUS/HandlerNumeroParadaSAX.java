package SSEstimacionParadasTUS;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HandlerNumeroParadaSAX extends DefaultHandler {
	
	private boolean leerNumParada = false;
	private String numParada = null;
	private boolean leerNombreParada = false;
	private String nombreParada = null;
	private String nombreParadaParametro;
	private String texto = null;
	private boolean isEqual = false;
	
	public HandlerNumeroParadaSAX() {}
	
	public HandlerNumeroParadaSAX(String nombreParada) {
		this.nombreParadaParametro = nombreParada;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("str") && attrs.getValue("name").equals("ayto:NParada")) {
			leerNumParada = true;
		}
		if (qName.equals("str") && attrs.getValue("name").equals("ayto:NombreParada")) {
			leerNombreParada = true;
		}
	}	

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("str") && leerNumParada) {
			numParada = texto;
			leerNumParada = false;
		}
		if (qName.equals("str") && leerNombreParada) {
			nombreParada = texto;
			leerNombreParada = false;
		}
		if (qName.equals("resource")) {
			if (nombreParada.equals(nombreParadaParametro)) {
				isEqual = true;
				// PARAR DE LEER EL DOCUMENTO - lanzar excepcion ?
			} 
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		texto = new String(ch, start, length).trim(); 
	}
	
	public String getNumeroParada() {
		return numParada;
	}
	
	public String getNombreParada() {
		return nombreParada;
	}
	
	public boolean getIsEqual() {
		return isEqual;
	}
}
