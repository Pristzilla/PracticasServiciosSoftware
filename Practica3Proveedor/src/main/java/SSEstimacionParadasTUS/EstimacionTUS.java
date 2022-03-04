package SSEstimacionParadasTUS;

public class EstimacionTUS {

	private int estimacion1;
	private int estimacion2;
	private String direccion;


	public EstimacionTUS() {}
	public EstimacionTUS(int estimacion1, int estimacion2, String direccion) {
		this.estimacion1 = estimacion1;
		this.estimacion2 = estimacion2;
		this.direccion = direccion;
	}
	public int getEstimacion1() {
		return estimacion1;
	}
	public void setEstimacion1(int estimacion1) {
		this.estimacion1 = estimacion1;
	}
	public int getEstimacion2() {
		return estimacion2;
	}
	public void setEstimacion2(int estimacion2) {
		this.estimacion2 = estimacion2;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
