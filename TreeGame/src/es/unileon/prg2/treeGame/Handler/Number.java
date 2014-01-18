package es.unileon.prg2.treeGame.Handler;



public class Number implements Handler{

	private int id;
	
	public Number(int id) {
		this.id = id;
	}

	public Number(String id) {
		this.id = Integer.parseInt(id);
	}

	@Override
	public int compareTo(Handler another) {
		return this.toString().compareTo(another.toString());
	}

	public String toString() {
		return Integer.toString(id);
	}


}
