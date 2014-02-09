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
import es.unileon.prg2.treegame.strategy.LifeStrategy;
import es.unileon.prg2.treegame.strategy.ThresholdLife;

/**
 * Test de la clase CommandCreateThresholdLife
 * @author Alberto Manzano
 * @author Ivan Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */

public class CommandCreateThresholdLifeTest {
	
	private Handler id1, id2;
	private Node node, nodeTarget;
	private LifeStrategy thresholdLife;
	private Credit credit;
	private CommandCreateThresholdLife newCreated;

	@Before
	public void setUp() throws Exception {
		
		this.id1 = new NodeHandler(1);
		this.id2 = new NodeHandler(2);
		
		this.thresholdLife = new ThresholdLife(4);
		
		this.node = new Articulation (id2, 10, thresholdLife);
		this.nodeTarget = new Extremity(id1, 4, thresholdLife);
		
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
		
		CommandCreateThresholdLife newStrategy = new CommandCreateThresholdLife (this.node, nodeTarget, this.thresholdLife, this.credit);
		assertNotNull(newStrategy);
		
	}
	
	/**
	 * Test para comprobar que se necesita un nodo existente para aplicar la estrategia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void executeExceptionNodeNotExist() {
		
		Handler id2 = new NodeHandler(2);
		Node newNode = new Articulation(id2, 10, thresholdLife);
		this.newCreated = new CommandCreateThresholdLife(nodeTarget, newNode, thresholdLife, credit);
		this.newCreated.execute();
		
	}
	/**
	 *  Test para comprobar que se establece una estategya de vida por comandos
	 */
	@Test
	public void executeTest(){
		
	
		this.newCreated = new CommandCreateThresholdLife(this.node, this.nodeTarget, this.thresholdLife, this.credit);
		
		newCreated.execute();
		
		assertEquals(nodeTarget.getLifeStrategy(), thresholdLife);
		assertEquals( nodeTarget.getPrice() , nodeTarget.getLife());
		
	}

}