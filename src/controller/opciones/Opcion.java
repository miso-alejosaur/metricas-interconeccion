package controller.opciones;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Opcion {
	public Opcion() {

	}

	public void ejecutarOpcion(View view, Modelo modelo, Scanner lector) {
		view.printMessage("--------- \n Opcion Invalida !! \n---------");
	}
}

