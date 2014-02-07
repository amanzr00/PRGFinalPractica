package es.unileon.prg2.treegame.command;

import es.unileon.prg2.treegame.composite.Articulation;
import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.composite.shields.Shield;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.handler.Identifier;
import es.unileon.prg2.treegame.handler.NodeHandler;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

public class CommandCreate {

	private Node node;
	
	private LifeStrategy strategy;
	
	private Shield shield;
	
	private int life;
	
	private Handler identifier;
	
	private Identifier id;
	
	/**
	 * Constructor
	 * @param node
	 * @param strategy
	 * @param shield
	 */
	
	public void CommandCreate(Node node, LifeStrategy strategy, Shield shield){
		
		this.identifier = new NodeHandler (id.getId());
		this.node = node;
		this.strategy = strategy;
		this.shield = shield;
		
	}
	
	/**
	 * 
	 */
	public void execute(){
		
		this.node = new Articulation( identifier, life, strategy);
	}
	
	
	
	
	
}