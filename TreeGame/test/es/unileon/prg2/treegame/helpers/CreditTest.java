package es.unileon.prg2.treegame.helpers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.composite.Articulation;
import es.unileon.prg2.treegame.composite.Extremity;
import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.composite.shields.Shield;
import es.unileon.prg2.treegame.composite.shields.SpecialShield;
import es.unileon.prg2.treegame.exceptions.InvalidCreditValueException;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.handler.NodeHandler;
import es.unileon.prg2.treegame.strategy.DefaultLife;
import es.unileon.prg2.treegame.strategy.HalfLife;
import es.unileon.prg2.treegame.strategy.LifeStrategy;
import es.unileon.prg2.treegame.strategy.ThresholdLife;

/**
 * Test de la clase Credit
 * @author Alberto Manzano
 * @author Ivan Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */

public class CreditTest {
	private Weapon weapon1, weapon2, weapon3;
	private Handler id1, id2, id3, id4, id5;
	private Node node1, node2, node3, node4, node5;
	private LifeStrategy strategy1;
	private Credit credit1;

	@Before
	public void setUp() throws Exception {
		// Creamos ids
		this.id1 = new NodeHandler(1);
		this.id2 = new NodeHandler(2);
		this.id3 = new NodeHandler(3);
		this.id4 = new NodeHandler(4);
		this.id5 = new NodeHandler(5);

		// Creamos estrategia
		this.strategy1 = new DefaultLife();

		this.node1 = new Articulation(id1, 15, strategy1);
		this.node2 = new Extremity(id2, 7, strategy1);
		this.node3 = new Articulation(id3, 6, strategy1);
		this.node4 = new Extremity(id4, 4, strategy1);
		this.node5 = new Extremity(id5, 6, strategy1);

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

		weapon1 = new Weapon(2);
		weapon2 = new Weapon(4);
		weapon3 = new Weapon(10);

		credit1 = new Credit(100);

	}

	/**
	 * Test del constructor
	 */
	@Test
	public void testConstructor() {
		Credit credit = new Credit(120);
		assertNotNull(credit);
		assertEquals(credit.getCredit(), 120);
	}

	/**
	 * Test que devuelve el credito que tengo
	 */
	@Test
	public void testGetCredit() {
		assertEquals(this.credit1.getCredit(), 100);
	}

	/**
	 * Test cuando se compra un objeto
	 */
	@Test
	public void testBuyObject() {
		this.credit1.buyObject(this.weapon3);
		assertEquals(this.credit1.getCredit(), 90);				
	}
	
	/**
	 * Test gastar todo el credito 
	 */
	@Test
	public void testSpendSomeCredit(){
		this.credit1.buyObject(this.weapon3);
		this.credit1.buyObject(this.node1);
		this.credit1.buyObject(this.node2);
		this.credit1.buyObject(this.node3);
		this.credit1.buyObject(this.node4);
		this.credit1.buyObject(this.node5);
		this.credit1.buyObject(this.weapon2);
		this.credit1.buyObject(this.weapon3);
		assertEquals(this.credit1.getCredit(), 38);
	}
	
	/**
	 * Test para gastar todo el credito
	 */
	@Test
	public void testSpendAllCredit(){
		assertEquals(this.credit1.getCredit(), 100);
		this.credit1.buyObject(this.node1);
		this.credit1.buyObject(this.node2);
		this.credit1.buyObject(this.node3);
		this.credit1.buyObject(this.node4);
		this.credit1.buyObject(this.node5);
		this.credit1.buyObject(this.weapon1);
		this.credit1.buyObject(this.weapon2);
		this.credit1.buyObject(this.weapon3);
		Weapon weapon4 = new Weapon(15);
		this.credit1.buyObject(weapon4);
		Handler id6 = new NodeHandler(6);
		Node node6 = new Extremity(id6, 10, strategy1);
		this.credit1.buyObject(node6);
		Shield specialshield1 = new SpecialShield(node5, 1); 
		this.credit1.buyObject(specialshield1);
		Weapon weapon5 = new Weapon(11);
		this.credit1.buyObject(weapon5);
		assertEquals(this.credit1.getCredit(), 0);		
	}
	
	/**
	 * Test para comprobar que no se puede crear un arma que tenga un valor mayor al credito total
	 */
	@Test(expected = InvalidCreditValueException.class)
	public void testWeaponGreaterThanCredit(){
		Credit credit2 = new Credit(2);
		credit2.buyObject(weapon3);
	}
	
	/**
	 * Test para comprobar que no se puede crear una articulacion que tenga un valor mayor al credito total
	 */
	@Test(expected = InvalidCreditValueException.class)
	public void testArticulationGreaterThanCredit(){
		Credit credit2 = new Credit(2);
		credit2.buyObject(node1);
	}
	
	/**
	 * Test para comprobar que no se puede crear una extremidad que tenga un valor mayor al credito total
	 */
	@Test(expected = InvalidCreditValueException.class)
	public void testExtremityGreaterThanCredit(){
		Credit credit2 = new Credit(2);
		credit2.buyObject(node5);
	}
	
	/**
	 * Test para comprobar que no se puede asignar un escudo que tenga un valor mayor al credito total
	 */
	@Test(expected = InvalidCreditValueException.class)
	public void testShieldGreaterThanCredit(){
		Credit credit2 = new Credit(2);
		Shield specialshield1 = new SpecialShield(node5, 1); 
		this.credit1.buyObject(specialshield1);
		credit2.buyObject(specialshield1);
	}
	
	/**
	 * Test para comprobar que no se puede asignar una estrategia HalfLife que tenga un valor mayor al credito total
	 */
	@Test(expected = InvalidCreditValueException.class)
	public void testHalfLifeGreaterThanCredit(){
		Credit credit2 = new Credit(2);
		int life = 5;
		LifeStrategy halflife1 = new HalfLife(life);
		credit2.buyObject(halflife1);
	}
	
	/**
	 * Test para comprobar que no se puede asignar una estrategia ThresholdLife que tenga un valor mayor al credito total
	 */
	@Test(expected = InvalidCreditValueException.class)
	public void testThresholdLifeGreaterThanCredit(){
		Credit credit2 = new Credit(2);
		int threshold = 5 ;
		LifeStrategy thresholdlife = new ThresholdLife(threshold);
		credit2.buyObject(thresholdlife);
	}
}