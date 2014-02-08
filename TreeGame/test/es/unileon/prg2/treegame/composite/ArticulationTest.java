package es.unileon.prg2.treegame.composite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.exceptions.InvalidLifeValueException;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.handler.NodeHandler;
import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.DefaultLife;
import es.unileon.prg2.treegame.strategy.HalfLife;
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
	

	private Weapon weapon1, weapon2, weapon3, weapon4, weapon5;
	private Handler id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11, id12;
	private Node node1, node2, node3, node4, node5, node6, node7, node8, node9, node10, node11, node12, node13, node14, node15;
	private LifeStrategy strategy1, strategy2, strategy3, strategy4, strategy5, strategy6, strategy7;
	
	@Before
	public void setUp() throws Exception {
		//Creamos ids
		this.id1 = new NodeHandler(1);
		this.id2 = new NodeHandler(2);
		this.id3 = new NodeHandler(3);
		this.id4 = new NodeHandler(4);
		this.id5 = new NodeHandler(5);
		this.id6 = new NodeHandler(6);
		this.id7 = new NodeHandler(7);
		this.id8 = new NodeHandler(8);
		this.id9 = new NodeHandler(9);
		this.id10 = new NodeHandler(10);
		this.id11 = new NodeHandler(11);
		this.id12 = new NodeHandler(12);
		//Creamos armas
		this.weapon1 = new Weapon (5);
		this.weapon2 = new Weapon (6);
		this.weapon3 = new Weapon (2);
		this.weapon4 = new Weapon (4);
		this.weapon5 = new Weapon(8);
		//Creamos estrategias
		this.strategy1 = new DefaultLife();
		this.strategy2 = new ThresholdLife(3);
		this.strategy3 = new HalfLife();
				
		this.node1 = new Articulation(id1, 15, strategy2);
		this.node2 = new Extremity(id2, 7, strategy1);
		this.node3 = new Articulation(id3, 6, strategy1);
		this.node4 = new Extremity (id4, 4, strategy1);
		this.node5 = new Extremity (id5, 6, strategy3);
		this.node6 = new Extremity (id6, 10, strategy1);
		this.node7 = new Articulation (id7, 5, strategy1);
		this.node8 = new Articulation (id8, 2, strategy1);
		this.node9 = new Extremity (id9, 10, strategy1);
		this.node10 = new Extremity (id10, 10, strategy1);
		
		/* ARBOL */
		
		// Node1 15 threshold
			// Node2 7 default
			// Node3 6 default 
				// Node4 4 default
				// Node5 6 half
			// Node6 10 default
			// Node7 5 default
				// Node8 2 default
					//Node9 10 default
					//Node10 10 default
		this.node1.add(node2);
		this.node1.add(node3);
		this.node3.add(node4);
		this.node3.add(node5);
		this.node1.add(node6);
		this.node1.add(node7);
		this.node7.add(node8);
		this.node8.add(node9);
		this.node8.add(node10);
	}
	
	@Test
	/**
	 * Comprueba la creación correcta del nodo con valores correctos.
	 */
	public void constructorTest(){
		Articulation articulation = new Articulation(this.id1, 5, this.strategy1);
		assertNotNull(articulation);
		assertEquals(articulation.getId(), this.id1);
		assertEquals(articulation.getLife(), 5);
	}
	
	@Test(expected = InvalidLifeValueException.class)
	public void constructorTestExceptionLife(){
		Articulation articulation = new Articulation(this.id1, -3, this.strategy1);
	}
	
	/**
	 * Test para:
	 * 		- Comprombar que se pueden aniadir nodos al arbol (siendo articulacion).
	 * 		- Comprobar que no se puede aniadir un nodo a una extremidad.
	 * 
	 */
	@Test
	public void TestAdd (){
		
		// Creamos un nodo Extremidad
		NodeHandler id10 = new NodeHandler(10);
		Node node10 = new Extremity(id10, 3, strategy1);
		// Aniadimos el nodo a una articulacion
		assertTrue(this.node3.add(node10));
		// Aniadir a un nodo extremidad
		assertFalse(this.node4.add(node10));
		
		// Creamos una extremidad
		NodeHandler id11 = new NodeHandler(11);
		Node node11 = new Articulation(id11, 5, strategy1);
		// Anadimos
		assertTrue(this.node3.add(node11));
		assertFalse(this.node10.add(node11));
		
		NodeHandler id12 = new NodeHandler(12);
		Node node12 = new Articulation(id12, 5, strategy2);
		assertTrue(this.node1.add(node12));
		assertFalse(this.node2.add(node12));
	}
	
	/**
	 * Test para comprobar que salta la exception "IllegalArgumentException".
	 * Saltara cuando se intente aniadir un nodo nulo
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddInvalidLifeValue(){
		// nodes 12,12,13,14,15 -> no existen
		node1.add(node11);
		node2.add(node12);
		node3.add(node13);
		node3.add(node14);
		node4.add(node15);
	}
	
	/**
	 * Test que comprueba:
	 * 		- Se puede eliminar un nodo del arbol
	 * 		- No se puede eliminar una articulacion de una extremidad
	 */
	
	@Test
	public void TestRemove (){
		// node4 -> Existe, por lo que se elimina sin problemas
		assertTrue(this.node3.remove(node4));
		// node3 -> No existe
		assertFalse(this.node4.remove(node3));
		
		assertFalse(this.node2.remove(node12));
		assertFalse(this.node3.remove(node1));
		assertFalse(this.node4.remove(node15));
		assertFalse(this.node1.remove(node8));
		
		assertTrue(this.node1.remove(node2));
		assertTrue(this.node8.remove(node9));
		assertTrue(this.node8.remove(node10));
		assertTrue(this.node7.remove(node8));
		
		/* arbol final */ 
		// Node1
			// Node3
				// Node4
				// Node5
			// Node6
			// Node7						
	}
	
	/**
	 * Test que comprueba que salta la excepcion "IllegalArgumentException"
	 * Dicha excepcion saltara cuando se intente eliminar un nodo que no exista.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveInvalidLifeValue(){
		// node 11 y 12 -> No existe
		node1.remove(node11);
		node8.remove(node12);
		node3.remove(node11);
		node3.remove(node12);
		node7.remove(node11);

	}
	
	/**
	 * Test para comprobar el metodo para buscar, y el funcionamiento del handler.
	 * Devuelve el nodo buscado si existe, o null si no esta en el arbol (no existe).
	 */
	@Test
	public void TestSearch (){
		// Buscamos el id1 (node1) -> Existen 
		assertEquals(this.node1.search(id1), node1);
		// Buscamos el id11 (node11) -> No existe
		assertNull(this.node1.search(id11));
		
		assertEquals(this.node1.search(id2), node2);
		assertEquals(this.node1.search(id3), node3);
		assertEquals(this.node1.search(id6), node6);
		assertEquals(this.node1.search(id7), node7);
		assertEquals(this.node8.search(id10), node10);
		
		assertNull(this.node1.search(id11));
		assertNull(this.node5.search(id2));
		assertNull(this.node1.search(id12));
		assertEquals(this.node7.search(id2), null);
		assertEquals(this.node8.search(id7), null);
	}
	
	/**
	 * Test para comprobar que se pasa de int a String correctamente
	 */
	@Test
	public void TestToString(){
		
		assertEquals(this.node1.getId().toString(), "1");
		assertEquals(this.node2.getId().toString(), "2");
		assertEquals(this.node3.getId().toString(), "3");
		assertEquals(this.node4.getId().toString(), "4");
		assertEquals(this.node5.getId().toString(), "5");
		

	}
	
	/**
	 * Test para comprobar el funcionamiento de hurt.
	 * A la vida del nodo atacado se le restara la potencia del arma.
	 * Devuelve la potencia restante del arma.
	 */
	@Test
	public void TestHurt(){
		// node5 (vida 6), atacado por weapon3 (poder 2) -> Poder del arma restante: 0
		assertEquals(this.node5.hurt(weapon3), 0);
		// node4 (vida 4), atacado por weapon2 (poder 6) -> Poder del arma restante: 2
		assertEquals(this.node4.hurt(weapon2), 2);
	
		assertEquals(this.node10.hurt(weapon1), 0);
		assertEquals(this.node9.hurt(weapon1), 0);
		assertEquals(this.node8.hurt(weapon4), 0);
		assertEquals(this.node4.hurt(weapon5), 8);
		assertEquals(this.node2.hurt(weapon5), 1);
		assertEquals(this.node7.hurt(weapon5), 0);
		
				
	}
	
	/**
	 * Test que para comprobar que se obtiene correctamente la puntuacion final
	 */
	@Test
	public void TestGetFinalScore(){
		
		// Puntuacion incial (sin recibir ni realizar ataques): 88
		assertEquals(this.node1.getFinalScore(), 175);	
		// Con ataques al node5 (vida restante: 4) y al node4 (muere)
		this.node5.hurt(weapon3);
		this.node4.hurt(weapon4);
		// Puntuacion final (tras 2 ataques): 159
		assertEquals(this.node1.getFinalScore(), 159);
		
		this.node5.hurt(weapon1);
		assertEquals(this.node1.getFinalScore(), 145);
		this.node6.hurt(weapon1);
		assertEquals(this.node1.getFinalScore(), 144);
		this.node6.hurt(weapon4);
		assertEquals(this.node1.getFinalScore(), 144);
		this.node6.hurt(weapon2);
		assertEquals(this.node1.getFinalScore(), 138);
		
	}
	
	/**
	 * Test para:
	 * 		- Comprobar que se obtiene correctamente la vida de un nodo (get)
	 * 		- Comprobar que se puede establecer la vida a un nodo (set)
	 */
	
	@Test
	public void TestSetAndGetLife(){
		
		// Nueva vida de: 60
		this.node1.setLife(60);
		assertEquals(this.node1.getLife(), 60);
		// Nueva vida de: 0
		this.node2.setLife(0);
		assertEquals(this.node2.getLife(),0);
		
		this.node3.setLife(10);
		assertEquals(this.node3.getLife(), 10);
		
		this.node4.setLife(15);
		assertEquals(this.node4.getLife(), 15);
		
		this.node5.setLife(20);
		assertEquals(this.node5.getLife(), 20);
		
		this.node6.setLife(25);
		assertEquals(this.node6.getLife(), 25);
		
	}

	/**
	 * Test para comprobar que salta la excepcion "IllegalArgumentException".
	 * Salta cuando la estrategia de vida (LifeStrategy) sea nula
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetNullLifeStrategy(){
		
		// strategy3 -> Nula (Salta la excepcion)
		this.node1.setLifeStrategy(strategy3);
		
		this.node2.setLifeStrategy(strategy4);
		this.node3.setLifeStrategy(strategy5);
		this.node10.setLifeStrategy(strategy6);
		this.node9.setLifeStrategy(strategy7);
	}
}
