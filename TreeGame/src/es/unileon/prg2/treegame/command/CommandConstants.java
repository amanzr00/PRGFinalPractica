package es.unileon.prg2.treegame.command;

/**
 * Constantes de comandos con la clase correspondiente a instanciar.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @version 1.0
 */
public enum CommandConstants {
	/**
	 * Comando que cambia de estado.
	 */
	next(NextCommand.class);
	
	/**
	 * La clase que se debe instanciar para ese comando.
	 */
	private Class<? extends Command> commandClass;
	
	/**
	 * Constructor con una clase de comando.
	 * @param commandClass la clase de comando a instanciar.
	 */
	CommandConstants(Class<? extends Command> commandClass){
		this.commandClass = commandClass;
	}
	
	/**
	 * Devuelve la clase asociada al comando.
	 * @return la clase del comando.
	 */
	public Class<? extends Command> getCommandClass(){
		return commandClass;
	}
	
	/**
	 * Permite obtener el comando por el nombre.
	 * @param commandName El nombre del comando.
	 * @return El tipo de comando como enumerado.
	 */
	public static CommandConstants fromString(String commandName) {
		if (commandName != null) {
			for (CommandConstants value : CommandConstants.values()) {
				if (commandName.equalsIgnoreCase(value.name())) {
					return value;
				}
			}
		}
		return null;
	}
}
