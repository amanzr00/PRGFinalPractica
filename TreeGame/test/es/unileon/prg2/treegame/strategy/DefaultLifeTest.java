package es.unileon.prg2.treegame.strategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.helpers.Weapon;

/**
 * @author Alberto Manzano.
 * @author Iván Montes.
 * @author Pablo Díez.
 * @author Andrea San Ramon
 *
 */
public class DefaultLifeTest {
	
	private Weapon weapon2, weapon3, weapon4;
	private int life1,life2;
	private DefaultLife defaultLife = new DefaultLife();
	
	@Before
	public void setUp() throws Exception {
		
		life1 = 2;
		life2 = 3;
		
		weapon2 = new Weapon(2);
		weapon3 = new Weapon(10);
		weapon4 = new Weapon(1);
	}

	/**
	 * Test para comprobar que se calcula la vida de manera correcta
	 */
	@Test
	public void testcalculateLife() {
		
		// Vida resultante de atacar con un arma de poder 2 a una vida de 2 : 0.
		assertEquals(this.defaultLife.calculateLife(life1, weapon2), 0);
		// Vida resultante de atacar con un arma de poder 10 a una vida de 0: 0.
		assertEquals(this.defaultLife.calculateLife(life1, weapon3), 0);
		// Vida resultante de atacar con un arma de poder 1 a una vida de 3: 2.
		assertEquals(this.defaultLife.calculateLife(life2, weapon4), 2);
		
	}
}