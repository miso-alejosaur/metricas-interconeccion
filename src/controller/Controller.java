package controller;

import java.util.Scanner;

import controller.opciones.IOpcion;
import controller.opciones.Opcion;
import controller.opciones.OpcionCargarDatos;
import controller.opciones.OpcionComponentesConectados;
import controller.opciones.OpcionEncontrarLandingsInterconexion;
import controller.opciones.OpcionFallasEnConexion;
import controller.opciones.OpcionFinalizar;
import controller.opciones.OpcionRedExpansionMinima;
import controller.opciones.OpcionRutaMinima;
import controller.opciones.OpcionesFactory;
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
		OpcionesFactory factory = new OpcionesFactory();
		boolean fin = false;

		while (!fin) {
			view.printMenu();

			int option = lector.nextInt();

			modelo = factory.getOpcion(option).ejecutarOpcion(view, modelo, lector);

			if (option == 7) {
				fin = true;
				break;
			}
		}

	}
}
