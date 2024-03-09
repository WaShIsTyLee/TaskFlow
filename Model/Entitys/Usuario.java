package Model.Entitys;


import IO.Teclado;
import Interfaces.iUsuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

public class Usuario implements iUsuario, Serializable {
    private String nombre;
    private String usuario;
    private String contraseña;
    private String correo;



    public Usuario(String nombre, String usuario, String contraseña, String correo) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correo = correo;


    }
    public Usuario(){
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
        Usuario usuario = (Usuario) o;
        return Objects.equals(getUsuario(), usuario.getUsuario()) ||
                Objects.equals(getCorreo(), usuario.getCorreo());    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }


    public static void listarUsuarios(String usuariosRegistrados) {
        try (BufferedReader reader = new BufferedReader(new FileReader(usuariosRegistrados))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                Teclado.imprimirCadena("-----------Usuario-----------");
                Teclado.imprimirCadena("Nombre: "+partes[0].trim());
                Teclado.imprimirCadena("Usuario: "+partes[1].trim());
                Teclado.imprimirCadena("-----------------------------");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
