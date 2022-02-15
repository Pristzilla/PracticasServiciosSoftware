package es.unican.ss.InsuranceSchema;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String email;
	private String DNI;
	private ArrayList<Seguro> seguros = new ArrayList<Seguro>();
	private ArrayList<Parte> partes = new ArrayList<Parte>();

}
