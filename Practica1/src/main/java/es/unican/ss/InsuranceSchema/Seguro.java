package es.unican.ss.InsuranceSchema;

import java.io.Serializable;

public abstract class Seguro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private double precio;
	private Vehiculo vehiculoAsegurado;

}
