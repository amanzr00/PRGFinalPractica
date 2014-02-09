package es.unileon.prg2.treegame.command;

import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.composite.shields.Shield;
import es.unileon.prg2.treegame.composite.shields.StaticShield;
import es.unileon.prg2.treegame.helpers.Credit;

/**
 * Comando que nos permite asignar un StaticShield a un nodo.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @author Andrea San Ramón
 * @version 1.0
 */

public class CommandCreateStaticShield implements Command {

	private int resistance;
	private Node nodeTarget;
	private Credit credit;
	private Shield staticShield;
	
	/**
	 * Constructor
	 * @param resistance
	 * @param nodeTarget
	 * @param credit
	 */
	public CommandCreateStaticShield(int resistance, Node nodeTarget, Credit credit){
		this.nodeTarget = nodeTarget;
		this.resistance = resistance;
		this.credit = credit;
	}
	
	public void execute(){
		if(nodeTarget.search(nodeTarget.getId()) == null)
			throw new IllegalArgumentException("Se ha de pasar un nodo existenete al que ponerle escudo.");
		this.staticShield = new StaticShield(nodeTarget, resistance);
		credit.buyObject(staticShield);
	}
}
