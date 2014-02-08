package es.unileon.prg2.treegame.composite;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.exceptions.InvalidLifeValueException;
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
 * @author Andrea San Ramon
 * @version 1.0
 */
public class ArticulationTest {
	
	private Handler id1, id2, id3, id4, id5, id6, id7, id8;
	private Node node1, node2, node3, node4, node5, node6, node7;
	private LifeStrategy strategy1;
	
	@Before
	public void setUp() throws Exception {
		//Creamos ids
		this.id1 = new NodeHandler(1);
		this.id2 = new NodeHandler(2);
		this.id3 = new NodeHandler(3);
		this.id4 = new NodeHandler(4);
		this.id5 = new NodeHandler(5);
		this.id6 = new NodeHandler(6);
		this.id7 = new NodeHandler(7);
		this.id8 = new NodeHandler(8);
		
		//Creamos estrategia
		this.strategy1 = new DefaultLife();
				
		this.node1 = new Articulation(id1, 15, strategy1);
		this.node2 = new Extremity(id2, 7, strategy1);
		this.node3 = new Articulation(id3, 6, strategy1);
		this.node4 = new Extremity (id4, 4, strategy1);
		this.node5 = new Extremity (id5, 6, strategy1);
		this.node6 = new Articulation (id6, 10, strategy1);
		this.node7 = new Extremity (id7, 10, strategy1);
		
		/* ARBOL */
		// Node1 15 default art
			// Node2 7 default ext
			// Node3 6 default art 
				// Node4 4 default ext
				// Node5 6 default ext
		this.node1.add(node2);
		this.node1.add(node3);
		this.node3.add(node4);
		this.node3.add(node5);
	}
	
	@Test
	public void constructorTest(){
		Articulation articulation = new Articulation(this.id1, 5, this.strategy1);
		assertNotNull(articulation);
		assertEquals(articulation.getId(), this.id1);
		assertEquals(articulation.getLife(), 5);
	}
	
	@Test(expected = InvalidLifeValueException.class)
	public void constructorExceptionLife(){
		new Articulation(this.id1, -3, this.strategy1);
	}
	
