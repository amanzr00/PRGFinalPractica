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
public class DefaultLife implements LifeStrategy{

	@Override
	public int calculateLife(int life, Weapon weapon) {
		if(life < weapon.getPower()){
			int damage = weapon.getPower() - life;
			weapon.setPower(damage);
			life = 0;
		}else if(life == weapon.getPower()){
			weapon.setPower(0);
			life = 0;
		}else {
			int damage = weapon.getPower();
			weapon.setPower(0);
			life = life - damage;
		}
		return life;
	}

	
	

	
}