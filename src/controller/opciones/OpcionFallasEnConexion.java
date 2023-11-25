package controller.opciones;

import java.util.Scanner;

import model.data_structures.Country;
import model.data_structures.ILista;
import model.data_structures.PosException;
import model.data_structures.VacioException;
import model.logic.Modelo;
import view.View;

public class OpcionFallasEnConexion extends Opcion {

	@Override
	public Modelo ejecutarOpcion(View view, Modelo modelo, Scanner lector) {
		view.printMessage("--------- \nIngrese el nombre del punto de conexión");
		String landing= lector.next();
		lector.nextLine();
		String res5= this.req5String(landing, modelo);
		view.printMessage(res5);
		
		return modelo;
	}


	public String req5String(String punto, Modelo modelo) {
		ILista afectados = modelo.req5(punto);

		String fragmento = "La cantidad de paises afectados es: " + afectados.size() + "\n Los paises afectados son: ";

		for (int i = 1; i <= afectados.size(); i++) {
			try {
				fragmento += "\n Nombre: " + ((Country) afectados.getElement(i)).getCountryName()
						+ "\n Distancia al landing point: " + ((Country) afectados.getElement(i)).getDistlan();
			} catch (PosException | VacioException e) {
				e.printStackTrace();
			}
		}

		return fragmento;

	}

}
