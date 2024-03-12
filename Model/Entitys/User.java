package Model.Entitys;


import IO.Keyboard;
import Interfaces.iUsuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

public class User implements iUsuario, Serializable {
    private String nombre;
    private String usuario;
    private String contraseña;
    private String correo;



    public User(String nombre, String usuario, String contraseña, String correo) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correo = correo;


    }
    public User(){
        this("","","","");
    }

    public static boolean validarCorreo(String email) {

        return email.matches("^([\\w-]+\\.)*?[\\w-]+@[\\w-]+\\.([\\w-]+\\.)*?[\\w]+$");

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getUsuario(), user.getUsuario()) ||
                Objects.equals(getCorreo(), user.getCorreo());    }

    @Override
    public String toString() {
        return  nombre;
    }


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
