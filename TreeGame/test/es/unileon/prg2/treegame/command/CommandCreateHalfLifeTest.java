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
import es.unileon.prg2.treegame.strategy.HalfLife;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

public class CommandCreateHalfLifeTest {
	
	private Handler id1, id2;
	private Node node, nodeTarget;
	private LifeStrategy halfLife;
	private Credit credit;
	private CommandCreateHalfLife newCreated;

	@Before
	public void setUp() throws Exception {
		
		this.id1 = new NodeHandler(1);
		this.id2 = new NodeHandler(2);
		
		
		
		this.halfLife = new HalfLife(4);
		
		this.node = new Articulation (id2, 10, halfLife);
		this.nodeTarget = new Extremity(id1, 4, halfLife);
		
		this.credit = new Credit(10);
		
		/* Arbol */
		
		// node1
			//node2
		
		this.node.add(nodeTarget);
	}
	
	/**
	 * Test para el constructor
	 */
	@Test
	public void constructorTest(){
		
		CommandCreateHalfLife commandCreateHalfLife = new CommandCreateHalfLife(this.node, this.nodeTarget, this.halfLife, this.credit);
		assertNotNull(commandCreateHalfLife);
		
	}
	
	/**
	 * Test para comprobar que se necesita un nodo existente para aplicar la estrategia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void executeExceptionNodeNotExist() {
		
		Handler id2 = new NodeHandler(2);
		Node newNode = new Articulation(id2, 10, halfLife);
		this.newCreated = new CommandCreateHalfLife(nodeTarget, newNode, halfLife, credit);
		this.newCreated.execute();
		
	}
	/**
	 *  Test para comprobar que se establece una estategya de vida por comandos
	 */
	@Test
	public void executeTest(){
		
		this.newCreated = new CommandCreateHalfLife(this.node, this.nodeTarget, this.halfLife, this.credit);
		
		newCreated.execute();
		
		assertEquals(nodeTarget.getLifeStrategy(), halfLife);
		assertEquals( nodeTarget.getPrice() , nodeTarget.getLife());
		
		
	}

}