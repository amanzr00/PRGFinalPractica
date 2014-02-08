package es.unileon.prg2.treegame.command;

import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.helpers.Credit;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

public class CommandCreateHalfLife {
	
	private Node nodeTarget;
	private LifeStrategy halfLife;
	private Credit credit;
	
	public CommandCreateHalfLife(Node nodeTarget, LifeStrategy halfLife, Credit credit){
		this.nodeTarget = nodeTarget;
		this.halfLife = halfLife;
		this.credit = credit;
	}
	
	public void execute(){
		if(nodeTarget.search(nodeTarget.getId()) == null)
			throw new IllegalArgumentException("Se ha de pasar un nodo existenete al que aplicarle la estrategia.");
		if((credit.getCredit() <= 0) || (credit.getCredit() < (nodeTarget.getLife() *2)))
			throw new IllegalArgumentException("No se dispone de credito suficiente");
		
		nodeTarget.setLifeStrategy(halfLife);
		credit.setCredit(nodeTarget.getLife()*2);
	
	}

}
