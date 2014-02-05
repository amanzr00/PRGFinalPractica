package es.unileon.prg2.treegame.command;

/**
 * Constantes de comandos con la clase correspondiente a instanciar.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */
public enum CommandConstants {
	/**
	 * Comando que cambia de estado.
	 */
	next;
		
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
