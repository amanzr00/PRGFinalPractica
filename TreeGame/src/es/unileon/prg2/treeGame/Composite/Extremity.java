package es.unileon.prg2.treeGame.Composite;

import es.unileon.prg2.treeGame.Handler.Handler;

public class Extremity implements Node {
	
	private Handler id;
	
	public Extremity(Handler id){
		this.id = id;
	}

	@Override
	public Handler getId() {
		return this.id;
	}

	@Override
	public boolean add(Node objetive) {
		return false;
	}

	@Override
	public boolean remove(Node objetive) {
		return false;
	}

	@Override
	public Node search(Handler id) {
		if(id.compareTo(id) == 0){
			return this;
		}
		return null;
	}

	@Override
	public int hurt() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
}
