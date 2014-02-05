package es.unileon.prg2.treegame.handler;

/**
 * Patr�n handler para manejar identificadores del �rbol de juego.
 * @author Alberto Manzano
 * @author Iv�n Montes
 * @author Pablo D�ez
 * @author Andrea San Ramon
 * @version 1.0
 */
public interface Handler {
	
	/**
	 * Permite obtener la representaci�n del identificador en forma de String.
	 * @return el identificador en forma de String.
	 */
	String toString();
	
	/**
	 * Compara con otro identificador. 0 si son iguales, -1 o + 1 si son lexicogr�ficamente distintos.
	 * @param id el identificador a comparar con el actual.
	 * @return 0 si son iguales, -1 o + 1 si son lexicogr�ficamente distintos.
	 */
	int compareTo (Handler id);
}