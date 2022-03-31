package es.unican.ss.InsuranceSchema;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.helpers.DefaultValidationEventHandler;

public class ProcesaAseguradoraJAXB {

	public static void main(String[] args) {
		JAXBContext jaxbctx;
		try {
			jaxbctx = JAXBContext.newInstance(Empresa.class);

			// Se procesa el documento (Unmarshall)
			Unmarshaller unmarshaller = jaxbctx.createUnmarshaller();
			unmarshaller.unmarshal(new File("src/main/resources/InsuranceElements.xml"));
			Empresa emp = (Empresa) unmarshaller.unmarshal(new File("src/main/resources/InsuranceElements.xml"));

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
				precioTotal = 0.0;
			}
			Cliente cliNuevo = new Cliente();
			cliNuevo.setDNI("00001111A");
			Seguro seguro1;
			Seguro seguro2;
			Vehiculo coche;
			Vehiculo furgoneta;
			coche = new Vehiculo("CHE1234", 80, false);
			furgoneta = new Vehiculo("FUR1234", 100, true);
			seguro1 = new Terceros("CHE-098765", coche);
			seguro1.setPrecio(seguro1.getPrecio());
			seguro2 = new TodoRiesgo("FUR-121212", furgoneta);
			seguro2.setPrecio(seguro2.getPrecio());
			List<Seguro> listaSeguros = new LinkedList<>();
			listaSeguros.add(seguro1);
			listaSeguros.add(seguro2);

			cliNuevo.setSeguros(listaSeguros);
			emp.getClientes().add(cliNuevo);

			System.out.println("*************************");

			precioTotal = 0.0;
			for (Cliente cli : emp.getClientes()) {
				System.out.println(cli.getDNI());
				for(Seguro seg: cli.getSeguros()) {
					precioTotal+= seg.getPrecio();
				}
				System.out.println("Total a pagar: " + precioTotal);
				precioTotal = 0.0;
			}
			// Se vuelca en un nuevo fichero XML
			Marshaller marshaller = jaxbctx.createMarshaller();
			marshaller.marshal(emp, new File("src/main/resources/InsuranceElementsV2.xml"));

		} catch(JAXBException e) {
			e.printStackTrace();
		}

	}

}
