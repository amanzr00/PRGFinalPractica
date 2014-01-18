package es.unileon.prg2.treegame.composite;

import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.strategy.LifeStrategy;



public abstract class Node implements Target {
	
	private Handler id;
	private int life;
	private LifeStrategy lifeStrategy;
	
	public Node(int life, LifeStrategy lifeStrategy){
		this.life = life;
		this.lifeStrategy = lifeStrategy;
	}
	public abstract Handler getId();
	
	public abstract boolean add(Node target);
	
	public abstract boolean remove(Node target);
	
	public abstract String toString();
	
	public abstract Node search(Handler id);

	public abstract int hurt();
}
