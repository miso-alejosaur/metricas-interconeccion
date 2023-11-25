package controller.opciones;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class OpcionEncontrarLandingsInterconexion extends Opcion {

	@Override
	public void ejecutarOpcion(View view, Modelo modelo, Scanner lector) {
		String res2 = modelo.req2String();
		view.printMessage(res2);
	}
}
