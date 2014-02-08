package es.unileon.prg2.treegame.exceptions;

/**
 * Excepci�n que se lanza cuando el valor establecido en el poder del arma es
 * inferior a 0.
 * @author Alberto Manzano
 * @author Pablo Diez
 * @author Ivan Montes
 * @author Andrea San Ramon
 * @version 1.0
 */
public class InvalidResistanceValueException extends RuntimeException {
	
	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la excepci�n sin mensaje.
	 */
	public InvalidResistanceValueException (){
		super();
	}

	/**
	 * Constructor de la excepci�n con mensaje.
	 * @param message Mensaje mandado.
	 */
	public InvalidResistanceValueException(String message){
		super(message);
	}
}