package es.unileon.prg2.treegame.composite.shields;

import es.unileon.prg2.treegame.composite.Target;
import es.unileon.prg2.treegame.helpers.Weapon;

/**
 * Escudo especial que soporta un determinado número de ataques y resta la mitad del
 * poder del arma.
 * @author Alberto Manzano.
 * @version 1.0
 */
public class SpecialShield extends Shield {

	/**
	 * El número de ataques soportados por el escudo.
	 */
	private int numAttacks;
	
	/**
	 * Escudo especial que permite bloquear la mitad del daño en función del número de ataques 
	 * soportados.
	 * @param target El nodo al que protege.
	 * @param numAttacks El número de ataques soportados por el escudo.
	 */
	public SpecialShield(Target target, int numAttacks) {
		super(target);
		this.numAttacks = numAttacks;
	}
	
	@Override
	public int hurt(Weapon weapon) {
		if(numAttacks > 0){
			numAttacks--;
			weapon.setPower(weapon.getPower()/2);
		}
		return super.hurt(weapon);
	}
}
