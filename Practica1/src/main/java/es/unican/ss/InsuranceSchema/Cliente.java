package es.unican.ss.InsuranceSchema;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	@XmlAttribute(required= true)
	private String nombre;
	@XmlAttribute(required= true)
	private String email;
	@XmlAttribute(required= true)
	private String DNI;
	@XmlElement(required= true)
	private ArrayList<Seguro> seguros = new ArrayList<Seguro>();
	@XmlElement()
	private ArrayList<Parte> partes = new ArrayList<Parte>();

}
