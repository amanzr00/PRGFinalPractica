package es.unileon.prg2.treegame.command;

import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.composite.shields.Shield;
import es.unileon.prg2.treegame.composite.shields.SpecialShield;
import es.unileon.prg2.treegame.helpers.Credit;
/**
 * Comando que nos permite asignar un SpecialShield a un nodo.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @author Andrea San Ramón
 * @version 1.0
 */
public class CommandCreateSpecialShield implements Command {

	private int numAttacks;
	private Node nodeTarget;
	private Credit credit;
	private Shield specialShield;
	
	/**
	 * Constructor
	 * @param resistance
	 * @param nodeTarget
	 * @param credit
	 * @param numAttacks
	 */
	public CommandCreateSpecialShield( Node nodeTarget, Credit credit, int numAttacks){
		this.nodeTarget = nodeTarget;
		this.credit = credit;
		this.numAttacks = numAttacks;
	}
	@Override
	public void execute(){
		if(nodeTarget.search(nodeTarget.getId()) == null)
			throw new IllegalArgumentException("Se ha de pasar un nodo existenete al que ponerle escudo.");
		this.specialShield = new SpecialShield(nodeTarget, numAttacks);
		credit.buyObject(specialShield);
	}
}
