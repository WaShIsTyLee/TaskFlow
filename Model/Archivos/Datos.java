package Model.Archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Datos {

    public static void guardarEnArchivo(String nombre, String nombreUsuario, String correo, String contraseña, String usuariosRegistrados) {

        if (usuarioRegistrado(nombreUsuario, correo, usuariosRegistrados)) {
            System.out.println("El nombre de usuario o el correo ya están registrados.");

        } else {
            try (FileWriter writer = new FileWriter(usuariosRegistrados, true)) {
                writer.write(nombre + "," + nombreUsuario + "," + contraseña + "," + correo + "\n");
                System.out.println("Usuario registrado correctamente.");
            } catch (IOException e) {
                System.out.println("Error al guardar usuario en el archivo: " + e.getMessage());
            }
        }

    }

    private static boolean usuarioRegistrado(String nombreUsuario, String correo, String usuariosRegistrados) {
        boolean usuarioRegistrado = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(usuariosRegistrados))) {
            String linea;
            while ((linea = reader.readLine()) != null){
                String[] datos = linea.split(",");
                if (datos[1].equals(nombreUsuario) || datos[3].equals(correo)) {
                    usuarioRegistrado = true;
                    break; // Salir del bucle tan pronto como se encuentre un usuario con el mismo correo
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return usuarioRegistrado;
    }

    public static boolean verificarCredenciales(String usuariosRegistrados, String nombreUsuario, String contraseña) {
        boolean credencialesValidas = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(usuariosRegistrados))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 3) {
                    String usuarioRegistrado = partes[1].trim();
                    String contraseñaRegistrada = partes[2].trim();
                    if (usuarioRegistrado.equals(nombreUsuario) && contraseñaRegistrada.equals(contraseña)) {
                        credencialesValidas = true;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return credencialesValidas;
    }
}
