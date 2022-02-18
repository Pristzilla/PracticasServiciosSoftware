package es.unican.ss.InsuranceSchema;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class TodoRiesgoFranquicia extends Seguro {

	private static final long serialVersionUID = 1L;
	private static final double PRECIO_BASE = 600.0;
	private static final double PRECIO_FRANQUICIA = 70.0;


}
