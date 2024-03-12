package Model.Archivos;


import IO.Utils;
import Interfaces.iDatos;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Metodos relacionados con el manejo de datos dentro del programa.
 */

public class Data implements iDatos {

    /**
     * Guarda en el archivo los siguientes parámetros, los parámetros son de un User, faltaria crear
     * un User en lugar de pasar los parámetros
     * Save the following parameters in the file, the parameters are from a User, it would be necessary to create
     * a User instead of passing parameters
     * @param nombre un nombre de una persona (por ejemplo paquito)
     * @param nombreUsuario el nombre de un usuario, dato unico
     * @param correo un correo, sige la estructura de ...@gmail.com, dato unico
     * @param contraseña una contraseña (por ejemplo 1234567891011121314151617181920)
     * @param usuariosRegistrados el nombre del archivo donde se va a guardar
     */
    public static void saveInFile(String nombre, String nombreUsuario, String correo, String contraseña, String usuariosRegistrados) {

        if (registeredUser(nombreUsuario, correo, usuariosRegistrados)) {
            System.out.println("El nombre de usuario o el correo ya están registrados.");

        } else {
            try (FileWriter writer = new FileWriter(usuariosRegistrados, true)) {
                writer.write(nombre + "," + nombreUsuario + "," + contraseña + "," + correo + "\n");
                System.out.println("User registrado correctamente.");

            } catch (IOException e) {
                System.out.println("Error al guardar usuario en el archivo: " + e.getMessage());
            }
        }

    }

    /**
     * Comprobación de los saveInFile usados en la función saveInFile
     * @param nombreUsuario un nombre de usuario, dato unico
     * @param correo un correo que sigue la estructura de .....@gmail.com, dato único
     * @param usuariosRegistrados el archivo donde guardamos los usuarios
     * @return
     */

    private static boolean registeredUser(String nombreUsuario, String correo, String usuariosRegistrados) {
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
     * Verifica los credenciales al iniciar sesión con un User
     * Verify credentials when logging in with a User
     * @param usuariosRegistrados el archivo donde guardamos a los usuarios
     * @param nombreUsuario el nombre de usuario, dato único
     * @param contraseña la contraseña perteneciente al usuario introducido
     * @return
     */
    public static boolean verifyCredentials(String usuariosRegistrados, String nombreUsuario, String contraseña) {
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