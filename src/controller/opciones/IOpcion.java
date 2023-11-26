package controller.opciones;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public interface IOpcion {
	public Modelo ejecutarOpcion(View view, Modelo modelo, Scanner lector);
}
