package es.unileon.prg2.treegame.composite;

import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

public class Extremity extends Node {

	public Extremity(int life, LifeStrategy lifeStrategy) {
		super(life, lifeStrategy);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(Target target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hurt(Weapon weapon) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFinalScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLive() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLife(int life) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLifeStrategy(LifeStrategy lifeStrategy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Handler getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Node target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Node target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node search(Handler id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hurt() {
		// TODO Auto-generated method stub
		return 0;
	}

}
