// Esta clase se encuentra dentro del paquete CentroExamenes
package CentroExamenes;

/**
 * Esta es la clase Principal, es la encargada de lanzar los hilos de ejecucion
 * creando objetos de tipo ProductorExamenes y Examinador, todos compartiendo el
 * mismo buffer.
 * 
 */

public class Principal {
	// Lanzamos IntorruptedException que generan los hilos al ser dormidos con el
	// metodo wait() o notificados con el metodo notify()
	public static void main(String[] args) throws InterruptedException {
		// Creamos un objeto de la clase BufferExamenes, generador, que se pasara como referencia a los objetos creados
		BufferExamenes generador = new BufferExamenes();

		
		// En este bucle for se repite el numero de veces igual a la longitud del array, que genera
		// la entrada de los argumentos que van a entrar por la clase Lanzador
		// Por cada iteracion, se ve a generar un nuevo objeto de la clase Productor Examenes y
		// un nuevo objeto de la clase Examinador, ambos con la referencia al generado que apunta 
		// al objeto de la clase BufferExamenes
		for (int i = 0; i < args.length; i++) {
			new ProductorExamenes(generador);
			new Examinador(args[i], generador);
		}

		// Este if comprueba si se han pasado argumentos
		// Se utiliza el length para saber la longitud del array , por eso se iguala a 0
		if (args.length == 0) {
			// Si no hay argumento, se imprime el siguiente mensaje
			System.out.println("Se requiere un argumento");
			// Si no hay argumento, se imprime el mensaje de error
			System.err.println("_________________________________________________________");
			System.err.println("Se ha encontrado un error. Revise su archivo.");
			System.err.println("_________________________________________________________");
			return;
		}
		// Si no se ha dado error alguno, se imprime el siguiente mensaje
		else {
			System.err.println("_________________________________________________________");
			System.err.println("No se ha encontrado error ninguno. Revise su archivo.");
			System.err.println("_________________________________________________________");
		}

	}

}
