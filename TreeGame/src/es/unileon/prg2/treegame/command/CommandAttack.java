package es.unileon.prg2.treegame.command;

import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.helpers.Weapon;

public class CommandAttack {

	private Weapon weapon;
	private Node target;
	
	public CommandAttack(Weapon weapon, Node target){
		this.weapon = weapon;
		this.target = target;
	}
}
