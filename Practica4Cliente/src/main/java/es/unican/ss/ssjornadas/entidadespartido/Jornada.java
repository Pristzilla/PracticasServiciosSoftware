package es.unican.ss.ssjornadas.entidadespartido;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="jornada")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Jornada {
	
	private int numJornada;
	private String grupo;
	
	private List<Partido> partidos;
	
	
	public Jornada() {
		this.partidos = new LinkedList<Partido>();
	}
	
	public Jornada(int num, String idGrupo) {
		this.setNumJornada(num);
		this.setGrupo(idGrupo);
		this.partidos = new LinkedList<Partido>();
	}
	

	@XmlAttribute(name="num")
	public int getNumJornada() {
		return numJornada;
	}

	public void setNumJornada(int numJornada) {
		this.numJornada = numJornada;
	}
	@XmlAttribute
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	@XmlElement(name="partido")
	public List<Partido> getPartidos(){
		return this.partidos;
	}
	
	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}
	
	

}
