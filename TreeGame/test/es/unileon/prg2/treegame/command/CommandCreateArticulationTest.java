package es.unileon.prg2.treegame.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.composite.Articulation;
import es.unileon.prg2.treegame.composite.Extremity;
import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.handler.NodeHandler;
import es.unileon.prg2.treegame.helpers.Credit;
import es.unileon.prg2.treegame.strategy.DefaultLife;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

/**
 * 
 * @author Alberto Manzano
 * @author Ivan Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */

public class CommandCreateArticulationTest {

	private Handler newNodeId, parentId, parent1Id;
	private Node node1, node2;
	private LifeStrategy strategy;
	private Credit credit;
	private CommandCreateArticulation newArticulationCreated;
	
	@Before
	public void setUp() throws Exception {
		
		this.parentId = new NodeHandler(1);
		this.newNodeId = new NodeHandler(2);
		this.strategy = new DefaultLife();
		this.node1 = new Articulation(parentId, 4, strategy);
		this.node2 = new Extremity(newNodeId, 10, strategy);
		this.credit = new Credit (100);
		
		
		/* Arbol */
		
		// Node 1
			// Node2
		this.node1.add(node2);
	}
	
	@Test
	public void constructorTest(){
		
		CommandCreateArticulation newCreated1 = new CommandCreateArticulation (this.credit, node1, this.parentId, this.newNodeId, 10);
		
		assertNotNull(newCreated1);
		
	}
	
	/**
	 * Test para comprobar que no se puede crear una articulazion de un padre que no exista
	 */
	@Test(expected = IllegalArgumentException.class)
	public void executeExceptionIdParent(){
		
		this.parent1Id = new NodeHandler(3);
		Handler newChild = new NodeHandler(4);
		
		this.newArticulationCreated = new CommandCreateArticulation(this.credit, node1, this.parent1Id, newChild, 10);
		this.newArticulationCreated.execute();
		
	}
	/**
	 * Test para comprobar que no se puede crear un nodo que ya exista
	 */
	@Test(expected = IllegalArgumentException.class)
	public void executeExceptionNewIdExist(){
		
		this.newArticulationCreated = new CommandCreateArticulation (this.credit, node1, this.parentId, this.newNodeId, 10);
		this.newArticulationCreated.execute();
	}
	
	/**
	 * Test para comprobar que se puede crear un nodo articulation con command
	 */
	@Test
	public void executeTest(){
		// node1
			//node2
			// node3 (añadido)
		Handler newNode = new NodeHandler (3);
		
		CommandCreateArticulation newComand = new CommandCreateArticulation (this.credit, this.node1, newNode, this.parentId, 10);
		newComand.execute();
		
		assertEquals(credit.getCredit(), 90);
		assertNotNull(this.node1.search(newNode));
		
	}
}
