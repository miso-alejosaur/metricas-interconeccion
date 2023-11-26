package controller.opciones;

public class OpcionesFactory {
	public IOpcion getOpcion(int option) {
		switch (option) {
		case 1:
			return new OpcionCargarDatos();

		case 2:
			return new OpcionComponentesConectados();

		case 3:
			return new OpcionEncontrarLandingsInterconexion();

		case 4:
			return new OpcionRutaMinima();

		case 5:
			return new OpcionRedExpansionMinima();

		case 6:
			return new OpcionFallasEnConexion();

		case 7:
			return new OpcionFinalizar();

		default:
			return new Opcion();
		}
	}
}
