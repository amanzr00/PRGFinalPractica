package es.unileon.prg2.treegame.helpers;

import org.apache.log4j.Logger;
import es.unileon.prg2.treegame.exceptions.InvalidPowerValueException;

/**
 * Armas que se emplean para matar los árboles enemigos.
 * @author Alberto Manzano
 * @author Ivan Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */
public class Weapon implements Valorize {

	/**
	 * Log
	 */
	static Logger log = Logger.getLogger(Weapon.class);
	
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
		log.info("Arma creada con" + this.power + "de potencia.");
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
	 * @throws InvalidPowerValueException si el valor establecido es menor que 0.
	 */
	public void setPower(int power) throws InvalidPowerValueException {
		if(power < 0){
			log.error("El poder del arma no puede establecerse menor que cero");
			throw new InvalidPowerValueException("El valor del poder del arma debe ser siempre superior a 0");
			
		}
		
		this.power = power;
		log.info("Poder del arma actualizado a " + power );
	}
	
	public int getPrice(){
		return getPower();
	}
}
