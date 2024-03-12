package Interfaces;

public interface iDatos {

    static void saveToFile(String nombre, String nombreUsuario, String correo, String contraseña, String usuariosRegistrados) {

    }

    static boolean registeredUser(String nombreUsuario, String correo, String usuariosRegistrados) {
        return false;
    }

    static boolean verifyCredentials(String usuariosRegistrados, String nombreUsuario, String contraseña){
        return false;
    }



}
