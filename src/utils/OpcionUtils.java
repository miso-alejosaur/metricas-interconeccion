package utils;

import model.data_structures.Edge;
import model.data_structures.ILista;
import model.data_structures.ITablaSimbolos;
import model.data_structures.PilaEncadenada;
import model.data_structures.Vertex;

public final class OpcionUtils {

	public static int llenarTabla(int distancia, ILista lista2, ITablaSimbolos tabla, ILista candidatos)
			throws Exception {
		for (int i = 1; i <= lista2.size(); i++) {
			Edge arco = ((Edge) lista2.getElement(i));
			distancia += arco.getWeight();

			candidatos.insertElement(arco.getSource(), candidatos.size() + 1);

			candidatos.insertElement(arco.getDestination(), candidatos.size() + 1);

			tabla.put(arco.getDestination().getId(), arco.getSource());
		}
		return distancia;
	}

	public static PilaEncadenada calcularCaminoMax(ITablaSimbolos tabla, ILista unificado)
			throws Exception {
		int maximo = 0;
		int contador = 0;
		PilaEncadenada caminomax = new PilaEncadenada();
		for (int i = 1; i <= unificado.size(); i++) {

			PilaEncadenada path = new PilaEncadenada();
			String idBusqueda = (String) ((Vertex) unificado.getElement(i)).getId();
			Vertex actual;

			while ((actual = (Vertex) tabla.get(idBusqueda)) != null && actual.getInfo() != null) {
				path.push(actual);
				idBusqueda = (String) ((Vertex) actual).getId();
				contador++;
			}

			if (contador > maximo) {
				caminomax = path;
			}
		}
		return caminomax;
	}

	public static String encontrarLlave(ILista lista1, String llave) throws Exception {
		int max = 0;
		for (int i = 1; i <= lista1.size(); i++) {
			if (((ILista) lista1.getElement(i)).size() > max) {
				max = ((ILista) lista1.getElement(i)).size();
				llave = (String) ((Vertex) ((ILista) lista1.getElement(i)).getElement(1)).getId();
			}
		}
		return llave;
	}


	public static float distancia(double lon1, double lat1, double lon2, double lat2) {

		double earthRadius = 6371; // km

		lat1 = Math.toRadians(lat1);
		lon1 = Math.toRadians(lon1);
		lat2 = Math.toRadians(lat2);
		lon2 = Math.toRadians(lon2);

		double dlon = (lon2 - lon1);
		double dlat = (lat2 - lat1);

		double sinlat = Math.sin(dlat / 2);
		double sinlon = Math.sin(dlon / 2);

		double a = (sinlat * sinlat) + Math.cos(lat1) * Math.cos(lat2) * (sinlon * sinlon);
		double c = 2 * Math.asin(Math.min(1.0, Math.sqrt(a)));

		double distance = earthRadius * c;

		return (int) distance;
	}
}
