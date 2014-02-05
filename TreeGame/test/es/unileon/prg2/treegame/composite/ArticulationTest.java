package es.unileon.prg2.treegame.composite;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

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
public class ArticulationTest {
	

	private Weapon weapon2, weapon3, weapon4;
	private Handler id1, id2, id3, id4, id5, id7;
	private Node node1, node2, node3, node4, node5, node6;
	private LifeStrategy strategy1, strategy2, strategy4;
	
	@Before
	public void setUp() throws Exception {
		this.id1 = new NodeHandler(1);
		this.id2 = new NodeHandler(2);
		this.id3 = new NodeHandler(3);
		this.id4 = new NodeHandler(4);
		this.id5 = new NodeHandler(5);
		this.id7 = new NodeHandler(7);

		this.weapon2 = new Weapon (6);
		this.weapon3 = new Weapon (2);
		this.weapon4 = new Weapon (4);
		this.strategy1 = new DefaultLife();
		this.strategy2 = new ThresholdLife(3);
		
		this.node1 = new Articulation(id1, 15, strategy2);
		this.node2 = new Articulation(id2, 7, strategy1);
		this.node3 = new Articulation(id3, 6, strategy1);
		this.node4 = new Extremity (id4, 4, strategy1);
		this.node5 = new Extremity (id5, 6, strategy1);
		
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
	 * Test para:
	 * 		- Comprombar que se pueden aniadir nodos al arbol (siendo articulacion).
	 * 		- Comprobar que no se puede aniadir un nodo a una extremidad.
	 * 
	 */
	@Test
	public void TestAdd (){
		NodeHandler id10 = new NodeHandler(10);
		Node node10 = new Extremity(id10, 3, strategy1);
		// Aniadir a un nodo articulacion
		assertTrue(this.node3.add(node10));
		// Aniadir a un nodo extremidad
		assertFalse(this.node4.add(node10));
		
	}
	
	/**
	 * Test para comprobar que salta la exception "IllegalArgumentException"
	 * Saltara cuando se intente aniadir un nodo nulo
	 * 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddInvalidLifeValue(){
		node1.add(node6);
	}
	
	/**
	 * Test que comprueba:
	 * 		- Se puede eliminar un nodo del arbol
	 * 		- No se puede eliminar una articulacion de una extremidad
	 * 
	 */
	
	@Test
	public void TestRemove (){
		
		assertTrue(this.node3.remove(node4));
		assertFalse(this.node4.remove(node3));
		
	}
	
	/**
	 * Test que comprueba que salta la excepcion "IllegalArgumentException"
	 * Dicha excepcion saltara cuando se intente eliminar un nodo que no exista.
	 * 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveInvalidLifeValue(){
		node1.remove(node6);
	}
	
	/**
	 * Test para comprobar el metodo para buscar, y el funcionamiento del handler.
	 * Devuelve el nodo buscado si existe, o null si no esta en el arbol (no existe).
	 * 
	 */
	@Test
	public void TestSearch (){
	
		assertEquals(this.node1.search(id1), node1);
		assertEquals(this.node3.search(id4), node4);
		assertNull(this.node1.search(id7));
		
	}
	
	/**
	 * Test para comprobar que se pasa de int a String correctamente
	 * 
	 */
	@Test
	public void TestToString(){
		assertEquals(this.node1.getId().toString(), "1");

	}
	
	/**
	 * Test para comprobar el funcionamiento de hurt.
	 * A la vida del nodo atacado se le restara la potencia del arma.
	 * Devuelve la potencia restante del arma.
	 * 
	 */
	@Test
	public void TestHurt(){
		
		assertEquals(this.node5.hurt(weapon3), 0);
		assertEquals(this.node4.hurt(weapon2), 2);
	
	}
	
	/**
	 * Test que para comprobar que se obtiene correctamente la puntuacion final
	 * 
	 */
	@Test
	public void TestGetFinalScore(){
		
		// Puntuacion incial (sin recibir ni realizar ataques)
		assertEquals(this.node1.getFinalScore(), 88);
		
		// Con ataques
		this.node5.hurt(weapon3);
		this.node4.hurt(weapon4);
		
		// Puntuacion final (tras 2 ataques)
		assertEquals(this.node1.getFinalScore(), 72);
	}
	
	/**
	 * Test para:
	 * 		- Comprobar que se obtiene correctamente la vida de un nodo (get)
	 * 		- Comprobar que se puede establecer la vida a un nodo (set)
	 */
	
	@Test
	public void TestSetAndGetLife(){
		
		this.node1.setLife(60);
		assertEquals(this.node1.getLife(), 60);
		this.node2.setLife(0);
		assertEquals(this.node2.getLife(),0);
		
	}

	/**
	 * Test para comprobar que salta la excepcion "IllegalArgumentException".
	 * Saltara cuando se intente establecer la vida a un nodo (set) con un numero < 0.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetLifeStrategy(){
		this.node1.setLifeStrategy(strategy4);
	}
}
