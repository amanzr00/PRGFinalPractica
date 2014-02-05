package es.unileon.prg2.treegame.composite;

import es.unileon.prg2.treegame.exceptions.InvalidLifeValueException;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

/**
 * Extremidad elemento hoja del árbol de juego.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @version 1.0
 */
public class Extremity extends Node {

	/**
	 * Vida del nodo.
	 */
	private int life;
	/**
	 * Estrategia de cálculo de la vida.
	 */
	private LifeStrategy lifeStrategy;
	
	/**
	 * Constructor de la extremidad que recibe vida y estrategia de cálculo.
	 * @param life la vida del nodo.
	 * @param lifeStrategy la estrategia para calcular la vida.
	 */
	public Extremity(Handler id, int life, LifeStrategy lifeStrategy) {
		super(id);
		this.life = life;
		this.lifeStrategy = lifeStrategy;

	}
	
	@Override
	public boolean add(Node node) {
		return false;
	}
	
	@Override
	public boolean remove(Node node) {
		return false;
	}
	
	@Override
	public String toString() {
		return getId().toString();
	}
	
	@Override
	public Node search(Handler id) {
		if(getId().compareTo(id) == 0){
			return this;
		}
		return null;
	}
	
	@Override
	public int hurt(Weapon weapon) {
		setLife(lifeStrategy.calculateLife(this.life, weapon));
		return weapon.getPower();
	}
	
	@Override
	public int getFinalScore() {
		if(isAlive()){
			return this.life + 10;
		}
		return 0;
	}
	
	@Override
	public int getLife() {
		return this.life;
	}
	
	@Override
	public void setLife(int life) {
		if(life < 0){
			throw new InvalidLifeValueException("El valor de la vida debe ser igual o superior a 0.");
		}
		this.life = life;
	}
	
	@Override
	public void setLifeStrategy(LifeStrategy lifeStrategy) {
		if(lifeStrategy == null){
			throw new IllegalArgumentException("La estrategia de la vida no puede ser nula.");
		}
		this.lifeStrategy = lifeStrategy;
	}
}
