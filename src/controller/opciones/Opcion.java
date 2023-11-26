package controller.opciones;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Opcion implements IOpcion {
	public Opcion() {

	}

	public Modelo ejecutarOpcion(View view, Modelo modelo, Scanner lector) {
		view.printMessage("--------- \n Opcion Invalida !! \n---------");
		return modelo;
	}
}

