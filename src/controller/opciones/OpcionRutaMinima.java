package controller.opciones;

import java.util.Scanner;

import model.data_structures.Country;
import model.data_structures.Edge;
import model.data_structures.Landing;
import model.data_structures.PilaEncadenada;
import model.logic.Modelo;
import utils.OpcionUtils;
import view.View;

public class OpcionRutaMinima implements IOpcion {

	@Override
	public Modelo ejecutarOpcion(View view, Modelo modelo, Scanner lector) {
		view.printMessage("--------- \nIngrese el nombre del primer país");
		String pais1= lector.next();
		lector.nextLine();
		
		view.printMessage("--------- \nIngrese el nombre del segundo país");
		String pais2= lector.next();
		lector.nextLine();
		
		String res3= req3String(pais1, pais2, modelo);
		view.printMessage(res3);
		
		return modelo;
	}
	

	private String req3String(String pais1, String pais2, Modelo modelo) {
		
		PilaEncadenada pila = modelo.req3(pais1, pais2);

		float distancia = 0;

		String fragmento = "Ruta: ";

		float disttotal = 0;

		double longorigen = 0;
		double longdestino = 0;
		double latorigen = 0;
		double latdestino = 0;
		String origennombre = "";
		String destinonombre = "";

		while (!pila.isEmpty()) {
			Edge arco = ((Edge) pila.pop());

			if (arco.getSourceVertexClassName().equals("model.data_structures.Landing")) {
				longorigen = ((Landing) arco.getSource().getInfo()).getLongitude();
				latorigen = ((Landing) arco.getSource().getInfo()).getLongitude();
				origennombre = ((Landing) arco.getSource().getInfo()).getLandingId();
			}
			if (arco.getSourceVertexClassName().equals("model.data_structures.Country")) {
				longorigen = ((Country) arco.getSource().getInfo()).getLongitude();
				latorigen = ((Country) arco.getSource().getInfo()).getLongitude();
				origennombre = ((Country) arco.getSource().getInfo()).getCapitalName();
			}
			if (arco.getDestiationVertexClassName().equals("model.data_structures.Landing")) {
				latdestino = ((Landing) arco.getDestination().getInfo()).getLatitude();
				longdestino = ((Landing) arco.getDestination().getInfo()).getLatitude();
				destinonombre = ((Landing) arco.getDestination().getInfo()).getLandingId();
			}
			if (arco.getDestiationVertexClassName().equals("model.data_structures.Country")) {
				longdestino = ((Country) arco.getDestination().getInfo()).getLatitude();
				latdestino = ((Country) arco.getDestination().getInfo()).getLatitude();
				destinonombre = ((Country) arco.getDestination().getInfo()).getCapitalName();
			}

			distancia = OpcionUtils.distancia(longdestino, latdestino, longorigen, latorigen);
			fragmento += "\n \n Origen: " + origennombre + "  Destino: " + destinonombre + "  Distancia: " + distancia;
			disttotal += distancia;

		}

		fragmento += "\n Distancia total: " + disttotal;

		return fragmento;

	}
}