package IO;

import Interfaces.iTeclado;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Keyboard implements iTeclado {
    private static Scanner teclado = new Scanner(System.in);

    public static String readString(String cadena) {

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