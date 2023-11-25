package controller.opciones;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class OpcionRutaMinima extends Opcion {

	@Override
	public void ejecutarOpcion(View view, Modelo modelo, Scanner lector) {
		view.printMessage("--------- \nIngrese el nombre del primer país");
		String pais1= lector.next();
		lector.nextLine();
		
		view.printMessage("--------- \nIngrese el nombre del segundo país");
		String pais2= lector.next();
		lector.nextLine();
		
		String res3= modelo.req3String(pais1, pais2);
		view.printMessage(res3);
	}
}