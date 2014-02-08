package es.unileon.prg2.treegame.composite;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.exceptions.InvalidLifeValueException;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.handler.NodeHandler;
import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.DefaultLife;
import es.unileon.prg2.treegame.strategy.LifeStrategy;
import es.unileon.prg2.treegame.strategy.ThresholdLife;

/**
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */
public class ExtremityTest {

	private Handler id2, id1;
	private Node auxExtremity, setupExtremity;
	private LifeStrategy strategy;
	
	@Before
	public void setUp() throws Exception {
		this.id2 = new NodeHandler(2);
		this.id1 = new NodeHandler(1);
	
		this.strategy = new DefaultLife();

		this.setupExtremity = new Extremity(id1, 4, strategy);
		this.auxExtremity = new Extremity(id2, 10, strategy);
	}
	
	@Test
	public void constructorTest(){
		Extremity extremity = new Extremity(this.id2, 5, this.strategy);
		assertNotNull(extremity);
		assertEquals(extremity.getId(), this.id2);
		assertEquals(extremity.getLife(), 5);
	}
	
	@Test(expected = InvalidLifeValueException.class)
	public void constructorExceptionLife(){
		new Extremity(this.id2, -3, this.strategy);
	}
	
	@Test(expected = InvalidLifeValueException.class)
	public void constructorExceptionLifeZero(){
		new Extremity(this.id2, 0, this.strategy);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructorExceptionNullStrategy(){
		new Extremity(this.id2, 5, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructorExceptionNullId(){
		new Extremity(null, 5, strategy);
	}
	
	@Test
	public void addNode(){
		assertFalse(setupExtremity.add(auxExtremity));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addNull(){
		setupExtremity.add(null);
	}
	
	@Test
	public void removeNode(){
		assertFalse(setupExtremity.remove(auxExtremity.search(id2)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void removeNull(){
		setupExtremity.remove(null);
	}
	
	@Test
	public void searchAny(){
		Node node = setupExtremity.search(id2);
		assertNull(node);
	}
	
	@Test
	public void searchFoundSelfNode(){
		assertNotNull(setupExtremity.search(id1));
	}
	
	@Test
	public void toStringTest(){
		assertEquals(setupExtremity.toString(), id1.toString());
		assertEquals(setupExtremity.toString(), "1");
	}
	
	@Test
	public void hurtExtremidadKillExact(){
		Weapon weapon = new Weapon(4);
		assertEquals(setupExtremity.hurt(weapon), 0);
		assertEquals(setupExtremity.getLife(), 0);
	}
	
	@Test
	public void hurtExtremidadKillMoreValue(){
		Weapon weapon = new Weapon(6);
		assertEquals(setupExtremity.hurt(weapon), 2);
		assertEquals(setupExtremity.getLife(), 0);
	}
	
	@Test
	public void hurtExtremidadAlive(){
		//Vida del nodo 10 y arma 5
		Weapon weapon = new Weapon(2);
		assertEquals(setupExtremity.hurt(weapon), 0);
		assertEquals(setupExtremity.getLife(), 2);
	}
	
	@Test
	public void getFinalScoreAlive(){
		assertEquals(setupExtremity.getFinalScore(), 14);
	}
	
	@Test
	public void getFinalScoreHurtDeath(){
		setupExtremity.hurt(new Weapon(2));
		assertEquals(setupExtremity.getFinalScore(), 12);
		assertTrue(setupExtremity.isAlive());
		setupExtremity.hurt(new Weapon(2));
		assertEquals(setupExtremity.getFinalScore(), 0);
		assertFalse(setupExtremity.isAlive());
	}

	@Test
	public void getLife(){
		int life = 5;
		assertEquals(new Extremity(id2, life, strategy).getLife(), life);
	}
	
	@Test(expected = InvalidLifeValueException.class)
	public void setLifeNegative(){
		setupExtremity.setLife(-10);
	}
	
	@Test
	public void setLifeZeroOrPositive(){
		setupExtremity.setLife(0);
		assertEquals(setupExtremity.getLife(), 0);
		setupExtremity.setLife(10);
		assertEquals(setupExtremity.getLife(), 10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setNullLifeStrategy(){
		setupExtremity.setLifeStrategy(null);
	}
	
	@Test
	public void setLifeStrategy(){
		setupExtremity.setLifeStrategy(new ThresholdLife(2));
		setupExtremity.hurt(new Weapon(2));
		assertThat(setupExtremity.getLife(), not(equalTo(2)));
	}
}
