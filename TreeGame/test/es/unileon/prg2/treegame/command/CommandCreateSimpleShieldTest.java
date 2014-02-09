package es.unileon.prg2.treegame.command;

import static org.junit.Assert.*;

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

public class CommandCreateSimpleShieldTest {

	private Handler newNodeId, parent;
	private Node node1, node2;
	private LifeStrategy strategy;
	private Credit credit;
	
	@Before
	public void setUp() throws Exception {

		this.parent = new NodeHandler(1);
		this.newNodeId = new NodeHandler(2);

		this.strategy = new DefaultLife();

		this.node1 = new Articulation(parent, 4, strategy);
		this.node2 = new Extremity(newNodeId, 10, strategy);

		this.credit = new Credit(100);
		

		/* Arbol */

		// Node 1
			// Node2
		this.node1.add(node2);
	}

	/**
	 * Test para comprobar si funciona bien el constructor
	 */
	@Test
	public void constructorTest() {
		CommandCreateSimpleShield simpleshield = new CommandCreateSimpleShield(10, node1, this.credit);
		assertNotNull(simpleshield);
	}
	
	/**
	 * Test con excepcion para comprobar que salta cuando le pasamos un nodo con id nulo
	 */
	@Test(expected = IllegalArgumentException.class)
	public void executeExcepcionNodoNull(){
		Node node3 = new Extremity(null, 10, strategy);
		node1.add(node3);
		CommandCreateSimpleShield simpleshield = new CommandCreateSimpleShield(2, node3, this.credit);
		simpleshield.execute();
	}
	
	/**
	 * Test para comprobar que se puede crear el escudo
	 */
	@Test
	public void executeTest(){
		CommandCreateSimpleShield newCommand = new CommandCreateSimpleShield (5, this.node1, this.credit);
		newCommand.execute();		
		assertEquals(credit.getCredit(), 95);
		
	}

}
