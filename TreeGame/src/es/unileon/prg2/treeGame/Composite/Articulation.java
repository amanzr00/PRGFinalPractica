package es.unileon.prg2.treeGame.Composite;

import java.util.ArrayList;


import es.unileon.prg2.treeGame.Handler.Handler;

public abstract class Articulation implements Node{

	private ArrayList<Node> nodes;
	
	
	public Articulation(Handler id){
		nodes = new ArrayList<Node>();
	}
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
