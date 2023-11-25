package controller.opciones;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class OpcionFinalizar extends Opcion {

	@Override
	public Modelo ejecutarOpcion(View view, Modelo modelo, Scanner lector) {
		view.printMessage("--------- \n Hasta pronto !! \n---------");
		lector.close();
		
		return modelo;
	}

}
