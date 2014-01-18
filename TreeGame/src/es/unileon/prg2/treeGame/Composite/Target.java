package es.unileon.prg2.treeGame.Composite;
import es.unileon.prg2.treeGame.Handler.Handler;


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
