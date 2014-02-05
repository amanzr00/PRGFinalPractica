package es.unileon.prg2.treegame.strategy;

import es.unileon.prg2.treegame.helpers.Weapon;

public class HalfLife implements LifeStrategy {

	/**
	 * Cálculo de la vida a partir de la mitad del poder del arma.
	 * @author Alberto Manzano
	 * @author Iván Montes
	 * @author Pablo Diez
	 * @author Andrea San Ramon
	 */
	
	
	
	@Override
	public int calculateLife(int life, Weapon weapon) {
		
		if(weapon.getPower()/2 - life == 0){
			life = 0;
			weapon.setPower(0);
		}else if(weapon.getPower()/2 < life){
			life = life - weapon.getPower()/2;
			weapon.setPower(0);
		}else if(weapon.getPower()/2 > life){
			life = life - weapon.getPower()/2;
			if(life < 0){
				life = 0;
			}
			weapon.setPower(weapon.getPower()/2 - life);
			
		
		}
		return life;
	}
	
}
