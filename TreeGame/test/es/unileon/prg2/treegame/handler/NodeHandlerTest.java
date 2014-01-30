package es.unileon.prg2.treegame.handler;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Alberto Manzano.
 * @author Iván Montes.
 * @author Pablo Díez.
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
		number2 = new NodeHandler(id);
		number3 = new NodeHandler(id2);
	}

	@Test
	public void testcompareTo() {
		equals(this.number1.toString().compareTo(number2.toString()));
		equals(this.number1.toString().compareTo(number3.toString()));
		
	}
}
