package controller.opciones;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class OpcionComponentesConectados implements IOpcion {

	@Override
	public Modelo ejecutarOpcion(View view, Modelo modelo, Scanner lector) {
		view.printMessage("--------- \nIngrese el nombre del primer punto de conexión");
		String punto1 = lector.next();
		lector.nextLine();

		view.printMessage("--------- \nIngrese el nombre del segundo punto de conexión");
		String punto2 = lector.next();
		lector.nextLine();

		String res1=modelo.req1String(punto1, punto2);
		view.printMessage(res1);

		return modelo;
	}
}
