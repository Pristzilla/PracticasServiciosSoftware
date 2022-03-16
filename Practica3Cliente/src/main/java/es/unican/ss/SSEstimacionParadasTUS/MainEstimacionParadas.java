package es.unican.ss.ssestimacionparadastus;



public class MainEstimacionParadas {

	public static void main(String[] args) {

		EstimacionParadasTUSService epService = new EstimacionParadasTUSService();
		IEstimacionParadasTUS epPort = epService.getEstimacionParadasTUSPort();

		// Caso Valido
		String nombreParada = "AVENIDA CANTABRIA 43";
		int linea = 61;
		
		try {
			EstimacionTUS et = epPort.getEstimacionSiguienteBus(nombreParada, linea);
			
			System.out.println("Estimacion por " + nombreParada + " direccion: " + et.getDireccion());
			System.out.println("E1: " +  et.getEstimacion1());
			System.out.println("E2: " +  et.getEstimacion2());

		}catch (ParadaNoValidaException_Exception e) {
			// no entra aqui
			System.out.println("He fallao PARADA NO VALIDA");
			e.printStackTrace();

		}
		catch (DatosNoDisponiblesException_Exception e) {
			// no debe entrar
			System.out.println("He fallao DATOS NO DISPONIBLES");
		}

	}

}
