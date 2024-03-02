package View;

import IO.Teclado;
import Interfaces.iView;
import Model.Archivos.Datos;
import Model.Entitys.Usuario;
import Model.Proyectos.Projectos;

import java.io.Console;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class View implements iView {
    Console console = System.console();


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
            credencialesCorrectas = Datos.verificarCredenciales("usuariosRegistrados", usuario, contraseña);

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
        while (!Usuario.validarCorreo(correo)) {
            Teclado.imprimirCadena("Correo no válido");
            correo = Teclado.leeString("Introduzca su email");
        }
        contraseña = Teclado.leeString("Introduzca su contraseña");
        Datos.guardarEnArchivo(nombre, usuario, correo, contraseña, "usuariosRegistrados");

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
            Teclado.imprimirCadena("4. Salir y guardar");
            opcion = Teclado.leeEntero("");
        } while (opcion < 1 || opcion > 4);

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

    @Override
    public int menuCRUDcreador() {
        return 0;
    }

    @Override
    public int menuColaborador(Projectos projecto) {
        return 0;
    }

        public Projectos añadirProjecto() {
            Projectos aux = new Projectos();
            String nombre = Teclado.leeString("Introduce el nombre de tu proyecto: ");
            aux.setNombre(nombre);
            String descripcion = Teclado.leeString("Introduce una descripcion de tu proyecto: ");
            aux.setDescripcion(descripcion);
            String colaborador = Teclado.leeString("Introduce el nombre del colaborador: ");
            aux.setColaborador(colaborador);
           // aux.getListaTareas();
            aux.setFechaInicio(LocalDate.now());
            aux.setFechaFinalizacion(añadirFechaFin());

            System.out.println(aux);
        return aux;
    }
    private static LocalDate añadirFechaFin() {
        LocalDateTime ahora = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaActualStr = formatter.format(ahora);

        LocalDate fechaFinalizacion = null;

        while (fechaFinalizacion == null) {
            String fechaFinalizacionStr = Teclado.leeString("Introduce la fecha de finalización (formato AAAA-MM-DD):");

            if (fechaFinalizacionStr.matches("\\d{4}-\\d{2}-\\d{2}") && fechaFinalizacionStr.compareTo(fechaActualStr) >= 0) {
                fechaFinalizacion = LocalDate.parse(fechaFinalizacionStr, formatter);
            } else {
                System.out.println("Error: La fecha de finalización no puede ser anterior a la fecha actual o el formato es incorrecto. " +
                        "Por favor, inténtalo de nuevo.");
            }
        }

        return fechaFinalizacion;
    }
}

