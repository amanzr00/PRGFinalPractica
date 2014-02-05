package es.unileon.prg2.treegame.helpers;

/**
 * Almacena los distintos estados de los nodos.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */
public enum GameState {
	/**
	 * Fase de creación del árbol.
	 */
	GAME_CREATION("---Fase de creación del árbol---"),
	/**
	 * Fase de configuración del árbol.
	 */
	GAME_CONFIGURATION("---Fase de cofiguración del árbol---"),
	/**
	 * Fase de batalla.
	 */
	GAME_BATTLE("---Comienza la batalla---"),
	/**
	 * Fase de finalización y conteo.
	 */
	GAME_END("---Conteo de puntuaciones---");
	
	/**
	 * Descripción del estado del nodo.
	 */
	private String textDesc;
	
	/**
	 * Constructor del estado del juego.
	 * @param textDesc
	 */
	GameState(String textDesc){
		this.textDesc = textDesc;
	}
	
	/**
	 * Permite obtener la descripción del estado.
	 * @return la descripción.
	 */
	public String getTextDescription(){
		return this.textDesc;
	}
}
