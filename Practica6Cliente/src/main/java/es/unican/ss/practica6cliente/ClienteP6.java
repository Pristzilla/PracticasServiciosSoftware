package es.unican.ss.practica6cliente;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import es.unican.ss.practica6cliente.dtos.SeguroDTO;
import es.unican.ss.practica6cliente.entidades.Cliente;
import es.unican.ss.practica6cliente.entidades.Seguro;
import es.unican.ss.practica6cliente.entidades.Terceros;
import es.unican.ss.practica6cliente.entidades.Vehiculo;

public class ClienteP6 {

	private static final String URIBase="http://localhost:8080/ssEmpresa/clientes";
	public static void main(String[] args) {
		RestTemplate r = new RestTemplate();
		
		Cliente cliNuevo = new Cliente();
		cliNuevo.setDNI("00011122X");
		cliNuevo.setNombre("Beatriz");
		cliNuevo.setEmail("bea@gmail.com");
		
		Vehiculo v = new Vehiculo("0447DPL", 85, false);
		Seguro seg = new Terceros(v);
		// Guardamos el cliente
		r.put(URIBase+"/"+cliNuevo.getDNI(), cliNuevo);
		// Anhadimos eel seguro
		SeguroDTO sdto = new SeguroDTO(seg);
		r.postForLocation(URIBase+"/"+cliNuevo.getDNI()+"/seguros",sdto);
		ResponseEntity<Double> re = r.getForEntity(URIBase+"/"+cliNuevo.getDNI()+"/totalAPagar", Double.class);
		ResponseEntity<Cliente> rcli = r.getForEntity(URIBase+"/"+cliNuevo.getDNI(), Cliente.class);
		imprimeCliente(rcli.getBody());
		System.out.println("Precio a pagar: " + re.getBody() + "€.");
		
	
	}
	private static void imprimeCliente(Cliente cliente) {
		StringBuilder sb = new StringBuilder();
		sb.append("Cliente: ");
		if (cliente != null) {
			sb.append(cliente.getNombre() + " - " + cliente.getEmail() + " - DNI: " + cliente.getDNI() + "\n");
					
		}
		System.out.println(sb.toString());
	}


}
