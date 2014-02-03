package es.unileon.prg2.treegame.composite;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.handler.NodeHandler;
import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.DefaultLife;
import es.unileon.prg2.treegame.strategy.LifeStrategy;
import es.unileon.prg2.treegame.strategy.ThresholdLife;

/**
 * @author Alberto Manzano
 * @author Iv�n Montes
 * @author Pablo D�ez
 * @version 1.0
 */
public class ArticulationTest {
	
	private ArrayList<Node> nodes;
	private Weapon weapon1, weapon2, weapon3, weapon4;
	//private Extremity node1, node2;
	private Handler id1, id2, id3, id4, id5, id6, id7, id8, id9;
	private Node node1, node2, node3, node4, node5, node6, node7, node8, node9;
	private LifeStrategy strategy1, strategy2, strategy3;
	
	@Before
	public void setUp() throws Exception {
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
			//Node6
				//Node7
					//Node8
				//Node9
		this.node1 = new Articulation(id1, 15, strategy2);
		this.node2 = new Articulation(id2, 7, strategy1);
		this.node3 = new Articulation(id3, 6, strategy1);
		this.node4 = new Extremity (id4, 4, strategy1);
		this.node5 = new Extremity (id5, 6, strategy1);
		this.node6 = new Articulation (id6, 5, strategy2);
		this.node7 = new Articulation (id7, 6, strategy1);
		this.node8 = new Extremity (id8, 2, strategy2);
		this.node9 = new Extremity (id9, 4, strategy1);
		
	}

	@Test
	public void TestAdd (){
		NodeHandler id10 = new NodeHandler(10);
		Node node10 = new Extremity(id10, 3, strategy1);
		
		assertTrue(nodes.add(node10));
		//assertTrue(node10.add(new Articulation(id1, 15, strategy2)));
		//assertTrue(this.node2.add(new Articulation(id2, 7, strategy2)));
		//assertFalse(this.node1.add(new Articulation(id1,15, strategy2)));
	}
	
	@Test
	public void TestRemove (){
		
		assertTrue(this.node1.remove(new Articulation(id1, 15, strategy2)));
		assertTrue(this.node2.remove(new Articulation(id2, 7, strategy2)));
		assertFalse(this.node1.remove(new Articulation(id1, 15, strategy2)));
	}
	
	@Test
	public void TestSearch (){
	
		assertNotNull(this.node1.search(id1));
		assertNull(this.node5.search(id5));
		
		
	}
	
	@Test
	public void TestToString(){
		assertEquals(this.node1.getId().toString(), "1");

	}
	
	@Test
	public void TestHurt(){
		
		assertEquals(this.node9.hurt(weapon3), 0);
		assertEquals(this.node8.hurt(weapon2), 3);
		
		
		
	}
	
	@Test
	public void TestGetFinalScore(){
		//TODO
	
		
	}
	
	@Test
	public void TestGetLife(){
		
		assertEquals(this.node1.getLife(), 15);
		assertEquals(this.node4.getLife(), 4);
		
	}
	
	@Test
	public void TestSetLife(){
		
		this.node1.setLife(60);
		assertEquals(this.node1.getLife(), 60);
		this.node2.setLife(0);
		assertEquals(this.node2.getLife(),0);
		
	}
	
	@Test
	public void TestSetLifeStrategy(){
		//TODO
		//assertEquals(this.node1.setLifeStrategy(strategy3), 4);
		
		
	}
}
