package es.unileon.prg2.treegame.composite.shields;

import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.helpers.Weapon;

/**
 * Escudo estático con valor permanente ataque tras ataque. El arma con la que se ataca disminuye su potencia en una cantidad igual
 * a la potencia del escudo.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez.
 */

public class StaticShield extends Shield {

	private int resistance;
	
	public StaticShield(Node target, int resistance){
		super(target);
		this.resistance = resistance;
	}
	
	public int hurt(Weapon weapon){
		if (weapon.getPower() >= this.resistance){
			weapon.setPower(weapon.getPower() - this.resistance);
			
			return super.hurt(weapon);
		} else {
			weapon.setPower(0);
			return 0;
		}
	}
}
