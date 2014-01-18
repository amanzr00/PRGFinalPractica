package es.unileon.prg2.treegame.composite;

import java.util.ArrayList;





import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

public abstract class Articulation extends Node{

	public Articulation(int life, LifeStrategy lifeStrategy) {
		super(life, lifeStrategy);
		// TODO Auto-generated constructor stub
	}

	private ArrayList<Node> nodes;
	
	
	@Override
	public abstract Handler getId();
		
	
	@Override
	public boolean add(Node objetive) {
		
		if(objetive.equals(Extremity.class.getSimpleName()) && !nodes.contains(objetive)){
			return nodes.add(objetive);
		}
		return false;
	}

	@Override
	public boolean remove(Node objetive) {
		
		if(objetive.equals(Extremity.class.getSimpleName())){
			return nodes.remove(objetive);
		}
		return false;
	}

	@Override
	public Node search(Handler id) {
		if(id.compareTo(id) == 0){
			return this;
		}
		for(Node objetive : nodes){
			Node searchComponent = objetive.search(id);
			if(searchComponent != null) return objetive;
		}
		return null;
	}

}
