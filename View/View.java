package View;

import Controller.MainController;
import IO.Teclado;
import Interfaces.iView;
import Model.Entitys.Usuario;
import Controller.MainController;
import Model.Archivos.Datos;


public class View implements iView {


    @Override
    public void mensajesDeInicio() {

        Teclado.imprimirCadena(
                "■■■■■■■     ■       ■■■■■     ■    ■          ■■■■■     ■          ■■■■      ■       ■■       ■ \n" +
                        "   ■       ■ ■      ■         ■   ■           ■         ■         ■    ■      ■     ■  ■     ■  \n" +
                        "   ■      ■■■■■     ■■■■■     ■ ■             ■■■■■     ■         ■    ■       ■   ■    ■   ■  \n" +
                        "   ■     ■     ■        ■     ■   ■           ■         ■         ■    ■        ■ ■      ■ ■   \n" +
                        "   ■    ■       ■   ■■■■■     ■     ■         ■         ■■■■■■     ■■■■          ■        ■    \n");

        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("Bienvenido a TaskFlow...");
    }

    @Override
    public int menuRegistroInicioSesion() {   //ACABAO
        int opcion = 0;
        Teclado.imprimirCadena("Elige la opcion que desees usar: ");
        Teclado.imprimirCadena("1. Iniciar Sesión");
        Teclado.imprimirCadena("2. Registrarse");
        opcion = Teclado.leeEntero("");

        return opcion;
    }


    @Override
    public void menuIniciarSesion() {    //ACABAO
        boolean credencialesCorrectas = false;

        do {
            String usuario = Teclado.leeString("Introduzca su Usuario:");
            String contraseña = Teclado.leeString("Introduzca su contraseña");
            credencialesCorrectas = Datos.verificarCredenciales("usuariosRegistrados",usuario, contraseña);

            if (!credencialesCorrectas) {
                Teclado.imprimirCadena("Credenciales incorrectas. Inténtalo de nuevo.");

            }
        } while (!credencialesCorrectas);
    }


    @Override
    public Usuario menuRegistroUsuario() {

        Teclado.imprimirCadena("Introduzca los siguientes datos");
        String nombre, usuario, correo, contraseña;
        Usuario usuarioRegistrado = null;

            nombre = Teclado.leeString("Introduzca su nombre completo");
            usuario = Teclado.leeString("Introduzca su nombre de Usuario");
            correo = Teclado.leeString("Introduzca su email");
            Usuario.validarCorreo(correo);
            contraseña = Teclado.leeString("Introduzca su contraseña");
            Datos.guardarEnArchivo(nombre,usuario,correo,contraseña,"usuariosRegistrados");

        return usuarioRegistrado;
    }

    @Override
    public int eleccionCRUD() {
        int opcion = -1;
        do {
            Teclado.imprimirCadena("Elige la opcion que desees usar: ");
            Teclado.imprimirCadena("1. Listar proyecto");
            Teclado.imprimirCadena("2. Crear proyecto");
            Teclado.imprimirCadena("3. Borrar proyecto");
            Teclado.imprimirCadena("4. Organizar tareas");
            Teclado.imprimirCadena("5. Salir y guardar");
            opcion = Teclado.leeEntero("");
        } while (opcion < 1 || opcion > 5);

        return opcion;
    }

    @Override
    public int tareasProyecto() {
        int opcion = -1;

        do {
            Teclado.imprimirCadena("Menú de Tareas del Proyecto");
            Teclado.imprimirCadena("1. Crear tarea");
            Teclado.imprimirCadena("2. Editar tarea");
            Teclado.imprimirCadena("3. Eliminar tarea");
            Teclado.imprimirCadena("4. Ver lista de tareas");
            Teclado.imprimirCadena("5. Volver al menú principal");
            opcion = Teclado.leeEntero("");

        } while (opcion < 1 || opcion > 5);

        return opcion;
    }

}