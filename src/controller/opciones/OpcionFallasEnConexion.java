package controller.opciones;

import java.util.Comparator;
import java.util.Scanner;

import model.data_structures.Country;
import model.data_structures.Edge;
import model.data_structures.ILista;
import model.data_structures.Landing;
import model.data_structures.Vertex;
import model.data_structures.Country.ComparadorXKm;
import model.logic.Modelo;
import utils.OpcionUtils;
import utils.Ordenamiento;
import utils.Unificacion;
import view.View;

public class OpcionFallasEnConexion implements IOpcion {

	@Override
	public Modelo ejecutarOpcion(View view, Modelo modelo, Scanner lector) {
		view.printMessage("--------- \nIngrese el nombre del punto de conexión");
		String landing= lector.next();
		lector.nextLine();
		String res5= this.req5String(landing, modelo);
		view.printMessage(res5);
		
		return modelo;
	}


	private String req5String(String punto, Modelo modelo) {		

		ILista lista = modelo.getListaDePunto(punto);
		ILista countries = modelo.getCountriesDeLista(lista);
		
		calcularDistancias(lista, countries, modelo);

		ILista afectados = Unificacion.unificar(countries, "Country");

		Comparator<Country> comparador = new ComparadorXKm();;

		Ordenamiento<Country> algsOrdenamientoEventos = new Ordenamiento<Country>();

		try {

			if (lista != null) {
				algsOrdenamientoEventos.ordenarMergeSort(afectados, comparador, true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		

		String fragmento = "La cantidad de paises afectados es: " + afectados.size() + "\n Los paises afectados son: ";

		for (int i = 1; i <= afectados.size(); i++) {
			try {
				fragmento += "\n Nombre: " + ((Country) afectados.getElement(i)).getCountryName()
						+ "\n Distancia al landing point: " + ((Country) afectados.getElement(i)).getDistlan();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return fragmento;

	}

	private void calcularDistancias(ILista lista, ILista countries, Modelo modelo) {
		for (int i = 1; i <= lista.size(); i++) {
			try {
				Vertex vertice = (Vertex) lista.getElement(i);
				ILista arcos = vertice.edges();

				for (int j = 1; j <= arcos.size(); j++) {
					Vertex vertice2 = ((Edge) arcos.getElement(j)).getDestination();

					Country pais = null;
					if (vertice2.getInfo().getClass().getName().equals("model.data_structures.Landing")) {
						Landing landing = (Landing) vertice2.getInfo();
						pais = modelo.getPais(landing.getPais());
						countries.insertElement(pais, countries.size() + 1);

						float distancia = OpcionUtils.distancia(pais.getLongitude(), pais.getLatitude(), landing.getLongitude(),
								landing.getLatitude());

						pais.setDistlan(distancia);
					} else {
						pais = (Country) vertice2.getInfo();
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
