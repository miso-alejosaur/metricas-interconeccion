package controller.opciones;

import java.util.Scanner;

import model.data_structures.ArregloDinamico;
import model.data_structures.ILista;
import model.data_structures.PilaEncadenada;
import model.data_structures.TablaHashSeparteChaining;
import model.data_structures.Vertex;
import model.logic.Modelo;
import utils.OpcionUtils;
import utils.Unificacion;
import view.View;

public class OpcionRedExpansionMinima implements IOpcion {

	@Override
	public Modelo ejecutarOpcion(View view, Modelo modelo, Scanner lector) {
		String res4= this.req4String(modelo);
		view.printMessage(res4);
		
		return modelo;
	}

	private String req4String(Modelo modelo) {
		String fragmento = "";
		ILista lista1 = modelo.valueSet();

		String llave = "";

		int distancia = 0;

		try {
			llave = OpcionUtils.encontrarLlave(lista1, llave);

			ILista lista2 = modelo.mstPrimLazy(llave);

			TablaHashSeparteChaining tabla = new TablaHashSeparteChaining<>(2);
			ILista candidatos = new ArregloDinamico<>(1);

			distancia = OpcionUtils.llenarTabla(distancia, lista2, tabla, candidatos);

			ILista unificado = Unificacion.unificar(candidatos, "Vertice");
			fragmento += " La cantidad de nodos conectada a la red de expansión mínima es: " + unificado.size()
					+ "\n El costo total es de: " + distancia;

			PilaEncadenada caminomax = OpcionUtils.calcularCaminoMax(tabla, unificado);

			fragmento += "\n La rama más larga está dada por lo vértices: ";
			for (int i = 1; i <= caminomax.size(); i++) {
				Vertex pop = (Vertex) caminomax.pop();
				fragmento += "\n Id " + i + " : " + pop.getId();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (fragmento.equals("")) {
			return "No hay ninguna rama";
		} else {
			return fragmento;
		}
	}

}
