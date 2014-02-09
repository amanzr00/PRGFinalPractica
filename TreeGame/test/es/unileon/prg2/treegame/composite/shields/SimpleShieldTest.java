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
 * Test de la clase SimpleShield
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Diez
 * @author Andrea San Ramon
 * @version 1.0
 */
public class SimpleShieldTest {
	
	private Weapon weapon1, weapon2;
	private Handler id1, id2, id3, id4, id5;
	private Node node1, node2, node3, node4, node5;
	private LifeStrategy strategy1, strategy2;
	private Shield simpleShield1;
	private int resistance1;
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
		this.node4 = new Extremity (id4, 4, strategy1);
		this.node5 = new Extremity (id5, 6, strategy1);
			
		this.simpleShield1 = new SimpleShield(node4, 10);
		
		this.resistance1 = 10;
		
		//Node1
			//Node2
			//Node3
				//Node4 (Con simpleShield1: 10)
				//Node5
		
		this.node1.add(node2);
		this.node1.add(node3);
		this.node3.add(node4);
		this.node3.add(node5);
	}

	/**
	 * Test del constructor
	 */
	@Test
	public void constructorTest(){
		
		SimpleShield simpleShield = new SimpleShield(this.node1, this.resistance1);
		
		assertNotNull(simpleShield);
		assertEquals(node1.getId(), this.id1);
		assertEquals(this.resistance1, 10);
	}

	/**
	 * Test fallido del constructor
	 */
	@Test
	public void failConstructorTest(){
		
		SimpleShield simpleShield = null;
		assertNull(simpleShield);
	}
	
	/**
	 * Test para comprobar que no se puede establecer una resistencia negativa
	 */
	@Test(expected = InvalidResistanceValueException.class)
	public void constructorExceptionNegativeResistance(){
		new SimpleShield(node1, -3);
	}
	
	/**
	 * Test para comprobar que no se puede establecer una resistencia igual a 0
	 */
	@Test(expected = InvalidResistanceValueException.class)
	public void constructorExceptionZeroResistance(){
		new SimpleShield(node1, 0);
	}
	
	/**
	 * Test para comprobar que el danio tras un ataque es correctamente actualizado
	 */
	@Test
	public void destructionOfSimpleShieldTwoShoots(){
		// Atacamos simpleShield1 (resistencia 10) con weapon2 (poder 6). Poder resultante del arma: 0
		assertEquals(this.simpleShield1.hurt(weapon2), 0);
		// Volvemos a atacar a simpleShield1 (Ahora resistencia = 4) con weapon1 (poder 10).
		// Llega atacar al node4 (vida 4) y muere. Poder resultante del arma: 2.
		assertEquals(this.simpleShield1.hurt(weapon1), 2);
	}
	
	/**
	 * Test para comprobar que el danio tras un ataque es correctamente actualizado
	 */
	@Test
	public void hurtSimpleShield(){
		SimpleShield simpleShield = new SimpleShield(this.node2, 5);
		Weapon weapon = new Weapon (2);
		
		assertEquals(simpleShield.hurt(weapon), 0);
			
	}
	
	/**
	 * Test para comprobar que el precio del escudo es igual a su resistencia
	 */
	@Test
	public void getPriceTest() {
		
		assertEquals(simpleShield1.getPrice(), this.resistance1);
		
		SimpleShield simpleShield2 = new SimpleShield(this.node3, 5);
		assertEquals(simpleShield2.getPrice(), 5);
	}

	
}
