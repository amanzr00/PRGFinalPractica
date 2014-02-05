package es.unileon.prg2.treegame.helpers;

/**
 * Envoltorio del estado de la aplicaci�n.
 * @author Alberto Manzano
 * @author Iv�n Montes
 * @author Pablo D�ez
 * @author Andrea San Ramon
 * @version 1.0
 */
public class StateWrapper {
	/**
	 * Estado del juego.
	 */
	private GameState state;

	/**
	 * Constructor del envoltorio del estado del juego.
	 */
	public StateWrapper(){
		state = GameState.GAME_CREATION;
	}
	
	/**
	 * Pasa al siguiente estado de la aplicaci�n.
	 * @return El siguiente estado disponible de la aplicaci�n.
	 */
	public GameState nextState(){
		if (state != null){
			switch(state){
				case GAME_CREATION:
					state = GameState.GAME_CONFIGURATION;
				break;
				case GAME_CONFIGURATION:
					state = GameState.GAME_BATTLE;
				break;
				case GAME_BATTLE:
					state = GameState.GAME_END;
				break;
				case GAME_END:
					state = null;
				break;
			}
		}
		return this.state;
	}
	
	/**
	 * Devuelve el estado almacenado en el wrapper.
	 * @return
	 */
	public GameState getState(){
		return this.state;
	}
}
