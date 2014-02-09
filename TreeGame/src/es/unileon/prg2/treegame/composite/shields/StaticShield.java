package es.unileon.prg2.treegame.composite.shields;

import org.apache.log4j.Logger;

import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.exceptions.InvalidResistanceValueException;
import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

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
	static Logger log = Logger.getLogger(StaticShield.class);
	
	private int resistance;
	
	/**
	 * Constructor de la clase.
	 * @param target
	 * @param resistance
	 */
	public StaticShield(Node target, int resistance){
		super(target);
		if (resistance <= 0){
			log.error("Se ha introducido una resistencia negativa");
			throw new InvalidResistanceValueException("La resistencia ha de ser mayor de 0");
		}
		this.resistance = resistance;
		log.info("StaticShield creado en el nodo" + super.getId().toString() + "con resistencia" + this.resistance);
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

	@Override
	public int getPrice() {
		return this.resistance * 10;
	}

	@Override
	public LifeStrategy getLifeStrategy() {
		
		return null;
	}
}
