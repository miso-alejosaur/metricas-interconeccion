package controller.opciones;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class OpcionFallasEnConexion extends Opcion {

	@Override
	public void ejecutarOpcion(View view, Modelo modelo, Scanner lector) {
		view.printMessage("--------- \nIngrese el nombre del punto de conexión");
		String landing= lector.next();
		lector.nextLine();
		String res5= modelo.req5String(landing);
		view.printMessage(res5);
	}

}
