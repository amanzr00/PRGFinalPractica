package es.unileon.prg2.treegame;

import org.apache.log4j.PropertyConfigurator;



/**
 * Punto de entrada en la aplicación.
 * @author Alberto Manzano
 * @author Iván Montes
 * @author Pablo Díez
 * @author Andrea San Ramon
 * @version 1.0
 */
public class Main {
	/**
	 * Método main.
	 * @param args argumentos de línea de comandos.
	 */
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("./etc/log4j.properties");
		new CommandLineInvoker().runShell();
	}
}
