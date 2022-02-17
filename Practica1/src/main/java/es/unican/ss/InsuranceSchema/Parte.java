package es.unican.ss.InsuranceSchema;

import java.util.Date;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Parte {
	
	@XmlElement(required= true)
	private Seguro seguro;
	@XmlAttribute(required= true)
	private double importe;
	@XmlAttribute(required= true)
	private Date fecha;
}
