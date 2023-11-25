package controller.opciones;

import java.io.IOException;
import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class OpcionCargarDatos extends Opcion {

	@Override
	public Modelo ejecutarOpcion(View view, Modelo modelo, Scanner lector) {
		view.printMessage("--------- \nCargar datos");
		modelo = new Modelo(1);
		try {
			modelo.cargar();
		} catch (IOException e) {

			e.printStackTrace();
		}
		view.printModelo(modelo);
		
		return modelo;
	}
}
