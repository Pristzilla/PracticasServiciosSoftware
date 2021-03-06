package es.unican.ss.Practica6Proveedor.servicio;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.unican.ss.Practica6Proveedor.entidades.Cliente;
import es.unican.ss.Practica6Proveedor.entidades.Seguro;
import es.unican.ss.Practica6Proveedor.repositorios.ClientesRepository;
import es.unican.ss.Practica6Proveedor.repositorios.SegurosRepository;

@Service
public class EmpresaSegurosService {
	
	@Autowired
	private ClientesRepository clientesrepo;
	
	@Autowired
	private SegurosRepository segurosrepo;
	
	
	
	public Cliente buscaClientePorDNI(String dni) {
		return clientesrepo.findById(dni).orElse(null);
	}
	public Cliente anhadeCliente(Cliente c) {
		return clientesrepo.save(c);
	}
	public Seguro anhadeSeguroACliente(Seguro s, String dni) {
		
		Cliente c = buscaClientePorDNI(dni);
		if (s != null && c!=null && s.getVehiculoAsegurado()!= null) {
			//s = segurosrepo.save(s);
			if(c.anhadeSeguro(s)) {
				clientesrepo.save(c);	
			}
			return  s;
		}
		return null;
	}
	
	public List<Cliente> listaClientes() {
		return clientesrepo.findAll();
	}
	
	public Seguro buscaSeguroPorMatricula (String matricula) {
		if (matricula!=null) {
			return segurosrepo.findByVehiculo_fk(matricula);
		}
		return null;
	}
	
	
	

}
