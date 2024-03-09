package Interfaces;

public interface iDatos {

    static void guardarEnArchivo(String nombre, String nombreUsuario, String correo, String contraseña, String usuariosRegistrados) {

    }

    static boolean usuarioRegistrado(String nombreUsuario, String correo, String usuariosRegistrados) {
        return false;
    }

    static boolean verificarCredenciales(String usuariosRegistrados, String nombreUsuario, String contraseña){
        return false;
    }



}
