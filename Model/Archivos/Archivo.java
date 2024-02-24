package Model.Archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo {
    /**
     * Logica para guardar Usuarios en un archivo llamado usuariosRegistrados
     *
     * @param nombreUsuario       Nombre de usuario a guardar
     * @param contraseña          Contraseña a guardar
     * @param usuariosRegistrados Nombre del archivo donde se guardarán los usuarios
     */
    public static void guardarEnArchivo(String nombreUsuario, String contraseña, String usuariosRegistrados, String correo) {
        try (FileWriter writer = new FileWriter(usuariosRegistrados, true)) {
            writer.write(nombreUsuario + "," + contraseña + "\n");
            System.out.println("Usuario registrado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar usuario en el archivo: " + e.getMessage());
        }
    }

    /**
     * Logica para leer el archivo usuariosRegistrados y dar acceso al iniciar sesion
     *
     * @param usuariosRegistrados Nombre del archivo donde se encuentran los usuarios registrados
     * @param nombreUsuario       Nombre de usuario a verificar
     * @param contraseña          Contraseña a verificar
     * @return true si las credenciales son válidas, false si no lo son
     */
    public static boolean verificarCredenciales(String usuariosRegistrados, String nombreUsuario, String contraseña, String correo) {
        boolean credencialesValidas = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(usuariosRegistrados))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3 && partes[0].equals(nombreUsuario) && partes[1].equals(contraseña) && partes[2].equals(correo)) {
                    credencialesValidas = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return credencialesValidas;
    }
}
