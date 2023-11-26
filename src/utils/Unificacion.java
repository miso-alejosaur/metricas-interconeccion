package utils;

import java.util.Comparator;

import model.data_structures.ArregloDinamico;
import model.data_structures.Country;
import model.data_structures.ILista;
import model.data_structures.ITablaSimbolos;
import model.data_structures.Landing;
import model.data_structures.TablaHashSeparteChaining;
import model.data_structures.Vertex;

public class Unificacion {


	public static ILista unificar(ILista lista, String criterio) {

		ILista lista2 = new ArregloDinamico(1);

		if (criterio.equals("Vertice")) {
			unificarPorVertice(lista, lista2);
		} else {
			unificarPorCountry(lista, lista2);
		}

		return lista2;
	}

	private static void unificarPorCountry(ILista lista, ILista lista2) {
		Comparator<Country> comparador = null;

		Ordenamiento<Country> algsOrdenamientoEventos = new Ordenamiento<Country>();
		;

		comparador = new Country.ComparadorXNombre();

		try {

			if (lista != null) {
				algsOrdenamientoEventos.ordenarMergeSort(lista, comparador, false);
			}

			realizarUnificacion(lista, lista2, comparador);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void unificarPorVertice(ILista lista, ILista lista2) {
		Comparator<Vertex<String, Landing>> comparador = null;

		Ordenamiento<Vertex<String, Landing>> algsOrdenamientoEventos = new Ordenamiento<Vertex<String, Landing>>();
		;

		comparador = new Vertex.ComparadorXKey();

		try {

			if (lista != null) {
				algsOrdenamientoEventos.ordenarMergeSort(lista, comparador, false);

				realizarUnificacion(lista, lista2, comparador);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static <T extends Comparable<T>> void realizarUnificacion(ILista lista, ILista lista2, Comparator<T> comparador)
			throws Exception {
		for (int i = 1; i <= lista.size(); i++) {
			T actual = (T) lista.getElement(i);
			T siguiente = (T) lista.getElement(i + 1);

			if (siguiente != null) {
				if (comparador.compare(actual, siguiente) != 0) {
					lista2.insertElement(actual, lista2.size() + 1);
				}
			} else {
				T anterior = (T) lista.getElement(i - 1);

				if (anterior != null) {
					if (comparador.compare(anterior, actual) != 0) {
						lista2.insertElement(actual, lista2.size() + 1);
					}
				} else {
					lista2.insertElement(actual, lista2.size() + 1);
				}
			}
		}
	}

	public static ITablaSimbolos unificarHash(ILista lista) {

		Comparator<Vertex<String, Landing>> comparador = null;

		Ordenamiento<Vertex<String, Landing>> algsOrdenamientoEventos = new Ordenamiento<Vertex<String, Landing>>();
		;

		comparador = new Vertex.ComparadorXKey();

		ITablaSimbolos tabla = new TablaHashSeparteChaining<>(2);

		try {

			if (lista != null) {
				algsOrdenamientoEventos.ordenarMergeSort(lista, comparador, false);

				realizarUnificacionPorHash(lista, comparador, tabla);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tabla;
	}

	private static void realizarUnificacionPorHash(ILista lista, Comparator<Vertex<String, Landing>> comparador,
			ITablaSimbolos tabla) throws Exception {
		for (int i = 1; i <= lista.size(); i++) {
			Vertex actual = (Vertex) lista.getElement(i);
			Vertex siguiente = (Vertex) lista.getElement(i + 1);

			if (siguiente != null) {
				if (comparador.compare(actual, siguiente) != 0) {
					tabla.put(actual.getId(), actual);
				}
			} else {
				Vertex anterior = (Vertex) lista.getElement(i - 1);

				if (anterior != null) {
					if (comparador.compare(anterior, actual) != 0) {
						tabla.put(actual.getId(), actual);
					}
				} else {
					tabla.put(actual.getId(), actual);
				}
			}

		}
	}
}
