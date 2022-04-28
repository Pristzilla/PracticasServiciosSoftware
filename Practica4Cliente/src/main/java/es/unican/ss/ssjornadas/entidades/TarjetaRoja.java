package es.unican.ss.ssjornadas.entidades;

import javax.xml.bind.annotation.XmlAttribute;

public class TarjetaRoja {
	
	private int dorsal;
	private int minuto;
	
	public TarjetaRoja() {}
	
	@XmlAttribute
	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	@XmlAttribute
	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	@Override
	public String toString() {
		return "Dorsal: "+ this.dorsal + "\tMinuto: " +this.minuto +"\n";
	}

}
