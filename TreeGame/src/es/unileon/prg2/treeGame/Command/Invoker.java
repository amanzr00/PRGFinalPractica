package es.unileon.prg2.treeGame.Command;



public class Invoker {
	Command add;
	Command remove;

	public Invoker(Command add,Command remove) {
		this.add = add;
		this.remove = remove;
	}

	public void AddCommand() {
		add.execute();
	}

	public void RemoveCommand() {
		remove.execute();
	}
}
