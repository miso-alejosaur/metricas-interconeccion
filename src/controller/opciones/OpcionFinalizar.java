package controller.opciones;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class OpcionFinalizar extends Opcion {

	@Override
	public void ejecutarOpcion(View view, Modelo modelo, Scanner lector) {
		view.printMessage("--------- \n Hasta pronto !! \n---------");
		lector.close();
	}

}
