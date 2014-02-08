package es.unileon.prg2.treegame.command;

import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.helpers.Credit;
import es.unileon.prg2.treegame.strategy.LifeStrategy;
/**
 * Comando que nos permite asignar una estrategia umbral a un nodo.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @author Andrea San Ramón
 * @version 1.0
 */
public class CommandCreateThresholdLife implements Command {

	private Node nodeTarget;
	private LifeStrategy thresholdLife;
	private Credit credit;
	
	/**
	 * Constructor
	 * @param nodeTarget
	 * @param thresholdLife
	 * @param credit
	 */
	public CommandCreateThresholdLife(Node nodeTarget, LifeStrategy thresholdLife, Credit credit){
		this.nodeTarget = nodeTarget;
		this.thresholdLife = thresholdLife;
		this.credit = credit;
		
	}
	@Override
	public void execute(){
		if(nodeTarget.search(nodeTarget.getId()) == null)
			throw new IllegalArgumentException("Se ha de pasar un nodo existenete al que aplicarle la estrategia.");
		
		
		nodeTarget.setLifeStrategy(thresholdLife);
		credit.buyObject(nodeTarget);
	
	}
}
