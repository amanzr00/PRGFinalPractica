package es.unileon.prg2.treegame.composite.shields;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.composite.Articulation;
import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

/**
 * @author Alberto Manzano.
 * @author Iván Montes.
 * @author Pablo Diez.
 * @version 1.0
 */
public class SpecialShieldTest {
	private Node node1, node2;
	private LifeStrategy lifeStrategy;
	private Weapon weapon1;
	
	private int numAttacks;
	
	@Before
	public void setUp() throws Exception {
		
		node1 = new Articulation(100, lifeStrategy );
		numAttacks = 3;
		
		weapon1 = new Weapon (8);
		
	}

	@Test
	public void testHurt() {
		
		assertEquals(this.node1.hurt(weapon1), 4);
		assertEquals(this.node1.hurt(weapon1), 2);
		assertEquals(this.node1.hurt(weapon1), 1);
		assertEquals(this.node1.hurt(weapon1), 1);
		
	}	
}
