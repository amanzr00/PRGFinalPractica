package es.unileon.prg2.treegame.strategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.helpers.Weapon;

public class HalfLifeTest {

	private Weapon weapon2, weapon3, weapon4;
	private int life,life3;
	private HalfLife halfLife = new HalfLife();
	@Before
	public void setUp() throws Exception {
		life = 2;
		weapon2 = new Weapon(2);
		weapon3 = new Weapon(10);
		life3 = 3;
		weapon4 = new Weapon(6);
	}

	@Test
	public void testcalculateLife() {
		assertEquals(this.halfLife.calculateLife(life, weapon2), 1);
		assertEquals(this.halfLife.calculateLife(life, weapon3), 0);
		assertEquals(this.halfLife.calculateLife(life3, weapon4), 0);
		
	}
	//PRUEBA
}
