package es.unileon.prg2.treegame.strategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.helpers.Weapon;

/**
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 *
 */
public class DefaultLifeTest {
	
	private Weapon weapon1, weapon2, weapon3;
	private int life1,life2;
	private LifeStrategy strategy1;
	
	@Before
	public void setUp() throws Exception {
		
		this.life1 = 2;
		this.life2 = 3;
		
		this.weapon1 = new Weapon(2);
		this.weapon2 = new Weapon(10);
		this.weapon3 = new Weapon(1);
		
		this.strategy1 = new DefaultLife();
	}

	/**
	 * Test para comprobar que se calcula la vida de manera correcta
	 */
	@Test
	public void testcalculateLife() {
		
		// Vida resultante de atacar con un arma de poder 2 a una vida de 2 : 0.
		assertEquals(this.strategy1.calculateLife(life1, weapon1), 0);
		// Vida resultante de atacar con un arma de poder 10 a una vida de 0: 0.
		assertEquals(this.strategy1.calculateLife(life1, weapon2), 0);
		// Vida resultante de atacar con un arma de poder 1 a una vida de 3: 2.
		assertEquals(this.strategy1.calculateLife(life2, weapon3), 2);
		
	}
	
	/**
	 * Test para comprobar que el coste de esta estrategia es 0 
	 */
	@Test
	public void testgetPrice() {
		
		assertEquals(this.strategy1.getPrice(), 0);
		
	}
}