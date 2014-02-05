package es.unileon.prg2.treegame.handler;

import org.apache.log4j.Logger;

import es.unileon.prg2.treegame.composite.Articulation;

/**
 * Identificador de los nodos del árbol del juego.
 * @author Alberto Manzano.
 * @author Iván Montes.
 * @author Pablo Díez.
 * @version 1.0
 */
public class NodeHandler implements Handler {
	
	/**
	 * Log
	 */
	static Logger log = Logger.getLogger(NodeHandler.class);
	/**
	 * Identificador en forma de entero.
	 */
	private int number;
	
	/**
	 * Crea el identificador del nodo de acuerdo con el valor pasado.
	 * @param id el numero el id pasado.
	 */
	public NodeHandler(int id) {
		log.info("Identificador creado");
		this.number = id;
	}

	@Override
	public int compareTo(Handler another) {
		log.info("Identificadores comparados");
		return this.toString().compareTo(another.toString());
	}

	@Override
	public String toString() {
		log.info("Identificador pasado a string");
		return Integer.toString(number);
	}
}
