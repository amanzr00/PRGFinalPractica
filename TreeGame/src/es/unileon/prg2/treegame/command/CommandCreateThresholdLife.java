package es.unileon.prg2.treegame.command;

import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.helpers.Credit;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

public class CommandCreateThresholdLife {

	private Node nodeTarget;
	private LifeStrategy thresholdLife;
	private Credit credit;
	private int threshold;
	
	public CommandCreateThresholdLife(Node nodeTarget, LifeStrategy thresholdLife, Credit credit, int threshold){
		this.nodeTarget = nodeTarget;
		this.thresholdLife = thresholdLife;
		this.credit = credit;
		this.threshold = threshold;
	}
	
	public void execute(){
		if(nodeTarget.search(nodeTarget.getId()) == null)
			throw new IllegalArgumentException("Se ha de pasar un nodo existenete al que aplicarle la estrategia.");
		if((credit.getCredit() <= 0) || (credit.getCredit() <  ))
			throw new IllegalArgumentException("No se dispone de credito suficiente");
		
		nodeTarget.setLifeStrategy(halfLife);
		credit.setCredit(nodeTarget.getLife()*2);
	
	}
}
