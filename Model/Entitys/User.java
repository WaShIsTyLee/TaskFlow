package Model.Entitys;


import IO.Keyboard;
import Interfaces.iUsuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

public class User implements iUsuario, Serializable { /**
 * Metodos relacionados con el manejo de la clase usuario dentro del progrma.
 *
 */

    private String name;
    private String user;
    private String password;
    private String mail;



    public User(String name, String user, String password, String mail) {
        this.name = name;
        this.user = user;
        this.password = password;
        this.mail = mail;


    }
    public User(){
        this("","","","");
    }

    /**
     * Validar si una cadena es un correo electrónico válido.
     * Validates if a string is a valid email address.
     * @param email Un correo electrónico que se va a validar.
     *              An email address to be validated.
     */
    public static boolean validateMail(String email) {

        return email.matches("^([\\w-]+\\.)*?[\\w-]+@[\\w-]+\\.([\\w-]+\\.)*?[\\w]+$");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getUser(), user.getUser()) ||
                Objects.equals(getMail(), user.getMail());    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Lista los usuarios registrados en un archivo.
     * Lists the registered users from a file.
     * @param usuariosRegistrados El archivo donde están guardados los usuarios.
     */
    public static void listUsers(String usuariosRegistrados) {
        try (BufferedReader reader = new BufferedReader(new FileReader(usuariosRegistrados))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                Keyboard.printString("-----------User-----------");
                Keyboard.printString("Nombre: "+partes[0].trim());
                Keyboard.printString("User: "+partes[1].trim());
                Keyboard.printString("-----------------------------");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
