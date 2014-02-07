package es.unileon.prg2.treegame.handler;

public class Identifier {

	private int identifier = 0;
	
	public int getId(){
		identifier = identifier++;
		return identifier;
	}
}
