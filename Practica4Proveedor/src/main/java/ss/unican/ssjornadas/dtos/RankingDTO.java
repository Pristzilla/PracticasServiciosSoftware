package ss.unican.ssjornadas.dtos;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ss.unican.ssjornadas.entidades.Jugador;

@XmlRootElement(name="ranking")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class RankingDTO {
	private List<JugadorDTO> jugadoresDTO;
	
	public RankingDTO() {};
	public RankingDTO (List<Jugador> rankingJugadores) {
		jugadoresDTO = new LinkedList<JugadorDTO>();
		for(Jugador j: rankingJugadores) {
			JugadorDTO jdto = new JugadorDTO(j);
			jugadoresDTO.add(jdto);
		}
	}
	@XmlElement(name="jugador")
	public List<JugadorDTO> getJugadoresDTO() {
		return jugadoresDTO;
	}
	public void setJugadoresDTO(List<JugadorDTO> jugadoresDTO) {
		this.jugadoresDTO = jugadoresDTO;
	}
	
	
}
