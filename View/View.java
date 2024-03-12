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


public class View implements iView {
    static String d = "\u001B[0m"; // Stop print the color // Parar el color establecido
    static String black = "\033[30m"; // Negro
    static String red = "\033[31m"; // Rojo
    static String green = "\033[32m"; // Verde
    static String blue = "\033[34m"; // Blue
    static String purple = "\033[35m"; // Morado

    /**
     * Imprime un mensaje gigante de incio
     */
    @Override
    public void mensajesDeInicio() {
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena(
                red + "■■■■■■■     ■       ■■■■■     ■    ■          ■■■■■     ■          ■■■■      ■       ■■       ■ \n" +
                        "   ■       ■ ■      ■         ■   ■           ■         ■         ■    ■      ■     ■  ■     ■  \n" +
                        "   ■      ■■■■■     ■■■■■     ■ ■             ■■■■■     ■         ■    ■       ■   ■    ■   ■  \n" +
                        "   ■     ■     ■        ■     ■   ■           ■         ■         ■    ■        ■ ■      ■ ■   \n" +
                        "   ■    ■       ■   ■■■■■     ■     ■         ■         ■■■■■■     ■■■■          ■        ■     \n" + d);

        Teclado.imprimirCadena("");
    }

    /**
     * Imprime el menu de registro y de inicio de  sesion
     * @return
     */
    @Override
    public int menuRegistroInicioSesion() {
        int opcion = 0;
        Teclado.imprimirCadena(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        Teclado.imprimirCadena("Bienvenido a TaskFlow.");
        Teclado.imprimirCadena("Elige la opcion que desees usar: ");

        Teclado.imprimirCadena("1. Iniciar Sesión ");
        Teclado.imprimirCadena("2. Registrarse ");
        Teclado.imprimirCadena("3. Salir ");
        Teclado.imprimirCadena(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        opcion = Teclado.leeEntero("Esperando respuesta: ");
        return opcion;
    }

    /**
     * imprime el menu de incio de sesion
     * @return
     */
    public static Usuario menuIniciarSesion() {
        boolean credencialesCorrectas = false;
        Usuario usuario = null;

        do {
            Teclado.imprimirCadena(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
            String nombreUsuario = Teclado.leeString("Introduzca su Usuario:");
            String contraseña = Teclado.leeString("Introduzca su contraseña");
            Teclado.imprimirCadena(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);

            credencialesCorrectas = Datos.verificarCredenciales("usuariosRegistrados", nombreUsuario, contraseña);

            if (!credencialesCorrectas) {
                Teclado.imprimirCadena("Credenciales incorrectas. Inténtalo de nuevo.");
            } else {
                usuario = new Usuario(nombreUsuario, contraseña, "", "");

            }
        } while (!credencialesCorrectas);

        return usuario;
    }

    /**
     * imprime el menu de registro de usuario
     * @return
     */
    @Override
    public Usuario menuRegistroUsuario() {
        Teclado.imprimirCadena(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
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
        contraseña = Utils.hashPassword(contraseña);
        Datos.guardarEnArchivo(nombre, usuario, correo, contraseña, "usuariosRegistrados");
        Teclado.imprimirCadena(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        return usuarioRegistrado;
    }

    /**
     * Imprime el menu de elecion crud
     * @return
     */
    @Override
    public int eleccionCRUD() {
        int opcion = -1;
        do {
            Teclado.imprimirCadena(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
            Teclado.imprimirCadena("Elige la opcion que desees usar: ");
            Teclado.imprimirCadena("1. Listar proyecto");
            Teclado.imprimirCadena("2. Crear proyecto");
            Teclado.imprimirCadena("3. Borrar proyecto");
            Teclado.imprimirCadena("4. Listar Usuarios");
            Teclado.imprimirCadena("5. Salir y guardar");
            Teclado.imprimirCadena(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
            opcion = Teclado.leeEntero("Esperando respuesta: ");

        } while (opcion < 1 || opcion > 5);

        return opcion;
    }

    /**
     * imprime el menu de creador
     * @return
     */
    @Override
    public int menuCreador() {
        int opcion = -1;

        do {
            Teclado.imprimirCadena(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
            Teclado.imprimirCadena("Menú de Creador Proyecto");

            Teclado.imprimirCadena("1. Crear tarea");
            Teclado.imprimirCadena("2. Editar estado tarea");
            Teclado.imprimirCadena("3. Eliminar tarea");
            Teclado.imprimirCadena("4. Añadir comentario");
            Teclado.imprimirCadena("5. Añadir colaboradores");
            Teclado.imprimirCadena("6. Volver al menú principal");
            Teclado.imprimirCadena(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
            opcion = Teclado.leeEntero("Esperando respuesta: ");


        } while (opcion < 1 || opcion > 6);

        return opcion;
    }

    /**
     * imprime el menu de colaborador
     * @return
     */
    @Override
    public int menuColaborador() {
        int opcion = -1;

        do {
            Teclado.imprimirCadena(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
            Teclado.imprimirCadena("MENU COLABORADOR");
            Teclado.imprimirCadena("1. Editar estado de la tarea");
            Teclado.imprimirCadena("2. Añadir comentario");
            Teclado.imprimirCadena("3. Volver al menú principal");
            Teclado.imprimirCadena(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
            opcion = Teclado.leeEntero("Esperando respuesta: ");


        } while (opcion < 1 || opcion > 3);

        return opcion;
    }

    /**
     * imprime el menu para borrar proyectos
     * @return
     */
    @Override
    public Proyectos viewBorrarProyecto() {
        Proyectos aux = new Proyectos();
        Teclado.imprimirCadena(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        aux.setNombre(Teclado.leeString("Introduce el nombre del proyecto que deseas borrar: "));
        Teclado.imprimirCadena(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        return aux;

    }

    /**
     * imprime el menu para añadir proyecto
     * @return
     */
    @Override
    public Proyectos viewAñadirProjecto() {
        Proyectos aux = new Proyectos();

        Teclado.imprimirCadena(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
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


    /**
     * imprime el menu para listar los proyectos
     * @return
     */
    @Override
    public int eleccionListarProyecto() {
        int aux = 0;
        Teclado.imprimirCadena(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        Teclado.imprimirCadena("1. Para listar todos");
        Teclado.imprimirCadena("2. Para listar por nombre");
        Teclado.imprimirCadena("3. Para listar por Creador");
        Teclado.imprimirCadena("4. Para listar por Colaborador");
        Teclado.imprimirCadena(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        aux = Teclado.leeEntero("Esperando respuesta: ");

        return aux;


    }


    /**
     * Imprime el nombre de la tarea
     * @return
     */
    @Override
    public String nombreTarea() {
        Tareas tareasaux = new Tareas();
        tareasaux.setNombre(Teclado.leeString("Dime el nombre de la tarea: "));
        return tareasaux.getNombre();

    }


}

