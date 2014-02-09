package es.unileon.prg2.treegame.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.helpers.Weapon;

/**
 * Test de la clase ThresholdLife
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 */
public class ThresholdLifeTest {
	
	private ThresholdLife strategy;
	private int life1, life2, life3;
	private Weapon weapon1, weapon2, weapon3;
	private int threshold;
	
	@Before
	public void setUp() throws Exception {
		
		this.life1 = 15;
		this.weapon1 = new Weapon(5);
		this.life2 = 20;
		this.weapon2 = new Weapon(15);
		this.life3 = 5;
		this.weapon3 = new Weapon(15);
		this.threshold = 5;
		
		this.strategy = new ThresholdLife (this.threshold);
		
	}
	
	/**
	 * Test para el constructor
	 */
	public void constructorTest() {
		
		ThresholdLife thresholdLife = new ThresholdLife(this.threshold);
		assertNotNull(thresholdLife);
		assertEquals(this.threshold, 5);
	}
	
	/**
	 * Test para comprobar que se calcula correctamente la vida
	 */
	@Test
	public void testcalculateLife() {
		assertEquals(this.strategy.calculateLife(life1, weapon1), 15);
		assertEquals(this.strategy.calculateLife(life2, weapon2), 10);
		assertEquals(this.strategy.calculateLife(life3, weapon3), 0);
		
	}
	
	/**
	 * Test para comprobar que el coste de esta estrategia es igual al umbral asignado
	 */
	@Test
	public void testgetPrice() {
		
		assertEquals(this.strategy.getPrice(), 5);
		
	}
	
	
}
