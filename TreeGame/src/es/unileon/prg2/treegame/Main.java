package es.unileon.prg2.treegame;

import org.apache.log4j.PropertyConfigurator;



/**
 * Punto de entrada en la aplicaci�n.
 * @author Alberto Manzano
 * @author Iv�n Montes
 * @author Pablo D�ez
 * @author Andrea San Ramon
 * @version 1.0
 */
public class Main {
	/**
	 * M�todo main.
	 * @param args argumentos de l�nea de comandos.
	 */
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("./etc/log4j.properties");
		new CommandLineInvoker().runShell();
	}
}
