package controller;

import java.util.Scanner;

import controller.opciones.Opcion;
import controller.opciones.OpcionCargarDatos;
import controller.opciones.OpcionComponentesConectados;
import controller.opciones.OpcionEncontrarLandingsInterconexion;
import controller.opciones.OpcionFallasEnConexion;
import controller.opciones.OpcionFinalizar;
import controller.opciones.OpcionRedExpansionMinima;
import controller.opciones.OpcionRutaMinima;
import model.logic.Modelo;
import view.View;

public class Controller<T> {

	/* Instancia del Modelo */
	private Modelo modelo;

	/* Instancia de la Vista */
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * 
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller() {
		view = new View();
	}

	public void run() {
		Scanner lector = new Scanner(System.in).useDelimiter("\r\n");
		boolean fin = false;

		while (!fin) {
			view.printMenu();

			int option = lector.nextInt();

			modelo = getOpcion(option).ejecutarOpcion(view, modelo, lector);

			if (option == 7) {
				fin = true;
				break;
			}
		}

	}

	private Opcion getOpcion(int option) {
		switch (option) {
		case 1:
			return new OpcionCargarDatos();

		case 2:
			return new OpcionComponentesConectados();

		case 3:
			return new OpcionEncontrarLandingsInterconexion();

		case 4:
			return new OpcionRutaMinima();

		case 5:
			return new OpcionRedExpansionMinima();

		case 6:
			return new OpcionFallasEnConexion();

		case 7:
			return new OpcionFinalizar();

		default:
			return new Opcion();
		}
	}
}
