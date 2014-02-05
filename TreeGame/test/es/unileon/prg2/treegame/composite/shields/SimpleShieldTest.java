package es.unileon.prg2.treegame.composite.shields;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.composite.Articulation;
import es.unileon.prg2.treegame.composite.Extremity;
import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.handler.NodeHandler;
import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.DefaultLife;
import es.unileon.prg2.treegame.strategy.LifeStrategy;
import es.unileon.prg2.treegame.strategy.ThresholdLife;

/**
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Diez
 * @author Andrea San Ramon
 * @version 1.0
 */
public class SimpleShieldTest {
	
	private Weapon weapon1, weapon2;
	private Handler id1, id2, id3, id4, id5;
	private Node node1, node2, node3, node4, node5;
	private LifeStrategy strategy1, strategy2;
	private Shield simpleShield1;
	
	@Before
	public void setUp() throws Exception {
		
		this.id1 = new NodeHandler(1);
		this.id2 = new NodeHandler(2);
		this.id3 = new NodeHandler(3);
		this.id4 = new NodeHandler(4);
		this.id5 = new NodeHandler(5);

		this.weapon1 = new Weapon (10);
		this.weapon2 = new Weapon (6);
	
		this.strategy1 = new DefaultLife();
		this.strategy2 = new ThresholdLife(3);
				
		this.node1 = new Articulation(id1, 15, strategy2);
		this.node2 = new Articulation(id2, 7, strategy1);
		this.node3 = new Articulation(id3, 6, strategy1);
		this.node4 = new Extremity (id4, 4, strategy1);
		this.node5 = new Extremity (id5, 6, strategy1);
			
		this.simpleShield1 = new SimpleShield(node4, 10);
		
		//Node1
			//Node2
			//Node3
				//Node4
				//Node5
		
		this.node1.add(node2);
		this.node1.add(node3);
		this.node3.add(node4);
		this.node3.add(node5);
	}

	/**
	 * Test que comprueba el funcionamiento de SimpleShield
	 * Este escudo (SimpleShield), tendra una resistencia, que ira dismuniyendo segun sea el valor del arma con el que se ataca.
	 * Cuando la resistencia llegue a 0, el danio pasara a afectar al nodo.
	 * Devuelve la potencia del arma resultante.
	 */
	@Test
	public void testHurt() {
		
		assertEquals(this.simpleShield1.hurt(weapon2), 0);
		assertEquals(this.simpleShield1.hurt(weapon1), 2);
			
	}
}
