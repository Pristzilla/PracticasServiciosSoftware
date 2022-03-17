package es.unican.ss.SSEstimacionParadasTUS;




public class MainEstimacionParadasSecurity {

	public static void main(String[] args) {

		EstimacionParadasTUSService epService = new EstimacionParadasTUSService();
		IEstimacionParadasTUS epPort = epService.getEstimacionParadasTUSPort();

		// Caso Valido
		String nombreParada = "CORREOS";
		int linea = 1;
		
		try {
			EstimacionTUS et = epPort.getEstimacionSiguienteBus(nombreParada, linea);
			
			System.out.println("Estimacion por " + nombreParada + " direccion: " + et.getDireccion());
			System.out.println("E1: " +  et.getEstimacion1());
			System.out.println("E2: " +  et.getEstimacion2());

		}catch (ParadaNoValidaException_Exception e) {
			// no Tiene que entrar aqui
			System.out.println("PARADA NO VALIDA");

		}
		catch (DatosNoDisponiblesException_Exception e) {
			// no debe entrar
			System.out.println("DATOS NO DISPONIBLES");
		}
	}

}
