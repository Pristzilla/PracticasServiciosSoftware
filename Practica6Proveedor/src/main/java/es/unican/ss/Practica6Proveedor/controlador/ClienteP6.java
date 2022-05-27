package es.unican.ss.Practica6Proveedor.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import es.unican.ss.Practica6Proveedor.dtos.SeguroDTO;
import es.unican.ss.Practica6Proveedor.entidades.Cliente;
import es.unican.ss.Practica6Proveedor.entidades.Seguro;
import es.unican.ss.Practica6Proveedor.entidades.Terceros;
import es.unican.ss.Practica6Proveedor.entidades.Vehiculo;

public class ClienteP6 {

	private static final String URIBase="http://localhost:8080/ssEmpresa/clientes";
	public static void main(String[] args) {
		RestTemplate r = new RestTemplate();
		
		Cliente nuevo = new Cliente();
		nuevo.setDNI("12121212A");
		nuevo.setNombre("Beatriz");
		nuevo.setEmail("bea@gmail.com");
		
		Vehiculo v = new Vehiculo("0447DPL", 85, false);
		Seguro seg = new Terceros(v);
		// Guardamos el cliente
		r.put(URIBase+"/"+nuevo.getDNI(), nuevo);
		// Anhadimos eel seguro
		SeguroDTO sdto = new SeguroDTO(seg);
		r.postForObject(URIBase+"/"+nuevo.getDNI()+"/seguros", sdto, null);
		ResponseEntity<Double> re = r.getForEntity(URIBase+"/"+nuevo.getDNI()+"/totalAPagar", null);
		
		System.out.println(re.getBody());
		
	
	}


}
