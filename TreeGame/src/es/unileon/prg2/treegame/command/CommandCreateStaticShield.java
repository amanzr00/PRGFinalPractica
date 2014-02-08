package es.unileon.prg2.treegame.command;

import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.composite.shields.Shield;
import es.unileon.prg2.treegame.composite.shields.StaticShield;
import es.unileon.prg2.treegame.helpers.Credit;

public class CommandCreateStaticShield implements Command {

	private int resistance;
	private Node nodeTarget;
	private Credit credit;
	private Shield staticShield;
	
	
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
