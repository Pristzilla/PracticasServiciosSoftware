package es.unican.ss.InsuranceSchema;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ProcesaAseguradoraJAXB {

	public static void main(String[] args) {
		JAXBContext jaxbctx;
		try {
			jaxbctx = JAXBContext.newInstance(Empresa.class);

			// Se procesa el documento (Unmarshall)
			Unmarshaller unmarshaller = jaxbctx.createUnmarshaller();
			Empresa emp = (Empresa) unmarshaller.unmarshal(new File("InsuranceElements.xml"));

			// Hay que mostrar DNI de cada cliente, NUM seguros a su nombre,
			/**
			 * Hay que mostrar:
			 * 		DNI de cada cliente
			 * 		Suma del importe de todos los seguros
			 * Hay que anhadir un nuevo cliente y guardarlo en un fichero nuevo
			 * 
			 */
			double precioTotal = 0.0;
			
			for (Cliente cli : emp.getClientes()) {
				System.out.println(cli.getDNI());
				for(Seguro seg: cli.getSeguros()) {
					precioTotal+= seg.getPrecio();
				}
				System.out.println("Total a pagar: " + precioTotal);
			
			}
			Cliente cliNuevo = new Cliente();
			Seguro seguro1;
			Seguro seguro2;
			Vehiculo coche;
			Vehiculo furgoneta;
			coche = new Vehiculo("CHE1234", 80, false);
			furgoneta = new Vehiculo("FUR1234", 100, true);
			seguro1 = new Terceros("CHE-098765", coche);
			seguro2 = new TodoRiesgo("FUR-121212", furgoneta);
			List<Seguro> listaSeguros = new LinkedList<Seguro>();
			listaSeguros.add(seguro1);
			listaSeguros.add(seguro2);

			cliNuevo.setSeguros(listaSeguros);
			emp.getClientes().add(cliNuevo);
			
			// Se vuelca en un nuevo fichero XML
			Marshaller marshaller = jaxbctx.createMarshaller();
			marshaller.marshal(emp, new File("InsuranceElementsV2.xml"));

		} catch(JAXBException e) {
			e.printStackTrace();
		}

	}

}