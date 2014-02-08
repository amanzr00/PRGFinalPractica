package es.unileon.prg2.treegame.helpers;

/**
 * Interfaz que debe ser implementada por todos los elementos con precio dentro
 * de la aplicaci�n.
 * @author Alberto Manzano
 * @author Iv�n Montes
 * @author Pablo D�ez
 * @author Andrea San Ramon
 * @version 1.0
 */
public interface Valorize {
	/**
	 * Permite obtener el precio de un elemento con valor.
	 * @return El precio de un elemento con valor.
	 */
	public int getPrice();
}
