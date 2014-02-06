package es.unileon.prg2.treegame.composite.shields;

import org.apache.log4j.Logger;

import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.helpers.Weapon;

/**
 * Escudo estático con valor permanente ataque tras ataque. El arma con la que se ataca disminuye su potencia en una cantidad igual
 * a la potencia del escudo.
 *
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 *
 */

public class StaticShield extends Shield {

	/**
	 * Log
	 */
	static Logger log = Logger.getLogger(SpecialShield.class);
	
	private int resistance;
	
	/**
	 * Constructor de la clase.
	 * @param target
	 * @param resistance
	 */
	public StaticShield(Node target, int resistance){
		super(target);
		log.info("StaticShield creado.");
		this.resistance = resistance;
	}
	
	 @Override
	public int hurt(Weapon weapon){
		if (weapon.getPower() >= this.resistance){
			weapon.setPower(weapon.getPower() - this.resistance);
			log.info("Se ha traspasado al escudo, el arma es mayor que la resistencia");
			return super.hurt(weapon);
		} else {
			weapon.setPower(0);
			log.info("No se ha traspasado al escudo, el arma es menor que la resistencia");
			return 0;
		}
	}
}
