package es.unileon.prg2.treegame.strategy;

/**
 * Patr�n strategy
 * Interfaz que declara las estrategias del calculo de vida de los nodos.
 * @author Alberto Manzano.
 * @author Ivan Montes.
 * @author Pablo Diez.
 * @author Andrea San Ram�n.
 */

import es.unileon.prg2.treegame.helpers.Weapon;

public interface LifeStrategy {
	
	/**
	 * M�todo que dadas la vida de un nodo y el arma con la que se le ataca, nos devuelve el calculo del da�o de
	 * la vida del nodo
	 * @param life La vida del nodo
	 * @param weapon La potencia del arma con la que se ataca
	 * @return La vida resultante del ataque.
	 */
	public int calculateLife(int life, Weapon weapon);

}
