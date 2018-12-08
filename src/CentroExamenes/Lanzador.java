// Esta clase se encuentra dentro del paquete CentroExamenes
package CentroExamenes;

// Importamos la libreria File para la generacion de archivos
import java.io.File;
// Importamos la libreria IOException para poder capturar las excepciones generadas por la entrada/salida de ficheros
import java.io.IOException;

/**
 * @author Alejandro Gonzalez Casado
 * @version 1.0
 * 
 *          Esta es la clase Lanzador, se encarga de lanzar 2 procesos, y se
 *          encargaran de pasar como argumento el nombre de los alumnos a la
 *          clase Principal y la ejecucion de la misma. Para ejecutar este
 *          lanzador, debemos de usar la consola de comandos y situarnos en la
 *          carpeta "bin", en ella se encontrara el paquete "CentroExamenes" y
 *          dentro del mismo los archivos correspondientes a cada clase. Tras
 *          ello, escribiremos "java CentroExamenes/Lanzador" y se ejecutara la
 *          clase Lanzador.
 *
 */
public class Lanzador {

	public static void main(String[] args) {

		// Creamos dos objetos nuevos de la clase ProcessBuilder
		// Incluiremos como parametros de estos objetos el String "java" para que se
		// lance desde la consola de comandos
		// Tambien incluiremos el String Principal precedido de su paquete contenedor
		// separado por "/", para especificar la ruta, que ejecutara a la clase  Principal
		// Por ultimo anadimos tres alumnos que seran pasados como argumentos a la clase Principal
		ProcessBuilder proceso1, proceso2;
		proceso1 = new ProcessBuilder("java", "CentroExamenes/Principal", "Pepe", "Juan", "Luis");
		proceso2 = new ProcessBuilder("java", "CentroExamenes/Principal", "Rosa", "Miguel", "Pedro");

		/*
		 * Un proceso lanzado no tendra entrada y salida por consola como se suele
		 * hacer. Con reditrectError recibe un objeto File por parametro, generando un
		 * archivo que se llamara "errores_centro_x" este escribe los errores que se
		 * hayan dado en la clase Principal, los reconoce por el System.err. Con
		 * redirectOutput lo que hacemos es recibir un objeto File por parametro, 
		 * generando un archivo que se llamara "examen_centro_x" y este escribira los
		 * resultados que se dan al pasarle el argumento a la clase Principal, estos son reconocidos 
		 * por System.out 
		 */

		// Proceso 1, redireccion de errores a archivo de texto
		proceso1.redirectError(new File("errores_centro_1.txt"));
		// Proceso 1, redireccion de salida a archivo de texto
		proceso1.redirectOutput(new File("examen_centro_1.txt"));

		// Proceso 2, redireccion de errores a archivo de texto
		proceso2.redirectError(new File("errores_centro_2.txt"));
		// Proceso 2, redireccion de salida a archivo de texto
		proceso2.redirectOutput(new File("examen_centro_2.txt"));

		/**
		 * Creamos una sentencia en bloque try catch para capturar las excepciones de
		 * entrada y salida que pueden lanzarse al iniciar cada proceso, si se lanza
		 * alguna esta sera capturada y se imprimira el nombre de la misma
		 */

		try {
			// Iniciamos el proceso 1
			proceso1.start();
			// Sacamos por pantalla que el primer proceso se ha lanzado
			System.out.println("El primer proceso se ha lanzado con exito");
			// Sacamos por pantalla que se revisen los archivos generados por este proceso
			System.out.println("Revisa el contenido de los archivos errores_centro_1.txt y examen_centro_1.txt");
			// Iniciamos el proceso 2
			proceso2.start();
			// Sacamos por pantalla que el segundo proceso se ha lanzado
			System.out.println("El segundo proceso se ha lanzado con exito");
			// Sacamos por pantalla que se revisen los archivos generados por este proceso
			System.out.println("Revisa el contenido de los archivos errores_centro_2.txt y examen_centro_2.txt");
			// Imprimimos por consola un mensaje para indicar que los procesos se han
			// lanzado correctamente
			System.out.println("Los procesos se han lanzado");
			System.out.println("Examina los archivos de salida");

		} // Capturamos las excepciones que se han lanzado antes
		catch (IOException e) {
			// si hay alguna, se imprime el mensaje de dicha excepcion
			e.printStackTrace();

		}
	}

}
