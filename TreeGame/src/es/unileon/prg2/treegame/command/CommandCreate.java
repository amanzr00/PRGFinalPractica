package es.unileon.prg2.treegame.command;

import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.composite.shields.Shield;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

public class CommandCreate {

	private Node node;
	
	private LifeStrategy strategy;
	
	private Shield shield;
	
	private int life;
	
	private int identifier;
	
	/**
	 * Constructor
	 * @param node
	 * @param strategy
	 * @param shield
	 */
	
	public void CommandCreate(Node node, LifeStrategy strategy, Shield shield){
		
		this.node = node;
		this.strategy = strategy;
		this.shield = shield;
		
	}
	
	/**
	 * 
	 */
	public void execute(){
		
		this.node = new Articulation( id, life, strategy);
	}
	
	
	
	
	
}