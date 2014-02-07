package es.unileon.prg2.treegame.command;


import es.unileon.prg2.treegame.composite.Extremity;
import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.helpers.Credit;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

/**
 * Comando para crear una extremidad
 * @author Alberto Manzano
 * @author Ivan Montes
 * @author Pablo D�ez
 * @author Andrea San Ramon
 * @version 1.0
 */
public class CommandCreateExtremity {

	private Node tree, childNode, parentNode;
	
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
	public CommandCreateExtremity(Credit credit, Node tree, Handler newNodeId, Handler parentId, int life){
		
		this.credit = credit;
		this.tree = tree;
		this.newNodeId = newNodeId;
		this.parentId = parentId;
		this.life = life;
		
	}
	
	/**
	 * Metodo que ejecuta el comando
	 */
	public void execute(){
		// si el padre no existe excepcion
		if(tree.search(parentId) == null) throw new IllegalArgumentException("Me tienen que pasar un padre que exista");
		// si est� el nuevo excepci�n
		if(tree.search(newNodeId) != null) throw new IllegalArgumentException("El nodo ya existe");
		// compruebo credito, si no excepcion
		if((credit.getCredit() <= 0) || (credit.getCredit() < life )) throw new IllegalArgumentException("No se dispone de credito suficiente");
		
		// Si llega aqui, es porque el padre existe, no hay problemas con el credito ni con el nodo nuevo
		// Creamos el nodo
		childNode = new Extremity(newNodeId, life, lifeStrategy);
		// Buscamos el nodo padre
		parentNode = tree.search(parentId);
		// Anadimos el nodo hijo al padre
		parentNode.add(childNode);
		// Cobramos el precio
		credit.setCredit(life);
	
	}

}