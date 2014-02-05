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
 * @author Iván Montes
 * @author Pablo Díez
 * @version 1.0
 */
public class ExtremityTest {
	private ArrayList<Node> nodes;
	private Weapon weapon1, weapon2, weapon3, weapon4;
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

		this.node1.add(node2);
		this.node1.add(node3);
		this.node3.add(node4);
		this.node3.add(node5);
	
	}

	@Test
	public void TestAdd (){
		this.id6 = new NodeHandler(6);
		this.node6 = new Extremity (id6, 5, strategy2);
		
		assertTrue(this.node2.add(node6));
		assertFalse(this.node4.add(node6));
		
		
	}
	
	@Test
	public void TestRemove (){
		this.id6 = new NodeHandler(6);
		this.node6 = new Extremity (id6, 5, strategy2);
		
		assertTrue(this.node3.remove(node4));
		assertFalse(this.node3.remove(node6));
		
	}
	
	@Test
	public void TestSearch (){
		this.id6 = new NodeHandler(6);
		this.node6 = new Extremity (id6, 5, strategy2);
		
		assertNotNull(this.node4.search(id4));
		assertNull(this.node4.search(id6));

	}
	
	@Test
	public void TestToString(){
				
		assertEquals(this.node4.getId().toString(), "4");

	}
	
	@Test
	public void TestHurt(){
		
		assertEquals(this.node4.hurt(weapon1), 6);
		assertEquals(this.node5.hurt(weapon2), 0);
		
		
	}
	
	@Test
	public void TestGetFinalScore(){
		
		assertEquals(this.node4.getFinalScore(), 14);
		
	}
	
	@Test
	public void TestSetAndGetLife(){
		node4.setLife(4);
		assertEquals(this.node4.getLife(), 4);
		//assertEquals(this.articulation1.getLife(), 50);
	}
	
	
	
	@Test
	public void TestSetLifeStrategy(){
		
		/*
		 * Implementar
		 */
		
	}
}
