package es.unican.ss.Practica6Proveedor.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="empresa")
@XmlType(name="Empresa")
@XmlAccessorType(XmlAccessType.FIELD)
public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@XmlElement()
	private List<Cliente> clientes;
	
	public Empresa() { /* constructor vacio */ }
	
	public List<Cliente> getClientes() {
		if(clientes == null) {
			clientes = new ArrayList<Cliente>();
		}
		return this.clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
