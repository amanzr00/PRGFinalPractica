package es.unileon.prg2.treegame.composite.shields;

import org.apache.log4j.Logger;

import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.exceptions.InvalidResistanceValueException;
import es.unileon.prg2.treegame.helpers.Weapon;

/**
 * Escudo especial que soporta un determinado n�mero de ataques y resta la mitad del
 * poder del arma.
 * @author Alberto Manzano.
 * @author Iv�n Montes.
 * @author Pablo Diez.
 * @author Andrea San Ramon.
 * @version 1.0
 */
public class SpecialShield extends Shield {

	/**
	 * Log
	 */
	static Logger log = Logger.getLogger(SpecialShield.class);
	
	/**
	 * El n�mero de ataques soportados por el escudo.
	 */
	private int numAttacks;
	
	/**
	 * Escudo especial que permite bloquear la mitad del da�o en funci�n del n�mero de ataques 
	 * soportados.
	 * @param target El nodo al que protege.
	 * @param numAttacks El n�mero de ataques soportados por el escudo.
	 */
	public SpecialShield(Node target, int numAttacks) {
		super(target);
		if(numAttacks <= 0) throw new InvalidResistanceValueException("La resistencia de ataques ha de ser mayor que 0");
		this.numAttacks = numAttacks;
		log.info("SpecialShield creado");
	}
	
	@Override
	public int hurt(Weapon weapon) {
		if(numAttacks > 0){
			numAttacks--;
			weapon.setPower(weapon.getPower()/2);
			log.info("Ataques restantes disminuidos");
		}
		log.info("Se ha destruido el escudo se atacara al nodo");
		return super.hurt(weapon);
	}

	@Override
	public int getPrice() {
		return this.numAttacks *10;
	}
}
