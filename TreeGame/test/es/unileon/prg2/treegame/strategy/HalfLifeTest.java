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
 */

public class HalfLifeTest {

	private Weapon weapon1, weapon2, weapon3;
	private int life1,life2;
	private HalfLife strategy; 
	
	@Before
	public void setUp() throws Exception {
		
		this.life1 = 2;
		this.life2 = 3;
		
		this.weapon1 = new Weapon(2);
		this.weapon2 = new Weapon(10);
		this.weapon3 = new Weapon(6);
		
		this.strategy = new HalfLife(this.life1);
		
	}
	
	/**
	 * Test para el constructor
	 */
	@Test
	public void constructorTest() {
	
		HalfLife halfLife = new HalfLife(this.life1);
		assertNotNull(halfLife);
		assertEquals(this.life1, 2);
		
	}

	/**
	 * Test para comprobar que se calcula correctamente la vida, habiendose reducido a la mitad el poder del arma atacante
	 */
	@Test
	public void testcalculateLife() {
		// Atacamos a una vida de 2 con un arma de poder 2. Ataca a la vida con 1. Vida restante 2-1 = 1
		assertEquals(this.strategy.calculateLife(life1, weapon1), 1);
		// Atacamos a una vida de 1, con un arma de 10. Ataca con 5. Vida restante 1 - 1 = 0.
		assertEquals(this.strategy.calculateLife(life1, weapon2), 0);
		// Atacamos a una vida de 3 con un arma de 6. ataca con 3. Vida restante 3 - 3 = 0. 
		assertEquals(this.strategy.calculateLife(life2, weapon3), 0);
		
	}
	
	/**
	 * Test para comprobar que el coste de la estrategia es igual a la vida del nodo multiplicada por 2
	 */ 
	@Test
	public void testGetPrice() {
		
		assertEquals(this.strategy.getPrice(), 4 );
		
	}
}
