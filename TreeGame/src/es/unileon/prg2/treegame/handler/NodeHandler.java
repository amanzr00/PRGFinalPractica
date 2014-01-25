package es.unileon.prg2.treegame.handler;

/**
 * Identificador de los nodos del árbol del juego.
 * @author Alberto Manzano.
 * @author Iván Montes.
 * @author Pablo Díez.
 * @version 1.0
 */
public class NodeHandler implements Handler {
	
	/**
	 * Identificador en forma de entero.
	 */
	private int number;
	
	/**
	 * Crea el identificador del nodo de acuerdo con el valor pasado.
	 * @param id el numero el id pasado.
	 */
	public NodeHandler(int id) {
		this.number = id;
	}

	@Override
	public int compareTo(Handler another) {
		return this.toString().compareTo(another.toString());
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
