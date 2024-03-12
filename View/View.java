package View;

import IO.Keyboard;
import IO.Utils;
import Interfaces.iView;
import Model.Archivos.Data;
import Model.Archivos.Sesion;
import Model.Entitys.User;
import Model.Proyectos.Proyectos;
import Model.Proyectos.Task;

import java.time.LocalDate;


public class View implements iView {
    static String d = "\u001B[0m"; // Stop print the color // Parar el color establecido
    static String black = "\033[30m"; // Negro
    static String red = "\033[31m"; // Rojo
    static String green = "\033[32m"; // Verde
    static String blue = "\033[34m"; // Blue
    static String purple = "\033[35m"; // Morado

    @Override
    public void startMessage() {
        Keyboard.printString("");
        Keyboard.printString("");
        Keyboard.printString(
                red + "■■■■■■■     ■       ■■■■■     ■    ■          ■■■■■     ■          ■■■■      ■       ■■       ■ \n" +
                        "   ■       ■ ■      ■         ■   ■           ■         ■         ■    ■      ■     ■  ■     ■  \n" +
                        "   ■      ■■■■■     ■■■■■     ■ ■             ■■■■■     ■         ■    ■       ■   ■    ■   ■  \n" +
                        "   ■     ■     ■        ■     ■   ■           ■         ■         ■    ■        ■ ■      ■ ■   \n" +
                        "   ■    ■       ■   ■■■■■     ■     ■         ■         ■■■■■■     ■■■■          ■        ■     \n" + d);

        Keyboard.printString("");
    }


    @Override
    public int menuRegisterLoginSession() {
        int opcion = 0;
        Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        Keyboard.printString("Bienvenido a TaskFlow.");
        Keyboard.printString("Elige la opcion que desees usar: ");

        Keyboard.printString("1. Iniciar Sesión ");
        Keyboard.printString("2. Registrarse ");
        Keyboard.printString("3. Salir ");
        Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        opcion = Keyboard.readInt("Esperando respuesta: ");
        return opcion;
    }


    public static User menuLogin() {
        boolean credencialesCorrectas = false;
        User user = null;

        do {
            Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
            String nombreUsuario = Keyboard.readString("Introduzca su User:");
            String contraseña = Keyboard.readString("Introduzca su contraseña");
            Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);

            credencialesCorrectas = Data.verifyCredentials("usuariosRegistrados", nombreUsuario, contraseña);

            if (!credencialesCorrectas) {
                Keyboard.printString("Credenciales incorrectas. Inténtalo de nuevo.");
            } else {
                user = new User(nombreUsuario, contraseña, "", "");

            }
        } while (!credencialesCorrectas);

        return user;
    }


    @Override
    public User menuRegister() {
        Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        Keyboard.printString("Introduzca los siguientes datos");
        String nombre, usuario, correo, contraseña;
        User userRegistrado = null;
        nombre = Keyboard.readString("Introduzca su nombre completo");
        usuario = Keyboard.readString("Introduzca su nombre de User");
        correo = Keyboard.readString("Introduzca su email");
        while (!User.validarCorreo(correo)) {
            Keyboard.printString("Correo no válido");
            correo = Keyboard.readString("Introduzca su email");
        }
        contraseña = Keyboard.readString("Introduzca su contraseña");
        contraseña = Utils.hashPassword(contraseña);
        Data.saveToFile(nombre, usuario, correo, contraseña, "usuariosRegistrados");
        Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        return userRegistrado;
    }

    @Override
    public int choiceCRUD() {
        int opcion = -1;
        do {
            Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
            Keyboard.printString("Elige la opcion que desees usar: ");
            Keyboard.printString("1. Listar proyecto");
            Keyboard.printString("2. Crear proyecto");
            Keyboard.printString("3. Borrar proyecto");
            Keyboard.printString("4. Listar Usuarios");
            Keyboard.printString("5. Salir y guardar");
            Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
            opcion = Keyboard.readInt("Esperando respuesta: ");

        } while (opcion < 1 || opcion > 5);

        return opcion;
    }

    @Override
    public int menuCreator() {
        int opcion = -1;

        do {
            Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
            Keyboard.printString("Menú de Creador Proyecto");

            Keyboard.printString("1. Crear tarea");
            Keyboard.printString("2. Editar estado tarea");
            Keyboard.printString("3. Eliminar tarea");
            Keyboard.printString("4. Añadir comentario");
           Keyboard.printString(" 5. Añadir colaboradores");
            Keyboard.printString("6. Volver al menú principal");
            Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
            opcion = Keyboard.readInt("Esperando respuesta: ");


        } while (opcion < 1 || opcion > 6);

        return opcion;
    }


    @Override
    public int menuColaborator() {
        int opcion = -1;

        do {
            Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
            Keyboard.printString("MENU COLABORADOR");
            Keyboard.printString("1. Editar estado de la tarea");
            Keyboard.printString("2. Añadir comentario");
            Keyboard.printString("3. Volver al menú principal");
            Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
            opcion = Keyboard.readInt("Esperando respuesta: ");


        } while (opcion < 1 || opcion > 3);

        return opcion;
    }

    @Override
    public Proyectos viewAddProject() {
        Proyectos aux = new Proyectos();

        Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        String nombre = Keyboard.readString("Introduce el nombre de tu proyecto: ");
        aux.setNombre(nombre);
        String descripcion = Keyboard.readString("Introduce una descripcion de tu proyecto: ");

        aux.setDescripcion(descripcion);
        aux.setColaborador(aux.addColaborator());
        aux.setFechaInicio(LocalDate.now());
        aux.setFechaFinalizacion(Proyectos.addEndDate());
        aux.setCreador(Sesion.getStartedUser());
        String respuesta;
        do {
            aux.setListaTareas(Task.addTask(Task.makeTask()));
            respuesta = Keyboard.readString("¿Desea añadir otra tarea? Si/No");
        } while (respuesta.equalsIgnoreCase("Si"));
        System.out.println(aux);


        return aux;
    }




    @Override
    public int choiceListProject() {
        int aux = 0;
        Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        Keyboard.printString("1. Para listar todos");
        Keyboard.printString("2. Para listar por nombre");
        Keyboard.printString("3. Para listar por Creador");
        Keyboard.printString("4. Para listar por Colaborator");
        Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        aux = Keyboard.readInt("Esperando respuesta: ");

        return aux;


    }


    @Override
    public int statusTasks() {
        int opcion = 0;
        Keyboard.printString("1. Tarea sin iniciar");
        Keyboard.printString("2. Tarea en tramite");
        Keyboard.printString("3. Tarea finalizada");
        opcion = Keyboard.readInt("Esperando respuesta: ");

        return opcion;
    }



    @Override
    public String taskName() {
        Task tareasaux = new Task();
        tareasaux.setNombre(Keyboard.readString("Dime el nombre de la tarea: "));
        return tareasaux.getNombre();

    }


}

