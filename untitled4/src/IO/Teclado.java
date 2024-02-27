package IO;

// Funciones de teclado como LeerString, LeerEntero, CambiarContraseña escrita por cmd a Asteriscos,
// Imprmir por cmd algo

import Interfaces.iTeclado;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Teclado implements iTeclado {
    private static Scanner teclado = new Scanner(System.in);
    private static Scanner tecladonumeros = new Scanner(System.in);

    public static String leeString(String cadena) {

        String cadenaUsuario;
        System.out.println(cadena);
        cadenaUsuario = teclado.nextLine();
        return cadenaUsuario;
    }


    public static int leeEntero(String cadena) {
        int numeroUsuario = 0;
        boolean entradaValida = false;

        do {
            try {
                numeroUsuario = tecladonumeros.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Introduce un número válido.");
                teclado.nextInt();
            }
        } while (!entradaValida);


        return numeroUsuario;
    }

    public static void imprimirCadena(String cadena) {
        System.out.println(cadena);
    }
}