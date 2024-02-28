package IO; // Los nombres de paquete generalmente se escriben en minúsculas

import Interfaces.iTeclado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teclado implements iTeclado { // Corrección del nombre de la interfaz y convención de nomenclatura

    private static final Scanner teclado = new Scanner(System.in); // Se define teclado como final porque no se reasigna y para reflejar que es constante
    private static final Scanner tecladoNumeros = new Scanner(System.in); // Nombres de variables significativos (tecladoNumeros)

 

    public static String leeString(String cadena){

        System.out.println(mensaje); // Cambio de "cadena" a "mensaje" para reflejar su función
        return teclado.nextLine(); // Simplificación del código, eliminación de la variable cadenaUsuario
    }

    public static int leeEntero(String mensaje) {
        int numeroUsuario = 0;

        do {
            try {
                System.out.println(mensaje); // Cambio de "cadena" a "mensaje" para reflejar su función
                numeroUsuario = tecladoNumeros.nextInt();
                break; // Se sale del bucle si la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println("Error: Introduce un número válido.");
                tecladoNumeros.next(); // Se limpia el buffer del scanner para evitar un bucle infinito
            }
        } while (true);

        return numeroUsuario;
    }

    public static void imprimirCadena(String cadena) {
        System.out.println(cadena);
    }
}
