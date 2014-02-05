package es.unileon.prg2.treegame.composite;

import java.util.ArrayList;







import es.unileon.prg2.treegame.exceptions.InvalidLifeValueException;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

/**
 * Clase de articulación, elemento capaz de tener hijos en el árbol.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @version 1.0
 */
public class Articulation extends Node {

	/**
	 * Vida del nodo.
	 */
	private int life;
	/**
	 * Estrategia de cálculo de la vida.
	 */
	private LifeStrategy lifeStrategy;
	/**
	 * Nodos hijo del elemento articulaión.
	 */
	private ArrayList<Node> nodes;
	
	/**
	 * Constructor de la articulación que recibe vida y estrategia de cálculo.
	 * @param life la vida del nodo.
	 * @param lifeStrategy la estrategia para calcular la vida.
	 */
	public Articulation(Handler id,int life, LifeStrategy lifeStrategy) {
		super(id);
		this.life = life;
		this.lifeStrategy = lifeStrategy;
		this.nodes = new ArrayList<Node>();
		
		
	}


	
	@Override
	public boolean add(Node objetive) {
		if(objetive == null){
			throw new IllegalArgumentException("Me tienen que pasar un nodo para añadir.");
		}
		return nodes.add(objetive);
		
	}

	@Override
	public boolean remove(Node objetive) {
		if(objetive == null){
			throw new IllegalArgumentException("Me tienen que pasar un nodo a eliminar");
		}
		return nodes.remove(objetive);
	}

	@Override
	public Node search(Handler id) {
		
		// D U D A (primer if)
		if(id.compareTo(getId()) == 0){
			return this;
		}
		for(Node objetive : nodes){
			Node searchComponent = objetive.search(id);
			if(searchComponent != null) return objetive;
		}
		return null;
	}

	@Override
	public String toString() {
		return getId().toString();
	}

	@Override
	public int hurt(Weapon weapon) {
		
		// DUDA (break)
		for(Node node : nodes){
			if(node.isAlive()){
				if(node.hurt(weapon) == 0) break;
			}
		}
		if(weapon.getPower() > 0) setLife(this.lifeStrategy.calculateLife(life, weapon));
		return weapon.getPower();
	}

	@Override
	public int getFinalScore() {
		if(isAlive()){
			int totalLifeChild = 0;
			for (Node node : nodes){
				totalLifeChild = totalLifeChild + node.getFinalScore();
			}
			return this.life + 10 + totalLifeChild;
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
