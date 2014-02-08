package es.unileon.prg2.treegame.composite;

import org.apache.log4j.Logger;

import es.unileon.prg2.treegame.exceptions.InvalidLifeValueException;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

/**
 * Extremidad elemento hoja del árbol de juego.
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
	static Logger log = Logger.getLogger(Articulation.class);
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
		log.info("Creacion de la Extremity.");
		this.life = life;
		this.lifeStrategy = lifeStrategy;

	}
	
	@Override
	public boolean add(Node node) {
		log.info("No se pueden agregar elementos a una extremidad");
		return false;
	}
	
	@Override
	public boolean remove(Node node) {
		log.info("No se puden eliminar elementos de una extremidad");
		return false;
	}
	
	@Override
	public String toString() {
		log.info("Se convierte a string la extremidad.");
		return getId().toString();
	}
	
	@Override
	public Node search(Handler id) {
		if(getId().compareTo(id) == 0){
			log.info("Devuelve el componente si son iguales.");
			return this;
		}
		return null;
	}
	
	@Override
	public int hurt(Weapon weapon) {
		setLife(lifeStrategy.calculateLife(this.life, weapon));
		log.info("Danio realizado");
		return weapon.getPower();
	}
	
	@Override
	public int getFinalScore() {
		if(isAlive()){
			log.info("Puntuacion obtenida");
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
		log.info("Vida establecida");
		this.life = life;
	}
	
	@Override
	public void setLifeStrategy(LifeStrategy lifeStrategy) {
		if(lifeStrategy == null){
			log.error("Se ha de establecer una estrategia por nodo");
			throw new IllegalArgumentException("La estrategia de la vida no puede ser nula.");
		}
		log.info("Estrategia establecida");
		this.lifeStrategy = lifeStrategy;
	}

	@Override
	public int getPrice() {
		return getLife();
	}
}
