package es.unileon.prg2.treegame.command;

import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.helpers.Credit;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

public class CommandCreateThresholdLife {

	private Node nodeTarget;
	private LifeStrategy thresholdLife;
	private Credit credit;
	
	
	public CommandCreateThresholdLife(Node nodeTarget, LifeStrategy thresholdLife, Credit credit){
		this.nodeTarget = nodeTarget;
		this.thresholdLife = thresholdLife;
		this.credit = credit;
		
	}
	
	public void execute(){
		if(nodeTarget.search(nodeTarget.getId()) == null)
			throw new IllegalArgumentException("Se ha de pasar un nodo existenete al que aplicarle la estrategia.");
		if((credit.getCredit() <= 0) || (credit.getCredit() < thresholdLife.getPrice()))
			throw new IllegalArgumentException("No se dispone de credito suficiente");
		
		nodeTarget.setLifeStrategy(thresholdLife);
		credit.buyObject(nodeTarget);
	
	}
}
