package IO;

import Interfaces.iTeclado;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Teclado implements iTeclado {
    private static Scanner teclado = new Scanner(System.in);

    public static String leeString(String cadena) {

        String cadenaUsuario;
        System.out.println(cadena);
        cadenaUsuario = teclado.nextLine();
        if (cadenaUsuario.isEmpty() || cadenaUsuario.isBlank()) {
            do {
                Teclado.imprimirCadena("No intentes meter un espacio en blanco");
                cadenaUsuario = teclado.nextLine();
            } while (cadenaUsuario.isEmpty() || cadenaUsuario.isBlank());
        }
        return cadenaUsuario;
    }

    public static int leeEntero(String cadena) {
        int numeroUsuario = 0;
        boolean entradaValida = false;
        imprimirCadena(cadena);
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

    public static void imprimirCadena(String cadena) {
        System.out.println(cadena);
    }


}