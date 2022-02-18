package es.unican.ss.InsuranceSchema;


import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AseguradoraAtributosHandler extends DefaultHandler {

	private String dniCliente = null;
	private int numSegurosCliente = 0;
	private List<String> matriculasCliente = new LinkedList<String>();
	String fecha = null;
	
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

		if (qName.equals("Cliente")) {
			dniCliente = attrs.getValue("dni");
		} else if (qName.equals("Seguro")) {
			numSegurosCliente++;
		} else if (qName.equals("Vehiculo")) {
			matriculasCliente.add(attrs.getValue("matricula"));
		} else if (qName.equals("Parte")) {
			String s = attrs.getValue("seguro");
			fecha = null; // TODO: igualar a la fecha del seguro
			// TODO: falta mostrar el mensaje de aviso en caso de que el parte no coincida
			if (!fecha.equals("METER LA OTRA FECHA")) {
				System.out.println("El parte de accidente con fecha " + fecha + "no pertenece a ningún seguro válido");
			}
		}
		System.out.println("Cliente: "+ dniCliente+ "  numero de seguros: "+ numSegurosCliente);
		System.out.println("Listado de matrículas"); // TODO: estara bien hecho?
		for (String m : matriculasCliente) {
			System.out.println("Matricula " + m);
		}
		dniCliente=null;
		numSegurosCliente = 0;
		matriculasCliente.clear();
		fecha = null;
	}	
}
