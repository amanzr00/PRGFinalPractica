package es.unileon.prg2.treegame.helpers;

import es.unileon.prg2.treegame.exceptions.InvalidCreditValueException;

/**
 * Credito del jugador
 * @author Alberto Manzano
 * @author Ivan Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */
public class Credit {

	/**
	 * Credito total del jugador
	 */
	private int totalCredit;
	
	/**
	 * Constructor
	 * @param totalCredit Credito total
	 */
	public Credit(int totalCredit){
		this.totalCredit = totalCredit;
	}
	
	/**
	 * Permite obtener el credito total
	 * @return Credito total
	 */
	public int getCredit(){
		return this.totalCredit;
	}
	
	/**
	 * Devuelve el credito final actualizado tras restar el precio de un objeto con valor
	 * @param object Precio del objeto 
	 * @throws InvalidCreditValueException Si el precio del objeto es mayor que el credito total
	 */
	public void buyObject(Valorize object) throws InvalidCreditValueException{
		if (object.getPrice() > totalCredit) throw new InvalidCreditValueException ("El credito total ha de ser mayor que el precio del objeto");
		this.totalCredit = totalCredit - object.getPrice();
	}
}
