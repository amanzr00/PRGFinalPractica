package es.unileon.prg2.treegame.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.helpers.Weapon;

/**
 * @author Alberto Manzano.
 * @author Iván Montes.
 * @author Pablo Díez.
 * @author Andrea San Ramon
 */
public class ThresholdLifeTest {
	private ThresholdLife thresHold = new ThresholdLife(5);
	private int life1, life2, life3;
	private Weapon weapon1, weapon2, weapon3;
	
	@Before
	public void setUp() throws Exception {
		life1 = 15;
		weapon1 = new Weapon(5);
		life2 = 20;
		weapon2 = new Weapon(15);
		life3 = 5;
		weapon3 = new Weapon(15);
	}
	
	@Test
	public void testcalculateLife() {
		assertEquals(this.thresHold.calculateLife(life1, weapon1), 15);
		assertEquals(this.thresHold.calculateLife(life2, weapon2), 10);
		assertEquals(this.thresHold.calculateLife(life3, weapon3), 0);
		
	}
}
