package es.unileon.prg2.treegame.handler;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test de la clase NodeHandler
 * @author Alberto Manzano
 * @author Ivan Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */
public class NodeHandlerTest {

	private NodeHandler number1, number2, number3;
	int id, id2;
	
	@Before
	public void setUp() throws Exception {
		id = 1;
		id2 = 2;
		number1 = new NodeHandler(id);
		number2 = new NodeHandler(id2);
		number3 = new NodeHandler(id2);
	}

	/**
	 * Test del contructor
	 */
	@Test
	public void testConstructor(){
		NodeHandler nodehandler = new NodeHandler(id);
		assertNotNull(nodehandler);		
	}
	
	/**
	 * Test para comprobar que se comparan correctamente los identificadores
	 * Si devuelve -1, significa que no es el mismo
	 * Si devuleve 0, es el mismo
	 */
	@Test
	public void testCompareTo() {
		assertEquals(this.number1.toString().compareTo(number2.toString()), -1);
		assertEquals(this.number3.toString().compareTo(number3.toString()), 0);		
	}
	
	/**
	 * Test para pasar a String el Handler
	 */
	@Test
	public void testToString() {
		assertEquals(this.number1.toString(), "1");
		assertEquals(this.number2.toString(), "2");		
	}
}
