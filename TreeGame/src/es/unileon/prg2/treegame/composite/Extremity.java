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
	public Extremity(int life, LifeStrategy lifeStrategy) {
		super();
		this.life = life;
		this.lifeStrategy = lifeStrategy;
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
