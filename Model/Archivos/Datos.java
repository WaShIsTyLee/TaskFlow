package Model.Archivos;


import IO.Utils;
import Interfaces.iDatos;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Metodos relacionados con el manejo de datos dentro del progrma.
 *
 */
public class Datos implements iDatos {

    /**
     * @param nombre un nombre de una persona (por ejemplo paquito)
     * @param nombreUsuario el nombre de un usuario, dato unico
     * @param correo un correo, sige la estructura de ...@gmail.com, dato unico
     * @param contraseña una  contraseña (por ejemplo 1234567891011121314151617181920)
     * @param usuariosRegistrados el nombre del archivo donde se va a guardar
     */
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

    /**
     *
     * @param nombreUsuario un nombre de usuario, dato unico
     * @param correo un correo, sige la estrcutura de .....@gmail.com, dato unico
     * @param usuariosRegistrados el arcivo donde guardamos los usuarios
     * @return
     */

    private static boolean usuarioRegistrado(String nombreUsuario, String correo, String usuariosRegistrados) {
        boolean usuarioRegistrado = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(usuariosRegistrados))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[1].equals(nombreUsuario) || datos[3].equals(correo)) {
                    usuarioRegistrado = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return usuarioRegistrado;
    }

    /**
     *
     * @param usuariosRegistrados el archivo donde guardamos a los usuarios
     * @param nombreUsuario el nombre de usario, dato unico
     * @param contraseña la contraseña perteneciente al usauario itroducido
     * @return
     */
    public static boolean verificarCredenciales(String usuariosRegistrados, String nombreUsuario, String contraseña) {
        boolean credencialesValidas = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(usuariosRegistrados))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 3) {
                    String usuarioRegistrado = partes[1].trim();
                    String contraseñaRegistrada = partes[2].trim();
                    if (usuarioRegistrado.equals(nombreUsuario) && contraseñaRegistrada.equals(Utils.hashPassword(contraseña))) {
                        credencialesValidas = true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return credencialesValidas;
    }




}