package es.unileon.prg2.treegame.composite;

import static org.junit.Assert.*;

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
public class ExtremityTest {

	private Weapon weapon1, weapon2;
	private Handler id1, id2, id3, id4, id5, id6;
	private Node node1, node2, node3, node4, node5, node6;
	private LifeStrategy strategy1, strategy2;
	
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
		
		// Creacion del node6
		this.id6 = new NodeHandler(6);
		this.node6 = new Extremity (id6, 5, strategy2);
		
		// Anidimos el node6(extremidad) al node4 (extemidad)
		assertFalse(this.node4.add(node6));
			
	}
	
	/**
	 * Test para comprobar el borrado de nodos de una extremidad
	 * (No se puede)
	 */
	@Test
	public void TestRemove (){
		
		this.id6 = new NodeHandler(6);
		this.node6 = new Extremity (id6, 5, strategy2);
			
		assertFalse(this.node3.remove(node6));
		
	}
	
	/**
	 * Test para comprobar el metodo para buscar, y el funcionamiento del handler.
	 * Devuelve el nodo buscado si existe, o null si no esta en el arbol (no existe).
	 */
	@Test
	public void TestSearch (){
		// Creamos un nodo (pero no lo metemos al arbol)
		this.id6 = new NodeHandler(6);
		this.node6 = new Extremity (id6, 5, strategy2);
		
		// Buscamos el node4 (existe). Devuelve el nodo4.
		assertNotNull(this.node4.search(id4));
		// Buscamos el node6 (no existe en el arbol). Devuelve null.
		assertNull(this.node4.search(id6));

	}
	
	/**
	 * Test para comprobar que se pasa de int a String correctamente
	 */
	@Test
	public void TestToString(){
				
		assertEquals(this.node4.getId().toString(), "4");

	}
	
	/**
	 * Test para comprobar el funcionamiento de hurt.
	 * A la vida del nodo atacado se le restara la potencia del arma.
	 * Devuelve la potencia restante del arma.
	 */
	@Test
	public void TestHurt(){
		
		// Atacamos al nodo4 (vida 4) con weapon1 (poder 10) -> Potencia del arma restante: 6
		assertEquals(this.node4.hurt(weapon1), 6);
		// Atacamos al nodo5 (vida 6) con weapon2 (poder 6) -> Potencia del arma restante: 0
		assertEquals(this.node5.hurt(weapon2), 0);
		
	}
	
	/**
	 * Test que para comprobar que se obtiene correctamente la puntuacion final
	 */
	@Test
	public void TestGetFinalScore(){
		
		// Resultado final: 88 (sin ataques)
		assertEquals(this.node1.getFinalScore(), 88);
		
	}
	
	/**
	 * Test para:
	 * 		- Comprobar que se obtiene correctamente la vida de un nodo (get)
	 * 		- Comprobar que se puede establecer la vida a un nodo (set)
	 */
	@Test
	public void TestSetAndGetLife(){
		
		// Nueva vida del node4: 4
		node4.setLife(4);
		// La vida sera 4.
		assertEquals(this.node4.getLife(), 4);

	}
	
	
	/**
	 * Test para comprobar que salta la excepcion "IllegalArgumentException".
	 * Salta cuando la estrategia de vida (LifeStrategy) sea nula
	 */
	@Test(expected = IllegalArgumentException.class)
	public void TestSetNullLifeStrategy(){
		
		// Creacion de una estrategia nula
		LifeStrategy lifeStrategy3 = null;
		// Le asignamos dicha estrageia -> Salta la excepcion
		this.node1.setLifeStrategy(lifeStrategy3);
	}
}
