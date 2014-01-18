package es.unileon.prg2.treegame.composite.shields;

import es.unileon.prg2.treegame.composite.Target;
import es.unileon.prg2.treegame.helpers.Weapon;

/**
 * Escudo simple que protege con un valod de daño concreto.
 * @author Alberto Manzano
 * @version 1.0
 */
public class SimpleShield extends Shield {
	
	/**
	 * Resistencia del escudo.
	 */
	private int resistance;
	
	/**
	 * Constructor del escudo simple.
	 * @param target El elemento al que protege el escudo.
	 */
	public SimpleShield(Target target, int resistance) {
		super(target);
		this.resistance = resistance;
	}

	@Override
	public int hurt(Weapon weapon) {
		if (weapon.getPower() >= this.resistance){
			weapon.setPower(weapon.getPower() - this.resistance);
			this.resistance = 0;
			return super.hurt(weapon);
		} else {
			this.resistance = this.resistance - weapon.getPower();
			weapon.setPower(0);
			return 0;
		}
	}
}