	@Test(expected = InvalidLifeValueException.class)
	public void constructorExceptionLifeZero(){
		new Articulation(this.id1, 0, this.strategy1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructorExceptionNullStrategy(){
		new Articulation(this.id1, 5, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructorExceptionNullId(){
		new Articulation(null, 5, strategy1);
	}
	
	@Test
	public void addNode(){
		Articulation articulation = new Articulation(this.id8, 5, strategy1);
		assertTrue(node1.add(articulation));
		assertNotNull(node1.search(id8));
	}
	
	@Test
	public void addNodeTwice(){
		Node articulation = new Articulation(this.id8, 5, strategy1);
		node1.add(articulation);
		assertFalse(node1.add(articulation));
		assertNotNull(node1.search(id8));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addNull(){
		node1.add(null);
	}
	
	@Test
	public void removeNode(){
		assertNotNull(node1.search(id3));
		assertTrue(node1.remove(node1.search(id3)));
		assertNull(node1.search(id3));
	}
	
	@Test
	public void removeNodeTwice(){
		assertNotNull(node1.search(id3));
		Node nodeRemove = node1.search(id3);
		node1.remove(nodeRemove);
		assertFalse(node1.remove(nodeRemove));
		assertNull(node1.search(id3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void removeNull(){
		node1.remove(null);
	}
	
	@Test
	public void searchFoundFirstChildNode(){
		Node node = node1.search(id2);
		assertNotNull(node);
		assertEquals(node.getId(), id2);
	}
	
	@Test
	public void searchFoundDeepChildNode(){
		Node node = node1.search(id5);
		assertNotNull(node);
		assertEquals(node.getId(), id5);
	}
	
	@Test
	public void searchFoundSelfNode(){
		Node node = node1.search(id1);
		assertNotNull(node);
		assertEquals(node, node1);
		assertEquals(node.getId(), id1);
	}
	
	@Test
	public void searchNotFound(){
		assertNull(node1.search(id8));
	}
	
	@Test
	public void toStringTest(){
		assertEquals(node1.toString(), id1.toString());
		assertEquals(node1.toString(), "1");
	}
	
	@Test
	public void hurtArticulationKillNotChildExact(){
		//Vida del nodo y arma 10
		Weapon weapon = new Weapon(10);
		assertEquals(node7.hurt(weapon), 0);
	}
	
	@Test
	public void hurtArticulationKillMoreValueNotChild(){
		//Vida del nodo 10 y arma 15
		Weapon weapon = new Weapon(15);
		assertEquals(node7.hurt(weapon), 5);
	}
	
	@Test
	public void hurtArticulationAliveNotChild(){
		//Vida del nodo 10 y arma 5
		Weapon weapon = new Weapon(5);
		assertEquals(node7.hurt(weapon), 0);
		assertEquals(node7.getLife(), 5);
	}
	
	@Test
	public void hurtArticulationEverybodyAlive(){
		// Node3 6 default art 
			// Node4 4 default ext
			// Node5 6 half ext
		Weapon weapon = new Weapon(3);
		assertEquals(node3.hurt(weapon), 0);
		assertEquals(node3.getLife(), 6);
		assertEquals(node4.getLife(), 1);
		assertEquals(node5.getLife(), 6);
	}
	
	@Test
	public void hurtArticulationChildKillPropagation(){
		// Node3 6 default art 
			// Node4 4 default ext
			// Node5 6 half ext
		Weapon weapon = new Weapon(5);
		assertEquals(node3.hurt(weapon), 0);
		assertEquals(node3.getLife(), 6);
		assertFalse(node4.isAlive());
		assertEquals(node5.getLife(), 5);
	}
	
	@Test
	public void hurtArticulationKillChildren(){
		// Node3 6 default art 
			// Node4 4 default ext
			// Node5 6 half ext
		Weapon weapon = new Weapon(10);
		assertEquals(node3.hurt(weapon), 0);
		assertEquals(node3.getLife(), 6);
		assertFalse(node4.isAlive());
		assertFalse(node5.isAlive());
	}
	
	@Test
	public void hurtArticulationKillChildrenHurtParent(){
		// Node3 6 default art 
			// Node4 4 default ext
			// Node5 6 half ext
		Weapon weapon = new Weapon(12);
		assertEquals(node3.hurt(weapon), 0);
		assertEquals(node3.getLife(), 4);
		assertFalse(node4.isAlive());
		assertFalse(node5.isAlive());
	}
	
	@Test
	public void hurtArticulationKillEverybody(){
		// Node3 6 default art 
			// Node4 4 default ext
			// Node5 6 half ext
		Weapon weapon = new Weapon(16);
		assertEquals(node3.hurt(weapon), 0);
		assertFalse(node3.isAlive());
		assertFalse(node4.isAlive());
		assertFalse(node5.isAlive());
	}
	
	@Test
	public void hurtArticulationKillEverybodyMoreValue(){
		// Node3 6 default art 
			// Node4 4 default ext
			// Node5 6 half ext
		Weapon weapon = new Weapon(18);
		assertEquals(node3.hurt(weapon), 2);
		assertFalse(node3.isAlive());
		assertFalse(node4.isAlive());
		assertFalse(node5.isAlive());
	}
	
	@Test
	public void hurtAndKillDeepLevel(){
		// Node1 15 default art
			// Node2 7 default ext
			// Node3 6 default art 
				// Node4 4 default ext
				// Node5 6 default ext
		Weapon weapon = new Weapon(20);
		assertEquals(node1.hurt(weapon), 0);
		assertEquals(node1.getLife(), 15);
		assertFalse(node2.isAlive());
		assertFalse(node4.isAlive());
		assertFalse(node5.isAlive());
		assertEquals(node3.getLife(), 3);
	}
	
	@Test
	public void getFinalScoreNotChild(){
		//10 vida + 10 por estar vivo
		assertEquals(node6.getFinalScore(), 20);
		node6.hurt(new Weapon(3));
		assertEquals(node6.getFinalScore(), 17);
		node6.hurt(new Weapon(7));
		assertEquals(node6.getFinalScore(), 0);
	}
	
	@Test
	public void getFinalScoreChildren(){
		// Node3 6 default art 
			// Node4 4 default ext
			// Node5 6 default ext
		assertEquals(node3.getFinalScore(), 46);
		node3.hurt(new Weapon(4));
		assertEquals(node3.getFinalScore(), 32);
		node3.hurt(new Weapon(6));
		assertEquals(node3.getFinalScore(), 16);
	}
	
	@Test
	public void getFinalScoreDeepChildren(){
		assertEquals(node1.getFinalScore(), 88);
	}
	
	@Test
	public void getLife(){
		int life = 5;
		assertEquals(new Articulation(id7, life, strategy1).getLife(), life);
	}
	
	@Test(expected = InvalidLifeValueException.class)
	public void setLifeNegative(){
		node1.setLife(-10);
	}
	
	@Test
	public void setLifeZeroOrPositive(){
		node1.setLife(0);
		assertEquals(node1.getLife(), 0);
		node1.setLife(10);
		assertEquals(node1.getLife(), 10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setNullLifeStrategy(){
		node1.setLifeStrategy(null);
	}
	
	@Test
	public void setLifeStrategy(){
		node6.setLifeStrategy(new ThresholdLife(10));
		node6.hurt(new Weapon(2));
		assertThat(node6.getLife(), not(equalTo(8)));
	}
}
