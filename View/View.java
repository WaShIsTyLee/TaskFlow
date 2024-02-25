package View;

import IO.Teclado;
import Interfaces.iView;
import Model.Archivos.Archivo;
import Model.Entitys.Usuario;


public class View implements iView {
    @Override
    public int menuRegistroInicioSesion() {
        int opcion = 0;
        boolean entradaValida = false;

        do {
            System.out.println("1. Iniciar Sesión");
                System.out.println("2. Registrarse");
                opcion = Teclado.leeEntero("");

                switch (opcion) {
                    case 1:
                        System.out.println("Iniciando Sesión...");
                        entradaValida = true;
                        break;
                    case 2:
                        System.out.println("Registrándose...");
                        entradaValida = true;
                        break;
                    default:
                        System.out.println("Error, introduce 1 o 2.");
                }

        } while (!entradaValida);

        return opcion;
    }


    @Override
        public void menuIniciarSesion () {
            // Tenemos que tocarlo para saber si el user y la contraseña existe
            System.out.println("Usuario");
            System.out.println("Contraseña");
        }

        @Override
        public Usuario menuRegistroUsuario() {
            Teclado.imprimirCadena("Introduzca los siguientes datos");
            String nombre, usuario, correo, contraseña;
            Usuario usuarioRegistrado = null;
            boolean credencialesValidas = false;

            while (!credencialesValidas) {
                nombre = Teclado.leeString("Introduzca su nombre completo");
                usuario = Teclado.leeString("Introduzca su nombre de Usuario");
                correo = Teclado.leeString("Introduzca su gmail");
                contraseña = Teclado.leeString("Introduzca su contraseña");

                // Verificar si el nombre de usuario o el correo ya están registrados
                if (!Archivo.verificarCredenciales("usuariosRegistrados", usuario, contraseña)) {
                    usuarioRegistrado = new Usuario(nombre, usuario, contraseña, correo, "");
                    Archivo.guardarEnArchivo(usuarioRegistrado.getNombre(), usuarioRegistrado.getUsuario(), usuarioRegistrado.getContraseña(), usuarioRegistrado.getCorreo(), "usuariosRegistrados");
                    credencialesValidas = true;
                } else {
                    System.out.println("El usuario o el correo electrónico ya están en uso. Por favor, elija otro.");
                }
            }
            return usuarioRegistrado;
        }
    }
