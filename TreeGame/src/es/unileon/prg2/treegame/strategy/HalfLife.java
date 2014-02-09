package es.unileon.prg2.treegame.strategy;


import es.unileon.prg2.treegame.helpers.Weapon;
import org.apache.log4j.Logger;

/**
 * Cálculo de la vida a partir de la mitad del poder del arma.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Diez
 * @author Andrea San Ramon
 */
public class HalfLife extends LifeStrategy{
	
	/**
	 * Vida del nodo
	 */
	private int nodeLife;
	
	/**
	 * Log
	 */
	static Logger log = Logger.getLogger(HalfLife.class);
	
	/**
	 * Constructor
	 * @param life Vida del nodo
	 */
	public HalfLife(int life){
		
		nodeLife = life;
		
	}
	
	@Override
	public int calculateLife(int life, Weapon weapon) {
		int lifeResult = Math.max(0, life - weapon.getPower()/2);
		log.info("El nodo queda con vida" + lifeResult);
		weapon.setPower(Math.max(0, weapon.getPower() - life * 2));
		log.info("El poder del arma se reduce a" + weapon.getPower());
		return lifeResult;
	}

	@Override
	public int getPrice() {
		return nodeLife *2;
	}
}
