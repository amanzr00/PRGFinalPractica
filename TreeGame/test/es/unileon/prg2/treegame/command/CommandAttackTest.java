package es.unileon.prg2.treegame.command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import es.unileon.prg2.treegame.composite.Articulation;
import es.unileon.prg2.treegame.composite.Extremity;
import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.exceptions.InvalidCreditValueException;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.handler.NodeHandler;
import es.unileon.prg2.treegame.helpers.Credit;
import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.DefaultLife;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

public class CommandAttackTest {

	private Weapon weapon1, weapon3;
	private Node node1, node2, nodeTarget;
	private Credit credit, credit2;
	private Handler id1, id2, id3;
	private LifeStrategy lifeStrategy;
	
	@Before
	public void setUp() throws Exception{
		
		this.id1 = new NodeHandler(1);
		this.id2 = new NodeHandler(2);
		
		this.lifeStrategy =  new DefaultLife();
		
		this.node1 = new Articulation(id1, 5, lifeStrategy);
		this.node2 = new Extremity(id2, 10, lifeStrategy);
				
		/* Arbol */
		// node 1
			//node 2
		this.node1.add(node2);
		
		this.weapon1 = new Weapon(5);
		this.weapon3 = new Weapon(15);
		
		this.credit = new Credit (50);
		this.credit2 = new Credit (10);
	}
	
	/**
	 * Test para el constructor
	 */
	@Test
	public void constructorTest(){
		//node1
			//node2
			//node3
		this.id3 = new NodeHandler(3);
		this.nodeTarget = new Extremity(id3, 5, lifeStrategy);
		CommandAttack newAttack = new CommandAttack (node1, weapon1, nodeTarget, credit);
		
		assertNotNull(newAttack);
		
	}
	
	/**
	 * Test que comprueba que salta una excepcion si se intenta atacar un nodo que no existe
	 */
	@Test(expected = IllegalArgumentException.class)
	public void nodeNoExistTest(){
		// node 1
			// node 2 
		this.nodeTarget = new Extremity(id3, 10, lifeStrategy);
		CommandAttack newAttack = new CommandAttack (node1, weapon1, nodeTarget, credit);
		newAttack.execute();
	}
	
	/**
	 * Test que comprueba el ataque al nodo
	 */
	@Test
	public void attackExistNode(){
		CommandAttack newAttack = new CommandAttack (node1, weapon1, node2, credit);
		
		newAttack.execute();
		
		assertEquals(node2.getLife(), 5);
		assertEquals(credit.getCredit(), 45);
		
	}
	
	/**
	 * Test que comprueba que salta una excepcion si se compra un arma con un valor superior al credito total
	 */
	@Test(expected = InvalidCreditValueException.class)
	public void priceGreatestWeaponThatCredit(){
		CommandAttack newAttack = new CommandAttack (node1, weapon3, node2, credit2);
		newAttack.execute();
	}
}