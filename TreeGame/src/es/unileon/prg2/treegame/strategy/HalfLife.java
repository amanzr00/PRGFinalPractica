package es.unileon.prg2.treegame.strategy;


import es.unileon.prg2.treegame.helpers.Weapon;

/**
 * Cálculo de la vida a partir de la mitad del poder del arma.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Diez
 * @author Andrea San Ramon
 */
public class HalfLife extends LifeStrategy{
	
	private int nodeLife;
	
	public HalfLife(int life){
		
		nodeLife = life;
		
	}
	
	@Override
	public int calculateLife(int life, Weapon weapon) {
		int lifeResult = Math.max(0, life - weapon.getPower()/2);
		weapon.setPower(Math.max(0, weapon.getPower() - life * 2));
		return lifeResult;
	}

	@Override
	public int getPrice() {
		return nodeLife *2;
	}
}
