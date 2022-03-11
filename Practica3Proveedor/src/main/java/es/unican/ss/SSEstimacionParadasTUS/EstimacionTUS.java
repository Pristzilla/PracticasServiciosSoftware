package es.unican.ss.SSEstimacionParadasTUS;

public class EstimacionTUS {

	private String estimacion1;
	private String estimacion2;
	private String direccion;


	public EstimacionTUS() {}
	public EstimacionTUS(String estimacion1, String estimacion2, String direccion) {
		this.estimacion1 = estimacion1;
		this.estimacion2 = estimacion2;
		this.direccion = direccion;
	}
	public EstimacionTUS(int estimacion1, int estimacion2, String direccion) {
		this.estimacion1 = Integer.toString(estimacion1);
		this.estimacion2 = Integer.toString(estimacion2);
		this.direccion = direccion;
	}
	public String getEstimacion1() {
		return estimacion1;
	}
	public void setEstimacion1(String estimacion1) {
		this.estimacion1 = estimacion1;
	}
	public String getEstimacion2() {
		return estimacion2;
	}
	public void setEstimacion2(String estimacion2) {
		this.estimacion2 = estimacion2;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
