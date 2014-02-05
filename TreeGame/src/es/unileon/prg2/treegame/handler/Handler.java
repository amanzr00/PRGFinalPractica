package es.unileon.prg2.treegame.handler;

/**
 * Patrón handler para manejar identificadores del árbol de juego.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */
public interface Handler {
	
	/**
	 * Permite obtener la representación del identificador en forma de String.
	 * @return el identificador en forma de String.
	 */
	String toString();
	
	/**
	 * Compara con otro identificador. 0 si son iguales, -1 o + 1 si son lexicográficamente distintos.
	 * @param id el identificador a comparar con el actual.
	 * @return 0 si son iguales, -1 o + 1 si son lexicográficamente distintos.
	 */
	int compareTo (Handler id);
}