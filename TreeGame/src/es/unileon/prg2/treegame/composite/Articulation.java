package es.unileon.prg2.treegame.composite;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import es.unileon.prg2.treegame.exceptions.InvalidLifeValueException;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

/**
 * Clase de articulación, elemento capaz de tener hijos en el árbol.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */
public class Articulation extends Node {

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
		setLife(life);
		setLifeStrategy(lifeStrategy);
		this.nodes = new ArrayList<Node>();
		log.info("Creacion de Articulation " + id.toString());
	}


	
	@Override
	public boolean add(Node objetive) {
		if(objetive == null){
			log.error("Error en agregar un nodo, no se esta pasando un nodo");
			throw new IllegalArgumentException("Me tienen que pasar un nodo para añadir.");
		}
		log.info("Se ha anyadido el objetive" + objetive.toString() + "a" + this.toString());
		return nodes.add(objetive);
		
	}

	@Override
	public boolean remove(Node objetive) {
		if(objetive == null){
			log.error("Error en borrar nodo, no se esta pasando un nodo");
			throw new IllegalArgumentException("Me tienen que pasar un nodo a eliminar");
		}
		log.info("Se ha borrado el objetive" + objetive.toString() + "a" + this.toString());
		return nodes.remove(objetive);
	}

	@Override
	public Node search(Handler id) {
		if(id.compareTo(getId()) == 0){
			return this;
		}
		for(Node objetive : nodes){
			Node searchComponent = objetive.search(id);
			if(searchComponent != null) return objetive;
			log.info("Busqueda del componente de" + objetive.toString() + "en" + this.toString());
		}
		return null;
	}

	@Override
	public String toString() {
		log.info("Se convierte a string la Articulation.");
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
		log.info("Danio realizado.");
		return weapon.getPower();
	}

	@Override
	public int getFinalScore() {
		if(isAlive()){
			int totalLifeChild = 0;
			for (Node node : nodes){
				totalLifeChild = totalLifeChild + node.getFinalScore();
				log.info("Nodos recorridos");
			}
			log.info("Vida total calculada.");
			return this.life + 10 + totalLifeChild;
			
		}
		return 0;
	}

	@Override
	public int getLife() {
		log.info("Vida obtenida");
		return this.life;
	}

	@Override
	public void setLife(int life) {
		if(life < 0){
			log.error("La vida no puede ser negativa.");
			throw new InvalidLifeValueException("El valor de la vida debe ser igual o superior a 0.");
		}
		log.info("Vida establecida.");
		this.life = life;
	}
	
	@Override
	public void setLifeStrategy(LifeStrategy lifeStrategy) {
		if(lifeStrategy == null){
			log.error("Es obligatorio que el nodo tenga una estrategia");
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
