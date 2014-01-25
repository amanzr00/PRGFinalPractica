package es.unileon.prg2.treegame.composite.shields;

import es.unileon.prg2.treegame.composite.Node;
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
public abstract class Shield extends Node {

	/**
	 * El nodo al que proteje el escudo.
	 */
	private Node node;
	
	/**
	 * Constructor del escudo decorator.
	 * @param node El target al que proteje el escudo.
	 */
	public Shield(Node node){
		super(node.getId());
		this.node = node;
	}
	
	@Override
	public Handler getId() {
		return node.getId();
	}

	@Override
	public boolean add(Node target) {
		return this.node.add(target);
	}

	@Override
	public boolean remove(Node target) {
		return this.node.remove(target);
	}

	@Override
	public Node search(Handler id) {
		return this.node.search(id);
	}

	@Override
	public int hurt(Weapon weapon){
		return this.node.hurt(weapon);
	}

	@Override
	public int getFinalScore() {
		return this.node.getFinalScore();
	}

	@Override
	public boolean isAlive() {
		return this.node.isAlive();
	}

	@Override
	public int getLife() {
		return this.node.getLife();
	}

	@Override
	public void setLife(int life) {
		this.node.setLife(life);
	}

	@Override
	public void setLifeStrategy(LifeStrategy lifeStrategy) {
		this.node.setLifeStrategy(lifeStrategy);
	}
	
	@Override
	public String toString() {
		return this.node.toString();
	}
}
