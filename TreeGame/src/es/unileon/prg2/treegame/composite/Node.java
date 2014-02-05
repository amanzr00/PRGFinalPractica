package es.unileon.prg2.treegame.composite;

import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

/**
 * Interfaz que define las operaciones que se pueden realizar sobre un
 * �rbol de juego de un determinado jugador.
 * @author Alberto Manzano
 * @author Iv�n Montes
 * @author Pablo D�ez
 * @author Andrea San Ramon
 * @version 1.0
 */
public abstract class Node {

	/**
	 * Identificador del nodo.
	 */
	private Handler id;
	
	
	/**
	 * Constructor que no genera el identificador por s� mismo.
	 * @param id identificador del nodo pasado.
	 */
	public Node(Handler id){
		this.id = id;
	}
	
	/**
	 * Permite obtener el identificador del nodo sobre el que se tiene la
	 * referencia.
	 * @return el identificador de dicho nodo.
	 */
	public Handler getId() { 
		return id;
	}
	
	/**
	 * Agrega un nodo al seleccionado.
	 * @param node nodo a agregar.
	 * @return true si se ha agregado correctamente, en cualquier otro caso, false.
	 */
	public abstract boolean add(Node node);
	
	/**
	 * Elimina un nodo al nodo seleccionado.
	 * @param node nodo a eliminar.
	 * @return true si se ha eliminado correctamente, en cualquier otro caso false.
	 */
	public abstract boolean remove(Node node);
	
	/**
	 * Obtiene la representaci�n num�rica del identificador del elemento del
	 * �rbol.
	 * @return
	 */
	public abstract String toString();
	
	/**
	 * Busca un elemento en la jerarqu�a del �rbol dado su identificador.
	 * @param id identificador a buscar.
	 * @return el nodo si lo encuentra o null si no existe.
	 */
	public abstract Node search(Handler id);

	/**
	 * Permite da�ar a un nodo del �rbol dada un arma.
	 * @param weapon arma con la que se da�a al nodo del �rbol.
	 * @return 0 si el da�o ha sido absorbido por el nodo completamente o un valor mayor que 0
	 * que corresponda con el da�o que queda por absorber.
	 */
	public abstract int hurt(Weapon weapon);
	
	/**
	 * Permite obtener la puntuaci�n final de el nodo + suma de los hijos.
	 * @return Devuelve la puntuaci�n final de acuerdo con el recuento permitido. vida + 10 
	 * si el nodo est� vivo.
	 */
	public abstract int getFinalScore();
	
	/**
	 * Permite saber si un nodo a�n est� vivo.
	 * @return true si est� vivo o false en caso contrario.
	 */
	public boolean isAlive(){
		return getLife() > 0;
	}
	
	/**
	 * Permite obtener la vida de un determinado nodo.
	 * @return La vida del nodo.
	 */
	public abstract int getLife();
	
	/**
	 * Permite establecer la vida del nodo.
	 * @param life El valor num�rico de la vida del nodo.
	 */
	public abstract void setLife(int life);
	
	/**
	 * Establece la estrategia para el c�lculo de la vida.
	 * @param lifeStrategy La estrategia a establecer.
	 */
	public abstract void setLifeStrategy(LifeStrategy lifeStrategy);
}
