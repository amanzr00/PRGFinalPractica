package es.unileon.prg2.treeGame.Command;

import es.unileon.prg2.treeGame.Composite.Node;
import es.unileon.prg2.treeGame.Handler.Handler;

public class AddNodeCommand implements Command{
	private Node newNode;
	private Node tree;
	private Handler parentNode;	
	
	public AddNodeCommand(Node newNode, Node tree, Handler parentNode){
		this.newNode = newNode;
		this.tree = tree;
		this.parentNode = parentNode;		
	}	
	
	public void execute() {	
		
	}
	
}