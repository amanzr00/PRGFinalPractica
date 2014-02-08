package es.unileon.prg2.treegame.helpers;

import es.unileon.prg2.treegame.composite.Articulation;
import es.unileon.prg2.treegame.composite.Extremity;
import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.exceptions.InvalidPowerValueException;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.handler.NodeHandler;
import es.unileon.prg2.treegame.strategy.DefaultLife;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Alberto Manzano
 * @author Ivan Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */
public class WeaponTest {
	private Weapon weapon1, weapon2, weapon3;
	private Handler id1, id2, id3, id4, id5;
	private Node node1, node2, node3, node4, node5;
	private LifeStrategy strategy1;

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

	}
	
	/**
	 * Test del constructor
	 */
    @Test
	public void contructorTest() {
		Weapon weapon = new Weapon(5);
	}
	
    /**
     * Test para que de el error cuando el poder del arma sea negativa
     */
	@Test(expected = InvalidPowerValueException.class)
	public void testSetPowerNegative() {
		weapon2.setPower(-1);
	}

	/**
	 * Test para cambiar el poder del arma
	 */
	@Test
	public void testChangePower() {
		assertEquals(this.weapon1.getPower(), 2);
		this.weapon1.setPower(10);
		assertEquals(this.weapon1.getPower(), 10);
	}
	
	/**
	 * Test para que el poder del arma sea 0 y despues de recarge 
	 */
	@Test
	public void testWeaponToZeroAndReloadWeapon(){
		assertEquals(this.weapon2.getPower(), 4);
		this.node4.hurt(weapon2);
		assertEquals(this.weapon2.getPower(), 0);
		weapon2.setPower(10);
		assertEquals(this.weapon2.getPower(), 10);
	}
	
	/**
	 * Test para que el poder del arma sea 0
	 */
	@Test
	public void testWeaponToZero(){
		assertEquals(this.weapon1.getPower(), 2);
		node5.hurt(weapon1);
		assertEquals(this.weapon1.getPower(), 0);
	}

	/**
	 * Test que dispara y recarga el arma
	 */
	@Test 
	public void testShootAndReloadWeapon(){
		assertEquals(this.weapon3.getPower(), 10);
		node4.hurt(weapon3);
		assertEquals(this.weapon3.getPower(), 6);
		weapon3.setPower(16);
		assertEquals(this.weapon3.getPower(), 16);
	}
	
	/**
	 * Test que permite disparar dos veces porque tiene potencia
	 */
	@Test
	public void testShootandShoot(){
		assertEquals(this.weapon3.getPower(), 10);
		node5.hurt(weapon3);
		assertEquals(this.weapon3.getPower(), 4);
		node1.hurt(weapon3);
		assertEquals(this.weapon3.getPower(), 0);
	}
	
	/**
	 * Test que devuelve el precio del arma
	 */
	@Test
	public void testGetPrice(){
		assertEquals(this.weapon1.getPrice(), 2);
	}
	
	/**
	 * Test que crea el arma y te dice el precio de dicho arma
	 */
	@Test
	public void testCreateWeaponAndGetPrice(){
		Weapon weapon4 = new Weapon(20);
		assertEquals(weapon4.getPrice(), 20);
	}
	
	/**
	 * Test creador de arma, devuelve el precio y su poder, dispara y devuelve su nuevo poder
	 * despues de disparar
	 */
	@Test 
	public void testCreateWeaponGetPriceAndShoot(){
		Weapon weapon5 = new Weapon(5);
		assertEquals(weapon5.getPrice(), 5);
		assertEquals(weapon5.getPower(), 5);
		node4.hurt(weapon5);
		assertEquals(weapon5.getPower(), 1);		
	}
	
	/**
	 * Test para crear un arma, matar el arbol entero y que tenga energia
	 */
	@Test
	public void testCreateWeaponKillTreeAndHavePower(){
		Weapon weapon6 = new Weapon(100);
		assertEquals(weapon6.getPrice(), 100);
		assertEquals(weapon6.getPower(), 100);
		assertEquals(this.node1.getFinalScore(), 88);
		node1.hurt(weapon6);
		assertEquals(this.node1.getFinalScore(), 0);
		assertEquals(weapon6.getPower(), 624);
	}
	
}
