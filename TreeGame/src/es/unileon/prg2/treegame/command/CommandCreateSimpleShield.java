package es.unileon.prg2.treegame.command;

import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.composite.shields.Shield;
import es.unileon.prg2.treegame.composite.shields.SimpleShield;
import es.unileon.prg2.treegame.helpers.Credit;
/**
 * Comando que nos permite asignar un SimpleShield a un nodo.
 * @author Alberto Manzano
 * @author Iv�n Montes
 * @author Pablo D�ez
 * @author Andrea San Ram�n
 * @version 1.0
 */
public class CommandCreateSimpleShield implements Command{

	private int resistance;
	private Node nodeTarget;
	private Credit credit;
	private Shield simpleShield;
	
	/**
	 * Constructor
	 * @param resistance
	 * @param nodeTarget
	 * @param credit
	 */
	public CommandCreateSimpleShield(int resistance, Node nodeTarget, Credit credit){
		this.nodeTarget = nodeTarget;
		this.resistance = resistance;
		this.credit = credit;
	}
	@Override
	public void execute(){
		if(nodeTarget.search(nodeTarget.getId()) == null)
			throw new IllegalArgumentException("Se ha de pasar un nodo existenete al que ponerle escudo.");
		this.simpleShield = new SimpleShield(nodeTarget, resistance);
		credit.buyObject(simpleShield);
	}
}
