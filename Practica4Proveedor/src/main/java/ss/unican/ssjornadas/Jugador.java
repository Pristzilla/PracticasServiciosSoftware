package ss.unican.ssjornadas;

public class Jugador implements Comparable<Jugador>{

	private int dorsal;
	private int goles;
	private String nombre;
	private int tAmarillas;
	private int tRojas;
	
	public Jugador() {}
	
	public Jugador(int dorsal, String nombre) {
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.goles = 0;
		this.tAmarillas = 0;
		this.tRojas = 0;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int gettAmarillas() {
		return tAmarillas;
	}

	public void settAmarillas(int tAmarillas) {
		this.tAmarillas = tAmarillas;
	}

	public int gettRojas() {
		return tRojas;
	}

	public void settRojas(int tRojas) {
		this.tRojas = tRojas;
	}
	
	@Override
	public boolean equals(Object o) {

		// If the object is compared with itself then return true 
		if (o == this) {
			return true;
		}


		if (!(o instanceof Jugador)) {
			return false;
		}

		Jugador j = (Jugador) o;


		return this.dorsal == j.dorsal;     
	}


	public int compareTo(Jugador j){
		if (this.goles > j.goles) {

			// if current object is greater,then return 1
			return 1;
		}
		else if (this.goles < j.goles) {

			// if current object is greater,then return -1
			return -1;
		}
		else {

			// if current object is equal to o,then return 0
			return 0;
		}
	}
}
