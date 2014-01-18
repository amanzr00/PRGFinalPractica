package es.unileon.prg2.treegame.strategy;

/**
 * Interfaz que declara las estrategias del calculo de vida de los nodos.
 * 
 */

import es.unileon.prg2.treegame.helpers.Weapon;

public interface LifeStrategy {
	
	public int calculateLife(int life, Weapon weapon);

}
