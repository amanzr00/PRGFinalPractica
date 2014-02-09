package es.unileon.prg2.treegame.command;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.composite.Extremity;
import es.unileon.prg2.treegame.composite.Node;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.handler.NodeHandler;
import es.unileon.prg2.treegame.helpers.Credit;
import es.unileon.prg2.treegame.strategy.HalfLife;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

public class CommandCreateHalfLifeTest {
	
	private Handler id1;
	private Node nodeTarget;
	private LifeStrategy halfLife;
	private Credit credit;

	@Before
	public void setUp() throws Exception {
		
		this.halfLife = new HalfLife(4);
		this.id1 = new NodeHandler(1);
		this.nodeTarget = new Extremity(id1, 4, halfLife);
		this.credit = new Credit(10);
		
	}
	
	@Test
	public void constructorTest(){
		CommandCreateHalfLife commandCreateHalfLife = new CommandCreateHalfLife(nodeTarget, halfLife, credit);
		assertNotNull(commandCreateHalfLife);
		
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
