package es.unileon.prg2.treegame.composite.shields;

import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.composite.Target;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

/**
 * Escudo genérico que contiene las operaciones principales de dichos escudos.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @version 1.0
 */
public abstract class Shield implements Target {

	/**
	 * El target al que proteje el escudo.
	 */
	private Target target;
	
	/**
	 * Constructor del escudo decorator.
	 * @param target El target al que proteje el escudo.
	 */
	public Shield(Target target){
		this.target = target;
	}
	
	@Override
	public Handler getId() {
		return target.getId();
	}

	@Override
	public boolean add(Target target) {
		return this.target.add(target);
	}

	@Override
	public boolean remove(Node target) {
		return this.target.remove(target);
	}

	@Override
	public Target search(Handler id) {
		return this.target.search(id);
	}

	@Override
	public int hurt(Weapon weapon){
		return this.target.hurt(weapon);
	}

	@Override
	public int getFinalScore() {
		return this.target.getFinalScore();
	}

	@Override
	public boolean isAlive() {
		return this.target.isAlive();
	}

	@Override
	public int getLive() {
		return this.target.getLive();
	}

	@Override
	public void setLife(int life) {
		this.target.setLife(life);
	}

	@Override
	public void setLifeStrategy(LifeStrategy lifeStrategy) {
		this.target.setLifeStrategy(lifeStrategy);
	}
}
