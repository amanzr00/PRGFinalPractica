package es.unileon.prg2.treegame.strategy;

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

	@Override
	public int calculateLife(int life, Weapon weapon) {
		int lifeResult = Math.max(0, life - weapon.getPower());
		weapon.setPower(Math.max(0, weapon.getPower() - life));
		return lifeResult;
	}

	@Override
	public int getPrice() {
		return 0;
	}
}