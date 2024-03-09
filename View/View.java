package View;

import IO.Teclado;
import IO.Utils;
import Interfaces.iView;
import Model.Archivos.Datos;
import Model.Archivos.Sesion;
import Model.Entitys.Usuario;
import Model.Proyectos.Proyectos;
import Model.Proyectos.Tareas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class View implements iView {
    String d = "\u001B[0m"; // Stop print the color // Parar el color establecido
    String black = "\033[30m"; // Negro
    String red = "\033[31m"; // Rojo
    String green = "\033[32m"; // Verde
    String blue = "\033[34m"; // Blue
    String purple = "\033[35m"; // Morado

    @Override
    public void mensajesDeInicio() {
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena(
               red + "■■■■■■■     ■       ■■■■■     ■    ■          ■■■■■     ■          ■■■■      ■       ■■       ■ \n" +
                        "   ■       ■ ■      ■         ■   ■           ■         ■         ■    ■      ■     ■  ■     ■  \n" +
                        "   ■      ■■■■■     ■■■■■     ■ ■             ■■■■■     ■         ■    ■       ■   ■    ■   ■  \n" +
                        "   ■     ■     ■        ■     ■   ■           ■         ■         ■    ■        ■ ■      ■ ■   \n" +
                        "   ■    ■       ■   ■■■■■     ■     ■         ■         ■■■■■■     ■■■■          ■        ■     \n"+d);

        Teclado.imprimirCadena("");

    }

    @Override
    public int menuRegistroInicioSesion() {
        int opcion = 0;
        Teclado.imprimirCadena(purple+"◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥"+d);
        Teclado.imprimirCadena("Bienvenido a TaskFlow.");
        Teclado.imprimirCadena("Elige la opcion que desees usar: ");

        Teclado.imprimirCadena("1. Iniciar Sesión ");
        Teclado.imprimirCadena("2. Registrarse ");
        Teclado.imprimirCadena("3. Salir ");
        Teclado.imprimirCadena(purple+"◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥"+d);
        opcion = Teclado.leeEntero("Esperando respuesta: ");
        return opcion;
    }


    public static Usuario menuIniciarSesion() {
        boolean credencialesCorrectas = false;
        Usuario usuario = null;

        do {
            Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
            String nombreUsuario = Teclado.leeString("Introduzca su Usuario:");
            String contraseña = Teclado.leeString("Introduzca su contraseña");
            Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");

            credencialesCorrectas = Datos.verificarCredenciales("usuariosRegistrados", nombreUsuario, contraseña);

            if (!credencialesCorrectas) {
                Teclado.imprimirCadena("Credenciales incorrectas. Inténtalo de nuevo.");
            } else {
                usuario = new Usuario(nombreUsuario, contraseña, "", "");

            }
        } while (!credencialesCorrectas);

        return usuario;
    }


    @Override
    public Usuario menuRegistroUsuario() {
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("Introduzca los siguientes datos");
        String nombre, usuario, correo, contraseña;
        Usuario usuarioRegistrado = null;
        nombre = Teclado.leeString("Introduzca su nombre completo");
        usuario = Teclado.leeString("Introduzca su nombre de Usuario");
        correo = Teclado.leeString("Introduzca su email");
        while (!Usuario.validarCorreo(correo)) {
            Teclado.imprimirCadena("Correo no válido");
            correo = Teclado.leeString("Introduzca su email");}
        contraseña = Teclado.leeString("Introduzca su contraseña");
        contraseña = Utils.hashPassword(contraseña);
        Datos.guardarEnArchivo(nombre, usuario, correo, contraseña, "usuariosRegistrados");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");


        return usuarioRegistrado;
    }

    @Override
    public int eleccionCRUD() {
        int opcion = -1;
        do {
            Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
            Teclado.imprimirCadena("Elige la opcion que desees usar: ");

            Teclado.imprimirCadena("1. Listar proyecto");
            Teclado.imprimirCadena("2. Crear proyecto");
            Teclado.imprimirCadena("3. Borrar proyecto");
            Teclado.imprimirCadena("4. Listar Usuarios");
            Teclado.imprimirCadena("5. Salir y guardar");
            Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
            opcion = Teclado.leeEntero("Esperando respuesta: ");

        } while (opcion < 1 || opcion > 5);

        return opcion;
    }

    @Override
    public int menuCreador() {
        int opcion = -1;

        do {
            Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
            Teclado.imprimirCadena("Menú de Creador Proyecto");

            Teclado.imprimirCadena("1. Crear tarea");
            Teclado.imprimirCadena("2. Editar estado tarea");
            Teclado.imprimirCadena("3. Eliminar tarea");
            Teclado.imprimirCadena("4. Añadir comentario");
            Teclado.imprimirCadena("5. Volver al menú principal");
            Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
            opcion = Teclado.leeEntero("Esperando respuesta: ");


        } while (opcion < 1 || opcion > 5);

        return opcion;
    }


    @Override
    public int menuColaborador() {
        int opcion = -1;

        do {
            Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
            Teclado.imprimirCadena("MENU COLABORADOR");

            Teclado.imprimirCadena("1. Editar estado de la tarea");
            Teclado.imprimirCadena("2. Añadir comentario");
            Teclado.imprimirCadena("3. Volver al menú principal");

            opcion = Teclado.leeEntero("Esperando respuesta: ");
            Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");

        } while (opcion < 1 || opcion > 3);

        return opcion;
    }
    @Override
    public Proyectos viewBorrarProyecto() {
        Proyectos aux = new Proyectos();
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        aux.setNombre(Teclado.leeString("Introduce el nombre del proyecto que deseas borrar: "));
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        return aux;

    }
    @Override
    public Proyectos viewAñadirProjecto() {
        Proyectos aux = new Proyectos();

        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        String nombre = Teclado.leeString("Introduce el nombre de tu proyecto: ");
        aux.setNombre(nombre);
        String descripcion = Teclado.leeString("Introduce una descripcion de tu proyecto: ");

        aux.setDescripcion(descripcion);
        aux.setColaborador(aux.añadirColaborador());
        aux.setFechaInicio(LocalDate.now());
        aux.setFechaFinalizacion(Proyectos.añadirFechaFin());
        aux.setCreador(Sesion.getUsuarioIniciado());
        String respuesta;
        do {
            aux.setListaTareas(Tareas.agregarTarea(Tareas.crearTarea()));
            respuesta = Teclado.leeString("¿Desea añadir otra tarea? Si/No");
        } while (respuesta.equalsIgnoreCase("Si"));
        System.out.println(aux);



        return aux;
    }



    @Override
    public int eleccionListarProyecto() {
        int aux = 0;
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("1. Para listar todos");
        Teclado.imprimirCadena("2. Para listar por nombre");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        aux = Teclado.leeEntero("Esperando respuesta: ");

        return aux;


    }

    @Override
    public int estadoTareas() {
        int opcion = 0;
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("1. Tarea sin iniciar");
        Teclado.imprimirCadena("2. Tarea en tramite");
        Teclado.imprimirCadena("3. Tarea finalizada");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        opcion = Teclado.leeEntero("Esperando respuesta: ");
        return opcion;
    }


    @Override
    public String nombreTarea() {
        Tareas tareasaux = new Tareas();
        tareasaux.setNombre(Teclado.leeString("Dime el nombre de la tarea: "));
        return tareasaux.getNombre();

    }


}

