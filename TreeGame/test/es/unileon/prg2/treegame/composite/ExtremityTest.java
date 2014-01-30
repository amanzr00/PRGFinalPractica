package es.unileon.prg2.treegame.composite;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

/**
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @version 1.0
 */
public class ExtremityTest {
	private int life;
	private LifeStrategy lifeStrategy;
	private ArrayList<Node> nodes;
	private Weapon weapon1, weapon2, weapon3;
	private Articulation root, articulation1, articulation2, articulation3;
	private Extremity node1, node2;
	private Node uno;
	
	
	@Before
	public void setUp() throws Exception {
		

		root = new Articulation(50, lifeStrategy);
		nodes.add(root);
		articulation1 = new Articulation (50, null);
		
		weapon1 = new Weapon (10);
		weapon2 = new Weapon (2);
	}

	@Test
	public void TestAdd (){
	
		assertEquals(this.root.add(new Articulation(50, lifeStrategy)), nodes);
		
	}
	
	@Test
	public void TestRemove (){
		
		assertEquals(this.root.remove(new Articulation(50, lifeStrategy)), nodes);

	}
	
	@Test
	public void TestSearch (){
	
		assertEquals(this.articulation1.search(null), null);

	}
	
	@Test
	public void TestToString(){
				
		//assertEquals(this.root.toString(),"1\nnull\nnull\n");

	}
	
	@Test
	public void TestHurt(){
		
		assertEquals(this.root.hurt(weapon1), 10);
		assertEquals(this.articulation1.hurt(weapon2), 2);
		
		
	}
	
	@Test
	public void TestGetFinalScore(){
		
		assertEquals(this.life, 120 );
		
	}
	
	@Test
	public void TestGetLife(){
		
		assertEquals(this.root.getLife(), 50);
		assertEquals(this.articulation1.getLife(), 50);
	}
	
	@Test
	public void TestSetLife(int life){
		
		this.root.setLife(60);
		assertEquals(this.root.getLife(), 60);
		
	}
	
	@Test
	public void TestSetLifeStrategy(LifeStrategy lifeStrategy){
		
		/*
		 * Implementar
		 */
		
	}
}
