package es.unileon.prg2.treegame.command;

import es.unileon.prg2.treegame.composite.Articulation;
import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.helpers.Credit;
import es.unileon.prg2.treegame.strategy.DefaultLife;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

/**
 * Comando para crear una articulation
 * @author Alberto Manzano
 * @author Ivan Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */
public class CommandCreateArticulation {

	private Node tree;
	
	private Handler newNodeId;
	
	private Handler parentId;
	
	private int life;
	
	private Credit credit;
	
	private LifeStrategy lifeStrategy;
	/**
	 * Constructor
	 * @param node
	 * @param strategy
	 * @param shield
	 */
	public CommandCreateArticulation(Credit credit, Node tree, Handler newNodeId, Handler parentId, int life){
		this.credit = credit;
		this.tree = tree;
		this.newNodeId = newNodeId;
		this.parentId = parentId;
		this.life = life;
		this.lifeStrategy = new DefaultLife();
	}
	
	/**
	 * Metodo que ejecuta el comando
	 */
	public void execute(){
		// Buscamos el nodo padre
		Node parentNode = tree.search(parentId);
		if(parentNode == null)
			throw new IllegalArgumentException("Me tienen que pasar un padre que exista");
		// si está el nuevo excepción
		if(tree.search(newNodeId) != null)
			throw new IllegalArgumentException("El nodo ya existe");
		
		
		// Si llega aqui, es porque el padre existe, no hay problemas con el credito ni con el nodo nuevo
		// Creamos el nodo
		Node childNode = new Articulation(newNodeId, life, lifeStrategy);
		// Anadimos el nodo hijo al padre
		parentNode.add(childNode);
		// Cobramos el precio
		credit.buyObject(childNode);
	}
}