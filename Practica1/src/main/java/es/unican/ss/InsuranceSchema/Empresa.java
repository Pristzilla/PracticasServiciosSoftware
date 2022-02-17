package es.unican.ss.InsuranceSchema;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="empresa")
@XmlType(name="Empresa")
@XmlAccessorType(XmlAccessType.FIELD)
public class Empresa implements Serializable{
	
	// TODO: falta @XmlSchema
	
	private static final long serialVersionUID = 1L;
	@XmlElement()
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

}
