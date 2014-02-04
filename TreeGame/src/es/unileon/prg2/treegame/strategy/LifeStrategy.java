package es.unileon.prg2.treegame.strategy;

/**
 * Patrón strategy
 * Interfaz que declara las estrategias del calculo de vida de los nodos.
 * @author Alberto Manzano.
 * @author Ivan Montes.
 * @author Pablo Diez.
 * @author Andrea San Ramón.
 */

import es.unileon.prg2.treegame.helpers.Weapon;

public interface LifeStrategy {
	
	/**
	 * Método que dadas la vida de un nodo y el arma con la que se le ataca, nos devuelve el calculo del daño de
	 * la vida del nodo
	 * @param life La vida del nodo
	 * @param weapon La potencia del arma con la que se ataca
	 * @return La vida resultante del ataque.
	 */
	public int calculateLife(int life, Weapon weapon);

}
