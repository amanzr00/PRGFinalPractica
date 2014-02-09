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
 * Test de la clase SpecialShieldTest
 * @author Alberto Manzano.
 * @author Iván Montes.
 * @author Pablo Diez.
 * @author Andrea San Ramon.
 */

public class SpecialShieldTest {
	
	private Weapon weapon1, weapon2;
	private Handler id1, id2, id3, id4, id5;
	private Node node1, node2, node3, node4, node5;
	private LifeStrategy strategy1, strategy2;
	private Shield specialShield1;
	private int numAttacks1;

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
		
		this.specialShield1 = new SpecialShield(node5, 1);
		
		this.numAttacks1 = 3;
		/* ARBOL */
		//Node1
			//Node2
			//Node3
				//Node4
				//Node5 (Con specialShiel1: 1)
		
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
		
		SpecialShield specialShield = new SpecialShield(this.node1, this.numAttacks1);
		assertNotNull(specialShield);
	}
	
	/**
	 * Test fallido del constructor
	 */
	@Test
	public void failConstructorTest(){
		
		SpecialShield specialShield = null;
		assertNull(specialShield);
	}
	
	/**
	 * Test para comprobar que no se puede establecer un numero de ataques negativo
	 */
	@Test(expected = InvalidResistanceValueException.class)
	public void constructorExceptionNegativeResistance(){
		new SpecialShield(node1, -3);
	}
	
	/**
	 * Test para comprobar que no se puede establecer un numero de ataques igual a 0
	 */
	@Test(expected = InvalidResistanceValueException.class)
	public void constructorExceptionZeroResistance(){
		new SimpleShield(node1, 0);
	}
	
	/**
	 * Test para comprobar que el danio tras un ataque es correctamente actualizado
	 */
	@Test
	public void destructionOfSpecialShieldTwoShoots() {
		
		// Atacamos a specialShield1 (resiste 1 ataque) con weapon1 (poder 10). El arma ataca al nodo5 (vida 6) con la mitad del poder
		// Poder restante: 0
		assertEquals(this.specialShield1.hurt(weapon1), 0);
		// Volvemos a atacar al node5 (vida restante: 1) que ya no tiene escudo, con weapon2 (poder 6). Poder restante: 5
		assertEquals(this.specialShield1.hurt(weapon2), 5);
	}	
	
	/**
	 * Test para comprobar que el danio tras un ataque es correctamente actualizado
	 */
	@Test
	public void hurtSpecialShiedlTest(){
		
		assertEquals(this.node5.hurt(weapon2), 0);
	}
	
	/**
	 * Test para comprobar que el precio del escudo es el numero de impactos multiplicado por 10
	 */
	@Test
	public void getPriceTest(){
		assertEquals(specialShield1.getPrice(), 10);
	}
}
