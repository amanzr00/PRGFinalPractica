package es.unileon.prg2.treegame.strategy;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.helpers.Weapon;

/**
 * @author Alberto Manzano.
 * @author Iván Montes.
 * @author Pablo Díez.
 *
 */
public class DefaultLifeTest {
	private Weapon weapon2;
	int life;
	@Before
	public void setUp() throws Exception {
		life = 2;
		weapon2 = new Weapon(2);
	}

	@Test
	public void testcalculateLife() {
	
		
	}
}