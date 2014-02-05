package es.unileon.prg2.treegame.command;

import es.unileon.prg2.treegame.helpers.StateWrapper;

/**
 * Comando que pasa al siguiente estado del juego.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */
public class NextCommand implements Command {

	/**
	 * Envoltorio del estado actual.
	 */
	private StateWrapper stateWrapper;
	
	/**
	 * Constructor del comando que pasa al siguiente estado.
	 * @param state El envoltorio del estado actual.
	 */
	public NextCommand(StateWrapper state){
		this.stateWrapper = state;
	}
	
	@Override
	public void execute() {
		if(stateWrapper.nextState() == null){
			System.out.println("Ha finalizado el juego, escriba 'exit' para salir.");
		} else {
			System.out.println(stateWrapper.getState().getTextDescription());
		}
	}
}
