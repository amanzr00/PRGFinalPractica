package es.unileon.prg2.treegame.strategy;

import org.apache.log4j.Logger;

import es.unileon.prg2.treegame.helpers.Weapon;

/**
 * Clase que implementa el cálculo normal de vida, obteniendo la diferencia de daño entre nodo y arma.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 *
 */
public class DefaultLife extends LifeStrategy{

	/**
	 * Log
	 */
	static Logger log = Logger.getLogger(DefaultLife.class);
	
	@Override
	public int calculateLife(int life, Weapon weapon) {
		int lifeResult = Math.max(0, life - weapon.getPower());
		log.info("El nodo queda con vida" + lifeResult);
		weapon.setPower(Math.max(0, weapon.getPower() - life));
		log.info("El poder del arma se reduce a" + weapon.getPower());
		return lifeResult;
	}

	@Override
	public int getPrice() {
		return 0;
	}
}