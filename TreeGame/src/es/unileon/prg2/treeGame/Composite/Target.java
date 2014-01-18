package es.unileon.prg2.treegame.composite;
import es.unileon.prg2.treegame.handler.Handler;
import es.unileon.prg2.treegame.helpers.Weapon;
import es.unileon.prg2.treegame.strategy.LifeStrategy;

/**
 * Interfaz que define las operaciones que se pueden realizar sobre un
 * árbol de juego de un determinado jugador.
 * @author Alberto Manzano
 * @version 1.0
 */
public interface Target {
	
	/**
	 * Permite obtener el identificador del nodo sobre el que se tiene la
	 * referencia.
	 * @return el identificador de dicho nodo.
	 */
	public Handler getId();
	
	/**
	 * Agrega un nodo al seleccionado.
	 * @param target nodo a agregar.
	 * @return true si se ha agregado correctamente, en cualquier otro caso, false.
	 */
	public boolean add(Target target);
	
	/**
	 * Elimina un nodo al nodo seleccionado.
	 * @param id identificador del nodo a eliminar.
	 * @return true si se ha eliminado correctamente, en cualquier otro caso false.
	 */
	public boolean remove(Node target);
	
	/**
	 * Obtiene la representación numérica del identificador del elemento del
	 * árbol.
	 * @return
	 */
	public String toString();
	
	/**
	 * Busca un elemento en la jerarquía del árbol dado su identificador.
	 * @param id identificador a buscar.
	 * @return el nodo si lo encuentra o null si no existe.
	 */
	public Target search(Handler id);

	/**
	 * Permite dañar a un nodo del árbol dada un arma.
	 * @param weapon arma con la que se daña al nodo del árbol.
	 * @return 0 si el daño ha sido absorbido por el nodo completamente o un valor mayor que 0
	 * que corresponda con el daño que queda por absorber.
	 */
	public int hurt(Weapon weapon);
	
	/**
	 * Permite obtener la puntuación final de el nodo + suma de los hijos.
	 * @return Devuelve la puntuación final de acuerdo con el recuento permitido. vida + 10 
	 * si el nodo está vivo.
	 */
	public int getFinalScore();
	
	/**
	 * Permite saber si un nodo aún está vivo.
	 * @return true si está vivo o false en caso contrario.
	 */
	public boolean isAlive();
	
	/**
	 * Permite obtener la vida de un determinado nodo.
	 * @return La vida del nodo.
	 */
	public int getLive();
	
	/**
	 * Permite establecer la vida del nodo.
	 * @param life El valor numérico de la vida del nodo.
	 */
	public void setLife(int life);
	
	/**
	 * Establece la estrategia para el cálculo de la vida.
	 * @param lifeStrategy La estrategia a establecer.
	 */
	public void setLifeStrategy(LifeStrategy lifeStrategy);
}
