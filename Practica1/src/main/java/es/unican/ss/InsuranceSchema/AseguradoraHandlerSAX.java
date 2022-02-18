package es.unican.ss.InsuranceSchema;


import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AseguradoraHandlerSAX extends DefaultHandler {

	private String dniCliente = null;
	private List<String> matriculasCliente = new LinkedList<String>();
	private List<String> segurosCliente = new LinkedList<String>();
	private String fecha = null;
	private String idSeguro = null;
	private String texto = null;
	private boolean isIdEquals = false;
	
	// Este methodo en realidad no hace falta, se pone a modo
	// de ejemplo
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Empiezo a parsear");
	}

	// Este methodo en realidad no hace falta, se pone a modo
	// de ejemplo
	@Override
	public void endDocument() throws SAXException {
		System.out.println("Finalizo el parseo");
	}

	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		switch (qName) {
		case "clientes":
			dniCliente = attrs.getValue("dni");
			break;
		case "seguros":
			segurosCliente.add(attrs.getValue("id"));
			break;
		case "vehiculoAsegurado":
			matriculasCliente.add(attrs.getValue("matricula"));
			break;
		case "partes": 
			fecha = attrs.getValue("fecha");
			break;
		default:
			break;
		}

		System.out.println("Cliente: "+ dniCliente+ "  numero de seguros: "+ segurosCliente.size());
		System.out.println("Listado de matriculas");
		for (String m : matriculasCliente) {
			System.out.println("Matricula " + m);
		}
		dniCliente=null;
		matriculasCliente.clear();
		segurosCliente.clear();
		fecha = null;
	}	
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case "seguro": 
			idSeguro = texto;
			break;
		}
		
		int i = 0;
		while (i < segurosCliente.size() || !isIdEquals) {
			if (segurosCliente.get(i).equals(idSeguro)) {
				isIdEquals = true;
			}
			i++;
		}
		
		if (!isIdEquals) {
			System.out.println("El parte de accidente con fecha " + fecha + "no pertenece a ningun seguro valido");
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		texto = new String(ch, start, length).trim(); 
	}
}
