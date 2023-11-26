package controller.opciones;

import java.util.Scanner;

import model.data_structures.ILista;
import model.data_structures.Landing;
import model.data_structures.PosException;
import model.data_structures.VacioException;
import model.data_structures.Vertex;
import model.logic.Modelo;
import view.View;

public class OpcionEncontrarLandingsInterconexion implements IOpcion {

	@Override
	public Modelo ejecutarOpcion(View view, Modelo modelo, Scanner lector) {
		String res2 = req2String(modelo);
		view.printMessage(res2);
		
		return modelo;
	}

	private String req2String(Modelo modelo) {
		String fragmento = "";

		ILista lista = modelo.valueSet();

		int cantidad = 0;

		int contador = 0;

		for (int i = 1; i <= lista.size(); i++) {
			try {
				if (((ILista) lista.getElement(i)).size() > 1 && contador <= 10) {
					Landing landing = (Landing) ((Vertex) ((ILista) lista.getElement(i)).getElement(1)).getInfo();

					for (int j = 1; j <= ((ILista) lista.getElement(i)).size(); j++) {
						cantidad += ((Vertex) ((ILista) lista.getElement(i)).getElement(j)).edges().size();
					}

					fragmento += landing.toString() + "\n Cantidad: " + cantidad; 

					contador++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return fragmento;

	}
}
