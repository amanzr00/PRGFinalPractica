package es.unileon.prg2.treegame.composite.shields;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.composite.Articulation;
import es.unileon.prg2.treegame.composite.Extremity;
import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.handler.NodeHandler;
import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.DefaultLife;
import es.unileon.prg2.treegame.strategy.LifeStrategy;
import es.unileon.prg2.treegame.strategy.ThresholdLife;

/**
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Diez
 * @version 1.0
 */
public class SimpleShieldTest {
	
	private Weapon weapon1, weapon2, weapon3, weapon4;
	private Handler id1, id2, id3, id4, id5, id6, id7, id8, id9;
	private Node node1, node2, node3, node4, node5, node6, node7, node8, node9;
	private LifeStrategy strategy1, strategy2, strategy3, strategy4;
	private Shield simpleShield1, simpleShield2;
	
	
	private int resistance;
	
	@Before
	public void setUp() throws Exception {
		
		//node1 = new Articulation(100, lifeStrategy );
		resistance = 10;
		
		//node2 = new Extremity(50, lifeStrategy );
		
		weapon1 = new Weapon (5);
		
		this.id1 = new NodeHandler(1);
		this.id2 = new NodeHandler(2);
		this.id3 = new NodeHandler(3);
		this.id4 = new NodeHandler(4);
		this.id5 = new NodeHandler(5);
		this.id6 = new NodeHandler(6);
		this.id7 = new NodeHandler(7);
		this.id8 = new NodeHandler(8);
		this.id9 = new NodeHandler(9);
		this.weapon1 = new Weapon (10);
		this.weapon2 = new Weapon (6);
		this.weapon3 = new Weapon (2);
		this.weapon4 = new Weapon (4);
		this.strategy1 = new DefaultLife();
		this.strategy2 = new ThresholdLife(3);
		this.strategy3 = new ThresholdLife(5);
		
		
		//Node1
			//Node2
			//Node3
				//Node4
				//Node5
			
		this.node1 = new Articulation(id1, 15, strategy2);
		this.node2 = new Articulation(id2, 7, strategy1);
		this.node3 = new Articulation(id3, 6, strategy1);
		this.node4 = new Extremity (id4, 4, strategy1);
		this.node5 = new Extremity (id5, 6, strategy1);
		this.node7 = new Extremity(id6, 5, strategy1);
		
		this.simpleShield1 = new SimpleShield(node4, 10);
		
		this.node1.add(node2);
		this.node1.add(node3);
		this.node3.add(node4);
		this.node3.add(node5);
	}

	@Test
	public void testHurt() {
		assertEquals(this.simpleShield1.hurt(weapon2), 0);
		assertEquals(this.simpleShield1.hurt(weapon1), 2);
		
		
		
	}
}
