package View;

import IO.Teclado;
import Interfaces.iView;
import Model.Archivos.Archivo;
import Model.Entitys.Usuario;


public class View implements iView {
    @Override
    public int menuRegistroInicioSesion() {
        int opcion;
        System.out.println("1. Iniciar Sesion");
        System.out.println("2. Registrarse");
        opcion = Teclado.leeEntero("");
        do {
            switch (opcion) {
                case 1:
                    System.out.println("Iniciando Sesión...");
                    break;
                case 2:
                    System.out.println("Registrandose...");
                    break;
                default:
                    System.out.println("Error, introduce 1 o 2.");
            }
            return opcion;
        }while (opcion !=1 || opcion !=2);
    }

    @Override
    public void menuIniciarSesion() {
        // Tenemos que tocarlo para saber si el user y la contraseña existe
        System.out.println("Usuario");
        System.out.println("Contraseña");
    }

    @Override
    public Usuario menuRegistroUsuario() {
        boolean aux = false;
        do {
            Teclado.imprimirCadena("Introduzca los siguientes datos");
            String nombre = Teclado.leeString("Introduzca su nombre completo");
            String usuario = Teclado.leeString("Introduzca su nombre de Usuario");
            String correo = Teclado.leeString("Introduzca su gmail");
            String contraseña = Teclado.leeString("Introduzca su contraseña");

            Usuario usuarioRegistrado = null; // Inicializamos como null

            if (!Archivo.verificarCredenciales("usuariosRegistrados", usuario, "", "") &&
                    !Archivo.verificarCredenciales("usuariosRegistrados", "", "", correo)) {
                usuarioRegistrado = new Usuario(nombre, usuario, contraseña, correo, "");
                Archivo.guardarEnArchivo(usuarioRegistrado.getUsuario(), usuarioRegistrado.getContraseña(), "usuariosRegistrados", usuarioRegistrado.getCorreo());
                aux = true;
            } else {
                System.out.println("El usuario o el correo electrónico ya están en uso. Por favor, elija otro.");
            }
            return usuarioRegistrado;
        } while (aux != false);
    }
}

