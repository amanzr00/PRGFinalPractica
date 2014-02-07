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

	private int totalCredit;
	
	/**
	 * Constructor
	 * @param totalCredit
	 */
	public Credit(int totalCredit){
		
		this.totalCredit = totalCredit;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCredit(){
		return this.totalCredit;
	}
	
	/**
	 * 
	 * @param cost
	 * @throws InvalidCreditValueException
	 */
	public void setCredit(int cost) throws InvalidCreditValueException{
		
		if (cost > totalCredit) throw new InvalidCreditValueException ("El credito total ha de ser mayor que el precio del objeto");
		
		this.totalCredit = totalCredit - cost;

	}
}
