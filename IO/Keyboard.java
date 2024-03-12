package IO;

import Interfaces.iTeclado;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Keyboard implements iTeclado {
    private static Scanner teclado = new Scanner(System.in);

    public static String readString(String cadena) {
    /**
     * Lee una cadena de texto desde la entrada estándar, asegurándose de que no esté vacía.
     * @param cadena El mensaje que se muestra al usuario antes de pedir la entrada.
     * @return La cadena de texto introducida por el usuario.
     */

        String cadenaUsuario;
        System.out.println(cadena);
        cadenaUsuario = teclado.nextLine();
        if (cadenaUsuario.isEmpty() || cadenaUsuario.isBlank()) {
            do {
                Keyboard.printString("No intentes meter un espacio en blanco");
                cadenaUsuario = teclado.nextLine();
            } while (cadenaUsuario.isEmpty() || cadenaUsuario.isBlank());
        }
        return cadenaUsuario;
    }

    public static int readInt(String cadena) {

    /**
     * Lee un número entero desde la entrada estándar, asegurándose de que la entrada sea válida.
     * @param cadena El mensaje que se muestra al usuario antes de pedir la entrada.
     * @return El número entero introducido por el usuario.
     */

        int numeroUsuario = 0;
        boolean entradaValida = false;
        printString(cadena);
        do {
            try {
                numeroUsuario = teclado.nextInt();
                teclado.nextLine();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Introduce un número.");
                teclado.nextLine();
            }
        } while (!entradaValida);

        return numeroUsuario;
    }

    public static void printString(String cadena) {
        System.out.println(cadena);
    }


}