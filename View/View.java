package View;

import IO.Teclado;
import IO.Utils;
import Interfaces.iView;
import Model.Archivos.Datos;
import Model.Entitys.Colaborador;
import Model.Entitys.Usuario;
import Model.Proyectos.Proyectos;
import Model.Proyectos.Tareas;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


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
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("Elige la opcion que desees usar: ");
        Teclado.imprimirCadena("*********************************");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena(".................. ");
        Teclado.imprimirCadena("1. Iniciar Sesión ");
        Teclado.imprimirCadena(".................. ");
        Teclado.imprimirCadena("2. Registrarse ");
        Teclado.imprimirCadena(".................. ");
        Teclado.imprimirCadena("3. Salir ");
        Teclado.imprimirCadena(".................. ");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("");
        opcion = Teclado.leeEntero("Esperando respuesta: ");
        Teclado.imprimirCadena("");

        return opcion;
    }


    @Override
    public void menuIniciarSesion() {    //ACABAO
        boolean credencialesCorrectas = false;

        do {
            Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
            Teclado.imprimirCadena("");
            String usuario = Teclado.leeString("Introduzca su Usuario:");
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("*********************************");
            Teclado.imprimirCadena("");
            String contraseña = Teclado.leeString("Introduzca su contraseña");
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("*********************************");
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
            Teclado.imprimirCadena("");
            credencialesCorrectas = Datos.verificarCredenciales("usuariosRegistrados", usuario, contraseña);

            if (!credencialesCorrectas) {
                Teclado.imprimirCadena("Credenciales incorrectas. Inténtalo de nuevo.");

            }
        } while (!credencialesCorrectas);
    }


    @Override
    public Usuario menuRegistroUsuario() {
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("Introduzca los siguientes datos");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("*********************************");
        Teclado.imprimirCadena("");
        String nombre, usuario, correo, contraseña;
        Usuario usuarioRegistrado = null;

        nombre = Teclado.leeString("Introduzca su nombre completo");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("*********************************");
        Teclado.imprimirCadena("");
        usuario = Teclado.leeString("Introduzca su nombre de Usuario");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("*********************************");
        Teclado.imprimirCadena("");
        correo = Teclado.leeString("Introduzca su email");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("*********************************");
        Teclado.imprimirCadena("");
        while (!Usuario.validarCorreo(correo)) {
            Teclado.imprimirCadena("Correo no válido");
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("*********************************");
            Teclado.imprimirCadena("");
            correo = Teclado.leeString("Introduzca su email");
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("*********************************");
            Teclado.imprimirCadena("");
        }
        contraseña = Teclado.leeString("Introduzca su contraseña");
       contraseña=Utils.hashPassword(contraseña);
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("*********************************");
        Teclado.imprimirCadena("");

        Datos.guardarEnArchivo(nombre, usuario, correo, contraseña, "usuariosRegistrados");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("");

        return usuarioRegistrado;
    }

    @Override
    public int eleccionCRUD() {
        int opcion = -1;
        do {
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("Elige la opcion que desees usar: ");
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("*********************************");
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena(".................. ");
            Teclado.imprimirCadena("1. Listar proyecto");
            Teclado.imprimirCadena(".................. ");
            Teclado.imprimirCadena("2. Crear proyecto");
            Teclado.imprimirCadena(".................. ");
            Teclado.imprimirCadena("3. Borrar proyecto");
            Teclado.imprimirCadena(".................. ");
            Teclado.imprimirCadena("4. Listar Usuarios");
            Teclado.imprimirCadena(".................. ");
            Teclado.imprimirCadena("5. Salir y guardar");
            Teclado.imprimirCadena(".................. ");
            Teclado.imprimirCadena("");
            opcion = Teclado.leeEntero("Esperando respuesta: ");
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
            Teclado.imprimirCadena("");
        } while (opcion < 1 || opcion > 5);

        return opcion;
    }

    @Override
    public int tareasProyecto() {
        int opcion = -1;

        do {
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("Menú de Tareas del Proyecto");
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("*********************************");
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("............................ ");
            Teclado.imprimirCadena("1. Crear tarea");
            Teclado.imprimirCadena("............................ ");
            Teclado.imprimirCadena("2. Editar tarea");
            Teclado.imprimirCadena("............................ ");
            Teclado.imprimirCadena("3. Eliminar tarea");
            Teclado.imprimirCadena("............................ ");
            Teclado.imprimirCadena("4. Ver lista de usuarios");
            Teclado.imprimirCadena("............................ ");
            Teclado.imprimirCadena("5. Volver al menú principal");
            Teclado.imprimirCadena("............................ ");
            Teclado.imprimirCadena("");
            opcion = Teclado.leeEntero("Esperando respuesta: ");
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
            Teclado.imprimirCadena("");

        } while (opcion < 1 || opcion > 5);

        return opcion;
    }

    @Override
    public int menuCRUDcreador() {
        return 0;
    }

    @Override
    public int menuColaborador(Proyectos projecto) {
        int opcion = -1;

        do {
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("Menú de Colaborador del proyecto");
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("*********************************");
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("............................ ");
            Teclado.imprimirCadena("1. Editar estado de la tarea");
            Teclado.imprimirCadena("............................ ");
            Teclado.imprimirCadena("2. Añadir comentario");
            Teclado.imprimirCadena("............................ ");
            Teclado.imprimirCadena("3. Volver al menú principal");
            Teclado.imprimirCadena("............................ ");
            Teclado.imprimirCadena("");
            opcion = Teclado.leeEntero("Esperando respuesta: ");
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
            Teclado.imprimirCadena("");

        } while (opcion < 1 || opcion > 3);

        return opcion;
    }

    public Proyectos viewBorrarProyecto() {
        Proyectos aux = new Proyectos();
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("");
        aux.setNombre(Teclado.leeString("Introduce el nombre del proyecto que deseas borrar: "));
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("");
        return aux;

    }

    public Proyectos viewAñadirProjecto() {
        Proyectos aux = new Proyectos();
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("*********************************");
        Teclado.imprimirCadena("");
        String nombre = Teclado.leeString("Introduce el nombre de tu proyecto: ");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("*********************************");
        Teclado.imprimirCadena("");
        aux.setNombre(nombre);
        String descripcion = Teclado.leeString("Introduce una descripcion de tu proyecto: ");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("*********************************");
        Teclado.imprimirCadena("");
        aux.setDescripcion(descripcion);
        aux.setColaborador(aux.añadirColaborador());
        aux.setFechaInicio(LocalDate.now());
        aux.setFechaFinalizacion(añadirFechaFin());
        aux.setCreador(Datos.obtenerUltimoUsuario("usuariosRegistrados"));
        String respuesta;
        do{
            aux.setListaTareas(Tareas.agregarTarea(Tareas.crearTarea()));
            respuesta = Teclado.leeString("¿Desea añadir otra tarea? Si/No");
        }while(respuesta.equalsIgnoreCase("Si"));
                System.out.println(aux);


        return aux;
    }


    private static LocalDate añadirFechaFin() {
        LocalDateTime ahora = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaActualStr = formatter.format(ahora);

        LocalDate fechaFinalizacion = null;

        while (fechaFinalizacion == null) {
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("*********************************");
            Teclado.imprimirCadena("");
            String fechaFinalizacionStr = Teclado.leeString("Introduce la fecha de finalización (formato AAAA-MM-DD):");

            if (fechaFinalizacionStr.matches("\\d{4}-\\d{2}-\\d{2}") && fechaFinalizacionStr.compareTo(fechaActualStr) >= 0) {
                fechaFinalizacion = LocalDate.parse(fechaFinalizacionStr, formatter);
            } else {

                Teclado.imprimirCadena("*********************************");
                Teclado.imprimirCadena("");
                System.out.println("Error: La fecha de finalización no puede ser anterior a la fecha actual o el formato es incorrecto. " +
                        "Por favor, inténtalo de nuevo.");
                Teclado.imprimirCadena("");
                Teclado.imprimirCadena("*********************************");
                Teclado.imprimirCadena("");
            }
        }
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("");
        return fechaFinalizacion;
    }

    public int eleccionListarProyecto() {
        int aux = 0;
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("1. Para listar todos");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("*********************************");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("2. Para listar por nombre");
        Teclado.imprimirCadena("");
        aux = Teclado.leeEntero("Esperando respuesta: ");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("");
        return aux;


    }

    public Tareas viewAñadirTarea(){
        Tareas aux = new Tareas();
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("");
        aux.setNombre(Teclado.leeString("Dame el nombre de tu tarea: "));
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("*********************************");
        Teclado.imprimirCadena("");
        aux.setDescripcion(Teclado.leeString("Dame la descripción de tu tarea: "));
        aux.setFechaInicio(LocalDate.now());
        aux.setFechaLimite(añadirFechaFin());
        aux.setEstadoTareas(Tareas.imprimirEstadoTareas(estadoTareas()));
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("");
        return aux;
    }

    public int estadoTareas(){
        int opcion = 0;
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("1. Tarea sin iniciar");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("*********************************");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("2. Tarea en tramite");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("*********************************");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("3. Tarea finalizada");
        Teclado.imprimirCadena("");
        opcion = Teclado.leeEntero("Esperando respuesta: ");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("");
        return opcion;
    }

    public int menuCrudTareas() {
        int opcion = 0;
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("Elige la opcion que desees usar: ");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("*********************************");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("............................ ");
        Teclado.imprimirCadena("1. Crear una tarea ");
        Teclado.imprimirCadena("............................ ");
        Teclado.imprimirCadena("2. Actualizar la tarea ");
        Teclado.imprimirCadena("............................ ");
        Teclado.imprimirCadena("3. Eliminar la tarea ");
        Teclado.imprimirCadena("............................ ");
        Teclado.imprimirCadena("");
        opcion = Teclado.leeEntero("Esperando respuesta: ");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("");
        return opcion;
    }


    public int estadoTareas() {
        int opcion = 0;
        Teclado.imprimirCadena("1. Tarea sin iniciar");
        Teclado.imprimirCadena("2. Tarea en tramite");
        Teclado.imprimirCadena("3. Tarea finalizada");
        opcion = Teclado.leeEntero("");
        return opcion;
    }


    public Tareas nombreTarea() {
        Tareas tareasaux = new Tareas();
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("");
        Teclado.leeString("Dime el nombre de la tarea que deseas eliminar: ");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("*********************************");
        Teclado.imprimirCadena("");
        tareasaux.setNombre(Teclado.leeString("Dime el nombre de la tarea: "));
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥");
        Teclado.imprimirCadena("");
        return tareasaux;
    }


}

