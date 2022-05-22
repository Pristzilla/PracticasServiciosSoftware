package es.unican.ss.Practica6Proveedor.controlador;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import es.unican.ss.Practica6Proveedor.entidades.Cliente;
import es.unican.ss.Practica6Proveedor.entidades.Seguro;
import es.unican.ss.Practica6Proveedor.entidades.Terceros;
import es.unican.ss.Practica6Proveedor.servicio.EmpresaSegurosService;

@RestController
@RequestMapping("/ssEmpresa/clientes")
public class EmpresaSegurosController {

	@Autowired
	private EmpresaSegurosService empService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getAllClientes() {
		List<Cliente> lista = empService.listaClientes();
		if(lista != null) {
			return ResponseEntity.ok(lista);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{dni}")
	public ResponseEntity<Cliente> getCliente(@PathVariable String dni) {
		Cliente c = empService.buscaClientePorDNI(dni);
		if(c != null) {
			return ResponseEntity.ok(c);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{dni}")
	public ResponseEntity<Cliente> addCliente(@RequestBody Cliente c, @PathVariable String dni) {
		Cliente creado = empService.anhadeCliente(c);
		if(creado == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(location).body(creado);
	}
	
	@GetMapping("/{dni}/totalAPagar")
	public ResponseEntity<Double> getTotalAPagarDeCliente(@PathVariable String dni) {
		Cliente c = empService.buscaClientePorDNI(dni);
		if(c != null) {
			double total = c.getTotalAPagar();
			return ResponseEntity.ok(total);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/{dni}/seguros")
	public ResponseEntity<Seguro> addSeguroACliente(@RequestBody Seguro s, @PathVariable String dni) {
		Cliente c = empService.buscaClientePorDNI(dni);
		if(c != null) {
			Seguro segAnadido = empService.anhadeSeguroACliente(s, dni);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(segAnadido.getId()).build().toUri();
			System.out.println(location.getPath());
			return ResponseEntity.created(location).body(segAnadido);
		}
		return ResponseEntity.notFound().build();
	}
	
	
}
