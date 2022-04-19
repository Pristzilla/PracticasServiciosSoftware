package es.unican.ss.ssjornadas.cliente;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PrimeraRFEFCliente {

	public static void main(String[] args) {
		// Creamos el Client
		Client client = ClientBuilder.newClient();
		// Creamos el WebTarget base (raíz del servicio o recurso raíz)
		WebTarget base = client.target("http://localhost:8080/SSPrimeraRFEF/liga/"); 
		// Recurso Pepe
		WebTarget resource = base.path("grupo/I"); 
		// Creamos la invocacion con ACCEPT = text/plain
		Response response = resource.request(MediaType.APPLICATION_XML).get();
		procesaRespuesta(response);
		// Enviamos petición a Manuel (No existe)
		resource = base.path("usuariosv3/Manuel");
		response = resource.request(MediaType.APPLICATION_XML).get(); 
		procesaRespuesta(response);
		// Creamos un nuevo usuario
		Usuario u = new Usuario("Manuel", "manuel@hotmail.com");
		resource = base.path("usuariosv3/Manuel");
		response = resource.request().put(Entity.xml(u));

	}

	private static void procesaRespuesta(Response response) {
		if (response.getStatus() == 200) {
			Usuario us= response.readEntity(Usuario.class);
			System.out.println(us.toString());
		} else if (response.getStatus()==404) {
			System.out.println("El usuario indicado no existe");
		} else {
			System.out.println(response.getStatus());
		}
	}

}
