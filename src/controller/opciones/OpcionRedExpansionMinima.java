package controller.opciones;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class OpcionRedExpansionMinima extends Opcion {

	@Override
	public Modelo ejecutarOpcion(View view, Modelo modelo, Scanner lector) {
		String res4= modelo.req4String();
		view.printMessage(res4);
		
		return modelo;
	}

}
