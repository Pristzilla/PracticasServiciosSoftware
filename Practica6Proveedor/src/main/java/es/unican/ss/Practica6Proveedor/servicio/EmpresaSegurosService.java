package es.unican.ss.Practica6Proveedor.servicio;

import org.springframework.beans.factory.annotation.Autowired;

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
	
	
	

}
