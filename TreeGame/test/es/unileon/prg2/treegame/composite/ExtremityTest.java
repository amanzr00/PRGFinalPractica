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
	
		assertTrue(this.node5.add(new Extremity(id5, 6, strategy1)));
		assertFalse(this.node5.add(new Extremity(id5, 6, strategy1)));
		assertTrue(this.node8.add(new Extremity(id8, 2, strategy2)));
		
	}
	
	@Test
	public void TestRemove (){
		
		assertTrue(this.node5.add(new Extremity(id5, 6, strategy1)));
		assertFalse(this.node5.add(new Extremity(id5, 6, strategy1)));
		assertTrue(this.node8.add(new Extremity(id8, 2, strategy2)));

	}
	
	@Test
	public void TestSearch (){
	
		

	}
	
	@Test
	public void TestToString(){
				
		//assertEquals(this.root.toString(),"1\nnull\nnull\n");

	}
	
	@Test
	public void TestHurt(){
		
		//assertEquals(this.root.hurt(weapon1), 10);
		//assertEquals(this.articulation1.hurt(weapon2), 2);
		
		
	}
	
	@Test
	public void TestGetFinalScore(){
		
		//assertEquals(this.life, 120 );
		
	}
	
	@Test
	public void TestGetLife(){
		
		//assertEquals(this.root.getLife(), 50);
		//assertEquals(this.articulation1.getLife(), 50);
	}
	
	@Test
	public void TestSetLife(){
		
		//this.root.setLife(60);
		//assertEquals(this.root.getLife(), 60);
		
	}
	
	@Test
	public void TestSetLifeStrategy(){
		
		/*
		 * Implementar
		 */
		
	}
}
