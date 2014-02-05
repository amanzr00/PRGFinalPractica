package es.unileon.prg2.treegame.strategy;
import es.unileon.prg2.treegame.helpers.Weapon;

/**
 * Clase que implementa el c�lculo normal de vida, obteniendo la diferencia de da�o entre nodo y arma.
 * @author Alberto Manzano
 * @author Iv�n Montes
 * @author Pablo D�ez
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