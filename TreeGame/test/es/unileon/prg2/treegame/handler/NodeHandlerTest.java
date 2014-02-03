package es.unileon.prg2.treegame.handler;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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

	@Test
	public void testcompareTo() {
		assertEquals(this.number1.toString().compareTo(number2.toString()), -1);
		assertEquals(this.number3.toString().compareTo(number3.toString()), 0);
		
	}
	@Test
	public void testToString() {
		assertEquals(this.number1.toString(), "1");
		assertEquals(this.number2.toString(), "2");
		
	}

}
