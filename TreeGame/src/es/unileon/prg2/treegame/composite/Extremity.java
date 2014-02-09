package es.unileon.prg2.treegame.composite;

import org.apache.log4j.Logger;

import es.unileon.prg2.treegame.exceptions.InvalidLifeValueException;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

/**
 * Extremidad, elemento hoja del árbol de juego.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */
public class Extremity extends Node {

	/**
	 * Log
	 */
	static Logger log = Logger.getLogger(Extremity.class);
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
	 * @param id del nodo
	 * @param life la vida del nodo.
	 * @param lifeStrategy la estrategia para calcular la vida.
	 */
	public Extremity(Handler id, int life, LifeStrategy lifeStrategy) {
		super(id);
		//Comprobamos la vida
		if (life == 0) throw new InvalidLifeValueException("No puede crear un nodo de vida 0.");
		setLife(life);
		setLifeStrategy(lifeStrategy);
		log.info("Creacion de Extremidad: " + id.toString());
	}
	
	@Override
	public boolean add(Node node) {
		if(node == null){
			log.error("Error en agregar un nodo, no se esta pasando un nodo");
			throw new IllegalArgumentException("Me tienen que pasar un nodo para añadir.");
		}
		log.info("No se pueden agregar elementos a una extremidad");
		return false;
	}
	
	@Override
	public boolean remove(Node node) {
		if(node == null){
			log.error("Error en borrar un nodo, no se esta pasando un nodo");
			throw new IllegalArgumentException("Me tienen que pasar un nodo para borrar.");
		}
		log.info("No se puden eliminar elementos de una extremidad");
		return false;
	}
	
	@Override
	public String toString() {
		return getId().toString();
	}
	
	@Override
	public Node search(Handler id) {
		if(getId().compareTo(id) == 0){
			log.info("Componente encontrado, su id es:" + id.toString());
			return this;
		}
		return null;
	}
	
	@Override
	public int hurt(Weapon weapon) {
		setLife(lifeStrategy.calculateLife(this.life, weapon));
		log.info("Daño realizado con una potencia de" + weapon.getPower());
		return weapon.getPower();
	}
	
	@Override
	public int getFinalScore() {
		if(isAlive()){
			log.info("Puntuacion obtenida, este nodo tiene" + this.life + 10);
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
			log.error("La vida se ha de establecer a un valor mayor que cero");
			throw new InvalidLifeValueException("El valor de la vida debe ser igual o superior a 0.");
		}
		this.life = life;
		log.info("Vida establecida con valor" + this.life);
	}
	
	@Override
	public void setLifeStrategy(LifeStrategy lifeStrategy) {
		if(lifeStrategy == null){
			log.error("Se ha de establecer una estrategia por nodo");
			throw new IllegalArgumentException("La estrategia de la vida no puede ser nula.");
		}
		log.info("Estrategia de tipo " + lifeStrategy.toString() + "establecida");
		this.lifeStrategy = lifeStrategy;
	}

	@Override
	public int getPrice() {
		return getLife();
	}
	
	@Override
	public LifeStrategy getLifeStrategy() {
		
		return this.lifeStrategy;
	}
}
