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
	
	/**
	 * Test del constructor
	 */
	@Test
	public void constructorTest(){
		Extremity extremity = new Extremity(this.id2, 5, this.strategy);
		assertNotNull(extremity);
		assertEquals(extremity.getId(), this.id2);
		assertEquals(extremity.getLife(), 5);
	}

	/**
	 * Test para comprobar que no se puede establecer una vida negativa
	 */
	@Test(expected = InvalidLifeValueException.class)
	public void constructorExceptionLife(){
		new Extremity(this.id2, -3, this.strategy);
	}

	/**
	 * Test para comprobar que no se puede establecer una vida igual a 0
	 */
	@Test(expected = InvalidLifeValueException.class)
	public void constructorExceptionLifeZero(){
		new Extremity(this.id2, 0, this.strategy);
	}

	/**
	 * Test para comprobar que no se puede establecer una estrategia nula
	 */
	@Test(expected = IllegalArgumentException.class)
	public void constructorExceptionNullStrategy(){
		new Extremity(this.id2, 5, null);
	}

	/**
	 * Test para comprobar que no se puede establecer un nodo nulo
	 */
	@Test(expected = IllegalArgumentException.class)
	public void constructorExceptionNullId(){
		new Extremity(null, 5, strategy);
	}

	/**
	 * Test para comprobar que se agregan bien los nodos
	 */
	@Test
	public void addNode(){
		assertFalse(setupExtremity.add(auxExtremity));
	}

	/**
	 * Test para comprobar que no se puede agregar un nodo nulo
	 */
	@Test(expected = IllegalArgumentException.class)
	public void addNull(){
		setupExtremity.add(null);
	}

	/**
	 * Test para comprobar que se eliminan bien los nodos
	 */
	@Test
	public void removeNode(){
		assertFalse(setupExtremity.remove(auxExtremity.search(id2)));
	}

	/**
	 * Test para comprobar que no se puede eliminar un nodo nulo
	 */
	@Test(expected = IllegalArgumentException.class)
	public void removeNull(){
		setupExtremity.remove(null);
	}

	/**
	 * Test para buscar un nodo nulo, que no exista en el arbol
	 */
	@Test
	public void searchAny(){
		Node node = setupExtremity.search(id2);
		assertNull(node);
	}
	
	/**
	 * Test para buscar el nodo que esta en el arbol
	 */
	@Test
	public void searchFoundSelfNode(){
		assertNotNull(setupExtremity.search(id1));
	}

	/**
	 * Test para comprobar que convierte el id a String de forma correcta
	 */
	@Test
	public void toStringTest(){
		assertEquals(setupExtremity.toString(), id1.toString());
		assertEquals(setupExtremity.toString(), "1");
	}

	/**
	 * Test que mata al nodo, quedando su vida a 0, y quedando la potencia del
	 * arma en 0
	 */
	@Test
	public void hurtExtremidadKillExact(){
		Weapon weapon = new Weapon(4);
		assertEquals(setupExtremity.hurt(weapon), 0);
		assertEquals(setupExtremity.getLife(), 0);
	}

	/**
	 * Test que mata al nodo y el arma queda con energia
	 */
	@Test
	public void hurtExtremidadKillMoreValue(){
		Weapon weapon = new Weapon(6);
		assertEquals(setupExtremity.hurt(weapon), 2);
		assertEquals(setupExtremity.getLife(), 0);
	}

	/**
	 * Test que ataca al nodo y queda con vida
	 */
	@Test
	public void hurtExtremidadAlive(){
		//Vida del nodo 10 y arma 5
		Weapon weapon = new Weapon(2);
		assertEquals(setupExtremity.hurt(weapon), 0);
		assertEquals(setupExtremity.getLife(), 2);
	}

	/**
	 * Test para comprobar que la puntuacion final es correcta
	 */
	@Test
	public void getFinalScoreAlive(){
		assertEquals(setupExtremity.getFinalScore(), 14);
	}

	/**
	 * Test para que muera la extremidad
	 */
	@Test
	public void getFinalScoreHurtDeath(){
		setupExtremity.hurt(new Weapon(2));
		assertEquals(setupExtremity.getFinalScore(), 12);
		assertTrue(setupExtremity.isAlive());
		setupExtremity.hurt(new Weapon(2));
		assertEquals(setupExtremity.getFinalScore(), 0);
		assertFalse(setupExtremity.isAlive());
	}

	/**
	 * Test para comprobar que obtiene la vida de forma correcta
	 */
	@Test
	public void getLife(){
		int life = 5;
		assertEquals(new Extremity(id2, life, strategy).getLife(), life);
	}

	/**
	 * Test para comprobar que no se puede establecer una vida negativa
	 */
	@Test(expected = InvalidLifeValueException.class)
	public void setLifeNegative(){
		setupExtremity.setLife(-10);
	}

	/**
	 * Test para comprobar que se establece de manera correcta la vida igual o
	 * mayor que 0
	 */
	@Test
	public void setLifeZeroOrPositive(){
		setupExtremity.setLife(0);
		assertEquals(setupExtremity.getLife(), 0);
		setupExtremity.setLife(10);
		assertEquals(setupExtremity.getLife(), 10);
	}

	/**
	 * Test para comprobar que no se puede estrablecer una estrategia negativa
	 */
	@Test(expected = IllegalArgumentException.class)
	public void setNullLifeStrategy(){
		setupExtremity.setLifeStrategy(null);
	}

	/**
	 * Test para comprobar que establece la estrategia de forma correcta
	 */
	@Test
	public void setLifeStrategy(){
		setupExtremity.setLifeStrategy(new ThresholdLife(2));
		setupExtremity.hurt(new Weapon(2));
		assertThat(setupExtremity.getLife(), not(equalTo(2)));
	}

	/**
	 * Test para comprobar que obtiene la vida de forma correcta
	 */
	@Test
	public void getPriceTest(){

		Node node = new Extremity (this.id1, 10, this.strategy);
		assertEquals(node.getLife(), 10);
		assertEquals(node.getPrice(), 10);
		Node node2 = new Extremity (this.id2, 20, this.strategy);
		assertEquals(node2.getLife(), 20);
		assertEquals(node2.getPrice(), 20);
	}
}
