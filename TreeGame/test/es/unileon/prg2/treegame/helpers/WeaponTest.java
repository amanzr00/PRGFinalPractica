package es.unileon.prg2.treegame.helpers;

import es.unileon.prg2.treegame.exceptions.InvalidPowerValueException;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Alberto Manzano
 * @author Ivan Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */
public class WeaponTest {
	private Weapon weapon1, weapon2;
	@Before
	public void setUp() throws Exception {
		
		weapon1 = new Weapon(2);
		weapon2 = new Weapon(4);
		
	}	

	/**
	 * Test para comprobar el funcionamiento correcto del set y del get para el poder del arma (Weapon)
	 */
	@Test
	public void testGetAndSetPower() {
		
		// La potencia establecia de weapon1 es: 2
		assertEquals(this.weapon1.getPower(), 2);
		// Cambiamos la potencia a: 10
		this.weapon1.setPower(10);
		// Comprobamos que correctamente es 10
		assertEquals(this.weapon1.getPower(), 10);
		
	}
	/**
	 * Test para comprobar que salta la excepcion "InvalidPowerValueException"
	 * La excepcion salta cuando se intenta establecer a un arma, un poder negativo
	 */
	@Test(expected = InvalidPowerValueException.class)
	public void testSetPowerNegative(){
		// Establecemos un poder negativo (-1)
		weapon2.setPower(-1);
	}
	
}
