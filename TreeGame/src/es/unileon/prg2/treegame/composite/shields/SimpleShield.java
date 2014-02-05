package es.unileon.prg2.treegame.composite.shields;

import org.apache.log4j.Logger;

import es.unileon.prg2.treegame.composite.Articulation;
import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.helpers.Weapon;

/**
 * Escudo simple que protege con un valod de da�o concreto.
 * @author Alberto Manzano
 * @author Iv�n Montes
 * @author Pablo Diez
 * @author Andrea San Ramon
 * @version 1.0
 */
public class SimpleShield extends Shield {
	
	/**
	 * Log
	 */
	static Logger log = Logger.getLogger(SimpleShield.class);
	/**
	 * Resistencia del escudo.
	 */
	private int resistance;
	
	/**
	 * Constructor del escudo simple.
	 * @param target El elemento al que protege el escudo.
	 */
	public SimpleShield(Node target, int resistance) {
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
