package es.unileon.prg2.treegame.command;

import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.helpers.Credit;
import es.unileon.prg2.treegame.helpers.Weapon;

public class CommandAttack {

	private Weapon weapon;
	private Node nodeTarget;
	private Credit credit;
	
	public CommandAttack(Weapon weapon, Node nodeTarget, Credit credit){
		this.weapon = weapon;
		this.nodeTarget = nodeTarget;
		this.credit = credit;
	}
	
	public void execute(){
		if(nodeTarget.search(nodeTarget.getId()) == null)
			throw new IllegalArgumentException("Se ha de pasar un nodo existenete al que atacar");
		nodeTarget.hurt(weapon);
		credit.buyObject(weapon);
	}
}
