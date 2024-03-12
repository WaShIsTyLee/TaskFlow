package View;

import IO.Keyboard;
import IO.Utils;
import Interfaces.iView;
import Model.Archivos.Data;
import Model.Archivos.Sesion;
import Model.Entitys.User;
import Model.Proyectos.Project;
import Model.Proyectos.Task;

import java.time.LocalDate;


public class View implements iView {
    static String d = "\u001B[0m"; // Stop print the color // Parar el color establecido
    static String black = "\033[30m"; // Negro
    static String red = "\033[31m"; // Rojo
    static String green = "\033[32m"; // Verde
    static String blue = "\033[34m"; // Blue
    static String purple = "\033[35m"; // Morado

    /**
     * Imprime un mensaje de inicio en grande.
     * Prints a large login message.
     */
    @Override
    public void loginMessage() {
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

    /**
     * Imprime el menú de registro e inicio de sesión.
     * Prints the registration and login menu.
     * @return La opción seleccionada por el usuario.
     */
    @Override
    public int menuRegisterLogin() {
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

    /**
     * Imprime el menú de inicio de sesión.
     * Prints the login menu.
     * @return El usuario que ha iniciado sesión correctamente.
     */
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

    /**
     * Imprime el menú de registro de usuario.
     * Prints the user registration menu.
     * @return El usuario registrado con éxito.
     */
    @Override
    public User menuUserRegister() {
        Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        Keyboard.printString("Introduzca los siguientes datos");
        String nombre, usuario, correo, contraseña;
        User userRegistrado = null;
        nombre = Keyboard.readString("Introduzca su nombre completo");
        usuario = Keyboard.readString("Introduzca su nombre de User");
        correo = Keyboard.readString("Introduzca su email");
        while (!User.validateMail(correo)) {
            Keyboard.printString("Correo no válido");
            correo = Keyboard.readString("Introduzca su email");
        }
        contraseña = Keyboard.readString("Introduzca su contraseña");
        contraseña = Utils.hashPassword(contraseña);
        Data.saveInFile(nombre, usuario, correo, contraseña, "usuariosRegistrados");
        Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        return userRegistrado;
    }

    /**
     * Imprime el menú de elección para realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar) en el sistema.
     * Prints the menu for choosing CRUD (Create, Read, Update, Delete) operations.
     * @return La opción seleccionada por el usuario.
     */
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

    /**
     * Imprime el menú del creador de proyecto.
     * Prints the project creator menu.
     * @return La opción seleccionada por el usuario.
     */
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
            Keyboard.printString("5. Añadir colaboradores");
            Keyboard.printString("6. Volver al menú principal");
            Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
            opcion = Keyboard.readInt("Esperando respuesta: ");


        } while (opcion < 1 || opcion > 6);

        return opcion;
    }

    /**
     * Imprime el menú del colaborador.
     * Prints the collaborator menu.
     * @return La opción seleccionada por el usuario.
     */
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

    /**
     * Imprime el menú para borrar proyectos.
     * Prints the menu for deleting projects.
     * @return El proyecto que se desea borrar.
     */
    @Override
    public Project viewDeleteProject() {
        Project aux = new Project();
        Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        aux.setName(Keyboard.readString("Introduce el nombre del proyecto que deseas borrar: "));
        Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        return aux;

    }

    /**
     * Imprime el menú para añadir un proyecto.
     * Prints the menu for adding a project.
     * @return El proyecto creado.
     */
    @Override
    public Project viewAddProject() {
        Project aux = new Project();

        Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        String nombre = Keyboard.readString("Introduce el nombre de tu proyecto: ");
        aux.setName(nombre);
        String descripcion = Keyboard.readString("Introduce una descripcion de tu proyecto: ");

        aux.setDescription(descripcion);
        aux.setColaborador(aux.addColaborator());
        aux.setStartDate(LocalDate.now());
        aux.setEndDate(Project.addEndDate());
        aux.setCreator(Sesion.getUsuarioIniciado());
        String respuesta;
        do {
            aux.setListaTareas(Task.addTask(Task.createTask()));
            respuesta = Keyboard.readString("¿Desea añadir otra tarea? Si/No");
        } while (respuesta.equalsIgnoreCase("Si"));
        System.out.println(aux);


        return aux;
    }


    /**
     * Imprime el menú para listar los proyectos.
     * Prints the menu for listing projects.
     * @return La opción seleccionada por el usuario.
     */
    @Override
    public int choiceListProject() {
        int aux = 0;
        Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        Keyboard.printString("1. Para listar todos");
        Keyboard.printString("2. Para listar por nombre");
        Keyboard.printString("3. Para listar por Creador");
        Keyboard.printString("4. Para listar por Collaborator");
        Keyboard.printString(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d);
        aux = Keyboard.readInt("Esperando respuesta: ");

        return aux;
    }


    /**
     * Imprime el nombre de la tarea.
     * Prints the task name.
     * @return El nombre de la tarea ingresado por el usuario.
     */
    @Override
    public String taskName() {
        Task tareasaux = new Task();
        tareasaux.setNombre(Keyboard.readString("Dime el nombre de la tarea: "));
        return tareasaux.getNombre();

    }


}

