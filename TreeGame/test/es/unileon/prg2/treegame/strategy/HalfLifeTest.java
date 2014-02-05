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
 */

public class HalfLifeTest {

	private Weapon weapon2, weapon3, weapon4;
	private int life1,life2;
	private HalfLife halfLife = new HalfLife();
	@Before
	public void setUp() throws Exception {
		
		life1 = 2;
		life2 = 3;
		
		weapon2 = new Weapon(2);
		weapon3 = new Weapon(10);
		weapon4 = new Weapon(6);
	}

	/**
	 * Test para comprobar que se calcula correctamente la vida, habiendose reducido a la mitad el poder del arma atacante
	 */
	@Test
	public void testcalculateLife() {
		// Atacamos a una vida de 2 con un arma de poder 2. Ataca a la vida con 1. Vida restante 2-1 = 1
		assertEquals(this.halfLife.calculateLife(life1, weapon2), 1);
		// Atacamos a una vida de 1, con un arma de 10. Ataca con 5. Vida restante 1 - 1 = 0.
		assertEquals(this.halfLife.calculateLife(life1, weapon3), 0);
		// Atacamos a una vida de 3 con un arma de 6. ataca con 3. Vida restante 3 - 3 = 0. 
		assertEquals(this.halfLife.calculateLife(life2, weapon4), 0);
		
	}
	//PRUEBA2
}
