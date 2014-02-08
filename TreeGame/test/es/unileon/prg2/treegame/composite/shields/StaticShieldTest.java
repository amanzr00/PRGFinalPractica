package es.unileon.prg2.treegame.composite.shields;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.composite.Articulation;
import es.unileon.prg2.treegame.composite.Extremity;
import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.exceptions.InvalidResistanceValueException;
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
 *
 */
public class StaticShieldTest {
	private Weapon weapon1, weapon2;
	private Handler id1, id2, id3, id4, id5;
	private Node node1, node2, node3, node4, node5;
	private LifeStrategy strategy1, strategy2;
	private Shield staticShield1;
	
	@Before
	public void setUp() throws Exception {
		
		this.id1 = new NodeHandler(1);
		this.id2 = new NodeHandler(2);
		this.id3 = new NodeHandler(3);
		this.id4 = new NodeHandler(4);
		this.id5 = new NodeHandler(5);
		
		this.weapon1 = new Weapon (10);
		this.weapon2 = new Weapon (6);

		this.strategy1 = new DefaultLife();
		this.strategy2 = new ThresholdLife(3);
			
		this.node1 = new Articulation(id1, 15, strategy2);
		this.node2 = new Articulation(id2, 7, strategy1);
		this.node3 = new Articulation(id3, 6, strategy1);
		this.node4 = new Extremity (id4, 10, strategy1);
		this.node5 = new Extremity (id5, 6, strategy1);
	
		this.staticShield1 = new StaticShield(node2, 2);
		
		
		//Node1 
			//Node2 (staticShield 2)
			//Node3 (staticShield 4)
				//Node4
				//Node5
		
		this.node1.add(node2);
		this.node1.add(node3);
		this.node3.add(node4);
		this.node3.add(node5);
	}
	
	@Test
	public void constructorTest(){
		StaticShield staticShield = new StaticShield(node1, 2);
		
		assertNotNull(staticShield);
		assertEquals(staticShield.getPrice()/10, 2);
	}
	
	@Test(expected = InvalidResistanceValueException.class)
	public void constructorExceptionNegativeResistance(){
		new StaticShield (node1, -1);
	}
	
	@Test(expected = InvalidResistanceValueException.class)
	public void constructorExceptionZeroResistance(){
		new StaticShield (node1, 0);
	}
	
	@Test
	public void testHurtStaticShield() {
		
		assertEquals(this.staticShield1.hurt(weapon1), 1);
	
		
	}
	
	@Test
	public void nodeIndestructibleWithSpecialShieldToShootBelow10(){
		// node 5 (vida 6) con staticShield de 10
		StaticShield staticShield = new StaticShield(node5, 10);
		// Armas: 5, 10 y 6
		Weapon weapon = new Weapon (5);
	
		assertEquals(staticShield.hurt(weapon), 0);
		assertEquals(staticShield.hurt(weapon1), 0);
		assertEquals(staticShield.hurt(weapon2), 0);
		// todas se agotan. El nodo sigue intacto
		assertEquals(node5.getLife(), 6);
	}
	
	@Test
	public void nodeVunerableToShootAbove10(){
		// node5 (vida 6) con staticShiel de 10
		StaticShield staticShield = new StaticShield(node5, 10);
		// Armas: 11, 20
		Weapon weapon = new Weapon(11);
		Weapon weapon3 = new Weapon(20);
		
		// Ataca al nodo con poder 11-10 = 1 (vida restante del nodo 6-1 = 5)
		assertEquals(staticShield.hurt(weapon), 0);
		// Ataca al nodo con poder 20 - 10 = 10 (vida restante del nodo 0. Muere)
		assertEquals(staticShield.hurt(weapon3), 5);
	}
	
	@Test
	public void testGetPrice(){
		assertEquals(this.staticShield1.getPrice(), 20);
	}
}
