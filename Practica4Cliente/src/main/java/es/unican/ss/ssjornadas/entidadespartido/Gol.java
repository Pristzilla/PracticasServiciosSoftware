package es.unican.ss.ssjornadas.entidadespartido;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class Gol {
	
	private int dorsal;
	private int minuto;
	
	public Gol() {}

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
