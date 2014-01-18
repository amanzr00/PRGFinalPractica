package es.unileon.prg2.treegame.strategy;
import es.unileon.prg2.treegame.helpers.Weapon;

/**
 * Clase que implementa la estrategia del cálculo de vida mediante un umbral, la  vida se calcula restando de la vida actual la potencia del arma utilizada
 * menos ese umbral.
 * @author Alberto
 *
 */
public class ThresholdLife implements LifeStrategy {
	
	private int threshold;

	/**
	 * Método constructor de la clase.
	 * @param threshold
	 */
	public ThresholdLife(int threshold){
		this.threshold = threshold;
	}
	/**
	 * Método que dada la vida del nodo y la potencia del arma con la que atacan nos devuelve la vida restante
	 * aplicando el umbral definido.
	 */
	@Override
	public int calculateLife(int life, Weapon weapon) {
		if((weapon.getPower() - threshold) == 0){
			weapon.setPower(0);
		}else if((weapon.getPower() - threshold) < life){
			life = life - (weapon.getPower() - threshold);
			weapon.setPower((weapon.getPower() - threshold));
		}else if((weapon.getPower() - threshold) > life){
			life = 0;
			weapon.setPower((weapon.getPower() - threshold));
		}else{
			life = 0;
			weapon.setPower(0);
		}
		return life;
	}
}
