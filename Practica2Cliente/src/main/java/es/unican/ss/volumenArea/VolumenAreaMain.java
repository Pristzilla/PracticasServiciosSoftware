package es.unican.ss.volumenArea;

public class VolumenAreaMain {

	public static void main(String[] args) {

		VolumenArea vaService = new VolumenArea();
		VolumenAreaInterface vaPort = vaService.getSOAPPort();
		try {
			System.out.println(vaPort.area(new Dimensiones(2.0,3.0,4.0)));}
		catch (DatosNoValidosException e) {
			// no entra aqui
			e.printStackTrace();
		}
		try {
			System.out.println(vaPort.area(new Dimensiones(2.0,4,4.0)));}
		catch (DatosNoValidosException e) {
			// debe entrar
			System.out.println("He fallao");
			e.printStackTrace();
		}


	}

}
