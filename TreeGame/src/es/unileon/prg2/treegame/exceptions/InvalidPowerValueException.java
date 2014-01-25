package es.unileon.prg2.treegame.exceptions;

/**
 * Excepción que se lanza cuando el valor establecido en el poder del arma es
 * inferior a 0.
 * @author Alberto Manzano
 * @version 1.0
 */
public class InvalidPowerValueException extends RuntimeException {
	
	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la excepción sin mensaje.
	 */
	public InvalidPowerValueException (){
		super();
	}

	/**
	 * Constructor de la excepción con mensaje.
	 * @param message Mensaje mandado.
	 */
	public InvalidPowerValueException(String message){
		super(message);
	}
}
