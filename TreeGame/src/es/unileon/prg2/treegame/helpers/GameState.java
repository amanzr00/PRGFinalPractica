package es.unileon.prg2.treegame.helpers;

/**
 * Almacena los distintos estados de los nodos.
 * @author Alberto Manzano
 * @author Iv�n Montes
 * @author Pablo D�ez
 * @author Andrea San Ramon
 * @version 1.0
 */
public enum GameState {
	/**
	 * Fase de creaci�n del �rbol.
	 */
	GAME_CREATION("---Fase de creaci�n del �rbol---"),
	/**
	 * Fase de configuraci�n del �rbol.
	 */
	GAME_CONFIGURATION("---Fase de cofiguraci�n del �rbol---"),
	/**
	 * Fase de batalla.
	 */
	GAME_BATTLE("---Comienza la batalla---"),
	/**
	 * Fase de finalizaci�n y conteo.
	 */
	GAME_END("---Conteo de puntuaciones---");
	
	/**
	 * Descripci�n del estado del nodo.
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
	 * Permite obtener la descripci�n del estado.
	 * @return la descripci�n.
	 */
	public String getTextDescription(){
		return this.textDesc;
	}
}
