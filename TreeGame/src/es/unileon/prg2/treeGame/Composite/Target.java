package es.unileon.prg2.treegame.composite;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.strategy.LifeStrategy;


public interface Target {
	
	public Handler getId();
	
	public boolean add(Node target);
	
	public boolean remove(Node target);
	
	public String toString();
	
	public Node search(Handler id);

	public int hurt();
	
	public int getFinalScore();
	
	public boolean isAlive();
	
	public int getLive();
	
	public void setLife(int life);
	
	public void setLifeStrategy(LifeStrategy lifeStrategy);
}
