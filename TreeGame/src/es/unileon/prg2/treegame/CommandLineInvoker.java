package es.unileon.prg2.treegame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

import es.unileon.prg2.treegame.command.Command;
import es.unileon.prg2.treegame.command.CommandConstants;
import es.unileon.prg2.treegame.helpers.StateWrapper;

/**
 * Shell de comandos de la aplicación.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @version 1.0
 */
public class CommandLineInvoker {

	/**
	 * Estado de la aplicación.
	 */
	private StateWrapper state;
	
	/**
	 * Inicializa el lector de comandos.
	 */
	public CommandLineInvoker(){
		state = new StateWrapper();
	}
	
	/**
	 * Ejecuta la shell para que se puedan leer comandos.
	 */
	public void runShell(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		try {
			System.out.print(">> ");
			while (!(line = reader.readLine()).equalsIgnoreCase("exit")){
				parseCommand(line);
				System.out.print(">> ");
			}
		} catch (IOException e) {
			System.out.println("Se ha producido un error de entrada salida inesperado y el programa se cerrará.");
		}
	}
	
	/**
	 * Parseo de comandos usando reflexión.
	 * @param command el comando.
	 */
	private void parseCommand(String command){
		String[] arguments = command.split("\\s");
		if (arguments.length > 0){
			String commandName = arguments[0];
			CommandConstants commandConstant = CommandConstants.fromString(commandName);
			if (commandConstant != null){
				Command commandInstance = null;
				Class<? extends Command> instanceClass = commandConstant.getCommandClass();
				try {
					switch(commandConstant){
						case next:
							commandInstance = instanceClass.getDeclaredConstructor(StateWrapper.class).newInstance(this.state);
						break;
					}
					commandInstance.execute();
				} catch (InstantiationException | IllegalAccessException
						| IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException
						| SecurityException e) {
					System.out.println("Comando no valido.");
				}
			} else {
				System.out.println("Comando no valido.");
			}
		} else {
			System.out.println("Comando no valido.");
		}
	}
	
//	/**
//	 * Parseo de comandos sin usar reflexión.
//	 * @param command comando.
//	 */
//	private void parseCommand(String command){
//		String[] arguments = command.split("\\s");
//		if (arguments.length > 0){
//			String commandName = arguments[0];
//			CommandConstants commandConstant = CommandConstants.valueOf(commandName);
//			if (commandConstant != null){
//				Command commandInstance = null;
//				switch(commandConstant){
//					case Next:
//						commandInstance = new NextCommand(this.state);
//					break;
//				}
//				if(commandInstance != null)	commandInstance.execute();
//			} else {
//				System.out.println("Comando no valido.");
//			}
//		} else {
//			System.out.println("Comando no valido.");
//		}
//	}
}
