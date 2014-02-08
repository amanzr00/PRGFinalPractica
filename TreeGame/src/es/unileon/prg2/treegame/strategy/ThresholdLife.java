package es.unileon.prg2.treegame.strategy;
import es.unileon.prg2.treegame.helpers.Weapon;

/**
 * Cálculo de vida mediante un umbral, la  vida se calcula restando de la vida actual la potencia del arma utilizada
 * menos ese umbral.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 */
public class ThresholdLife extends LifeStrategy{
	
	private int threshold;

	/**
	 * Método constructor de la clase.
	 * @param threshold Umbral
	 */
	public ThresholdLife(int threshold){
		this.threshold = threshold;
	}
	
	@Override
	public int calculateLife(int life, Weapon weapon) {
		int lifeResult = Math.max(0, life - Math.max(0, weapon.getPower() - this.threshold));
		weapon.setPower(Math.max(0, weapon.getPower() - (life + this.threshold)));
		return lifeResult;
	}

	@Override
	public int getPrice() {
		return this.threshold;
	}
}
