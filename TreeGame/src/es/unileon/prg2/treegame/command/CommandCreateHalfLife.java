package es.unileon.prg2.treegame.command;

import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.helpers.Credit;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

/**
 * Comando que nos permite asignar una estrategia de HalfLide a un nodo.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @author Andrea San Ramón
 * @version 1.0
 */

public class CommandCreateHalfLife implements Command {
	
	private Node tree, nodeTarget;
	private LifeStrategy halfLife;
	private Credit credit;
	/**
	 * Constructor
	 * @param nodeTarget
	 * @param halfLife
	 * @param credit
	 */
	public CommandCreateHalfLife(Node tree, Node nodeTarget, LifeStrategy halfLife, Credit credit){
		this.tree = tree;
		this.nodeTarget = nodeTarget;
		this.halfLife = halfLife;
		this.credit = credit;
	}
	@Override
	public void execute(){
		if(tree.search(nodeTarget.getId()) == null)
			throw new IllegalArgumentException("Se ha de pasar un nodo existenete al que aplicarle la estrategia.");
		nodeTarget.setLifeStrategy(halfLife);
		credit.buyObject(halfLife);
	
	}

}
