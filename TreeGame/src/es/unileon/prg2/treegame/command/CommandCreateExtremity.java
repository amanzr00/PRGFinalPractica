package es.unileon.prg2.treegame.command;


import es.unileon.prg2.treegame.composite.Extremity;
import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.helpers.Credit;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

/**
 * Comando para crear una extremity
 * @author Alberto Manzano
 * @author Ivan Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */
public class CommandCreateExtremity implements Command{

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
	public CommandCreateExtremity(Credit credit, Node tree, Handler newNodeId, Handler parentId, int life){
		
		this.credit = credit;
		this.tree = tree;
		this.newNodeId = newNodeId;
		this.parentId = parentId;
		this.life = life;
		
	}
	
	@Override
	public void execute(){
		
		// si el padre no existe excepcion
		Node parentNode = tree.search(parentId);
		if(parentNode == null) throw new IllegalArgumentException("Me tienen que pasar un padre que exista");
			
		// si está el nuevo excepción
		if(tree.search(newNodeId) != null) throw new IllegalArgumentException("El nodo ya existe");
		
		// Creamos el nodo
		Node childNode = new Extremity(newNodeId, life, lifeStrategy);
		// Cobramos el precio
		credit.buyObject(childNode);
		// Anadimos el nodo hijo al padre
		parentNode.add(childNode);
		
	}

}