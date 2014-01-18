package es.unileon.prg2.treegame.helpers;

import es.unileon.prg2.treegame.exceptions.InvalidPowerValueException;

/**
 * Armas que se emplean para matar los árboles enemigos.
 * @author Alberto Manzano
 * @version 1.0
 */
public class Weapon {

	/**
	 * Poder asignado al arma.
	 */
	private int power;

	/**
	 * Constructor del arma que recibe un poder.
	 * @param power el poder del arma a construir.
	 */
	public Weapon(int power){
		this.power = power;
	}

	/**
	 * Permite obtener el poder del arma.
	 * @return el poder del arma actual.
	 */
	public int getPower(){
		return this.power;
	}

	/**
	 * Establece el poder del arma.
	 * @param power poder a establecer.
	 */
	public void setPower(int power){
		if(power < 0) throw new InvalidPowerValueException("El valor del poder del arma debe ser siempre superior a 0");
		this.power = power;
	}
}
