package es.unican.ss.Practica6Proveedor.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.unican.ss.Practica6Proveedor.entidades.Cliente;
import es.unican.ss.Practica6Proveedor.entidades.Seguro;
import es.unican.ss.Practica6Proveedor.repositorios.ClientesRepository;
import es.unican.ss.Practica6Proveedor.repositorios.SegurosRepository;
import es.unican.ss.Practica6Proveedor.repositorios.VehiculosRepository;


public class EmpresaSegurosService {
	
	@Autowired
	private ClientesRepository clientesrepo;
	@Autowired
	private SegurosRepository segurosrepo;
	@Autowired
	private VehiculosRepository vehiculorepo;
	
	
	public Cliente buscaClientePorDNI(String dni) {
		return clientesrepo.getById(dni);
	}
	public Cliente anhadeCliente(Cliente c) {
		return clientesrepo.save(c);
	}
	public Seguro anhadeSeguroACliente(Seguro s, String dni) {
		return segurosrepo.save(s); //TODO: modificar cuando se pongan las anotaciones 
	}
	public List<Cliente> listaClientes() {
		return clientesrepo.findAll();
	}
	
	
	

}
