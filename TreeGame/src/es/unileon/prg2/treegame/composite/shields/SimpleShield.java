package es.unileon.prg2.treegame.composite.shields;

import org.apache.log4j.Logger;
import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.exceptions.InvalidResistanceValueException;
import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

/**
 * Escudo simple que protege con un valod de daño concreto.
 * @author Alberto Manzano
 * @author Iván Montes
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
		if(resistance <= 0){
			log.error("Valor negativo introducido en la resistencia");
			throw new InvalidResistanceValueException("La resistencia ha de ser mayor de 0");
		}
			
		this.resistance = resistance;
		log.info("SimpleShield creado en el nodo" + super.getId().toString() + "con resistencia" + this.resistance);
	}

	@Override
	public int hurt(Weapon weapon) {
		if (weapon.getPower() >= this.resistance){
			weapon.setPower(weapon.getPower() - this.resistance);
			this.resistance = 0;
			log.info("Se ha atacado con potencia"+ weapon.getPower() + "que es mayor o igual que la resistencia");
			return super.hurt(weapon);
		} else {
			this.resistance = this.resistance - weapon.getPower();
			weapon.setPower(0);
			log.info("Se ha atacado con potencia" + weapon.getPower() + "que es menor que la resistencia");
			return 0;
		}
	}

	@Override
	public int getPrice() {
		return this.resistance;
	}

	@Override
	public LifeStrategy getLifeStrategy() {
		
		return null;
	}
}
