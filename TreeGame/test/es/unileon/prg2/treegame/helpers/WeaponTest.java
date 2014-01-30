package es.unileon.prg2.treegame.helpers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Alberto Manzano.
 * @author Ivan Montes.
 * @author Pablo Díez.
 * @version 1.0
 */
public class WeaponTest {
	private Weapon weapon2, weapon3, weapon4;
	@Before
	public void setUp() throws Exception {
		weapon2 = new Weapon(2);
		weapon3 = new Weapon(3);
		weapon4 = new Weapon(4);
		
	}	

	@Test
	public void testGetPower() {
		assertEquals(this.weapon2.getPower(), 2);
		assertEquals(this.weapon3.getPower(), 3);
		assertEquals(this.weapon4.getPower(), 4);
		
	}
}
