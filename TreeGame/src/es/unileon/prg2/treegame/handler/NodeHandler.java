package es.unileon.prg2.treegame.handler;

/**
 * Identificador de los nodos del árbol del juego.
 * @author Alberto Manzano
 * @version 1.0
 */
public class NodeHandler implements Handler{
	/**
	 * Identificador en forma de entero.
	 */
	private int number;
	/**
	 * Contador estático que se incrementa con cada instancia de identificador de nodo.
	 * Genera identificadores que se incrementan en número de uno en uno.
	 */
	private static int staticCounter;
	
	/**
	 * Crea el identificador del nodo de acuerdo con el valor del staticCounter que representa
	 * un entero al que se le añade una unidad. De esta manera los identificadores son siempre crecientes.
	 */
	public NodeHandler() {
		this.number = staticCounter++;
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
