package es.unileon.prg2.treegame.strategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.helpers.Weapon;

/**
 * @author Alberto Manzano.
 * @author Iv�n Montes.
 * @author Pablo D�ez.
 *
 */
public class DefaultLifeTest {
	private Weapon weapon2, weapon3, weapon4;
	private int life,life3;
	private DefaultLife defaultLife = new DefaultLife();
	@Before
	public void setUp() throws Exception {
		life = 2;
		weapon2 = new Weapon(2);
		weapon3 = new Weapon(10);
		life3 = 3;
		weapon4 = new Weapon(1);
	}

	@Test
	public void testcalculateLife() {
		assertEquals(this.defaultLife.calculateLife(life, weapon2), 0);
		assertEquals(this.defaultLife.calculateLife(life, weapon3), 0);
		assertEquals(this.defaultLife.calculateLife(life3, weapon4), 2);
		
	}
}