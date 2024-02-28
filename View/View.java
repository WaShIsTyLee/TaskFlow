package View;

import IO.Teclado;
import Interfaces.iView;
import Model.Archivos.Archivo;
import Model.Entitys.Usuario;


public class View implements iView {

    @Override
    public void mensajesDeInicio() {

        Teclado.imprimirCadena(" ____o__ __o____                           o        o__ __o__/_   o                                   \n" +
                "  /   \\   /   \\                           <|>      <|    v       <|>                                  \n" +
                "       \\o/                                / \\      < >           / \\                                  \n" +
                "        |            o__ __o/      __o__  \\o/  o/   |            \\o/    o__ __o     o              o  \n" +
                "       < >          /v     |      />  \\    |  /v    o__/_         |    /v     v\\   <|>            <|> \n" +
                "        |          />     / \\     \\o      / \\/>     |            / \\  />       <\\  < >            < > \n" +
                "        o          \\      \\o/      v\\     \\o/\\o    <o>           \\o/  \\         /   \\o    o/\\o    o/  \n" +
                "       <|           o      |        <\\     |  v\\    |             |    o       o     v\\  /v  v\\  /v   \n" +
                "       / \\          <\\__  / \\  _\\o__</    / \\  <\\  / \\           / \\   <\\__ __/>      <\\/>    <\\/>    \n");
        Teclado.imprimirCadena("");
        Teclado.imprimirCadena("Bienvenido a TaskFlow...");
    }

    @Override
    public int menuRegistroInicioSesion() {
        int opcion = 0;
        boolean entradaValida = false;

        do {
            Teclado.imprimirCadena("Elige la opcion que desees usar: ");
            Teclado.imprimirCadena("1. Iniciar Sesión");
            Teclado.imprimirCadena("2. Registrarse");

            opcion = Teclado.leeEntero("");

            switch (opcion) {
                case 1:
                    Teclado.imprimirCadena("Iniciando Sesión...");
                    entradaValida = true;
                    break;
                case 2:
                    Teclado.imprimirCadena("Registrándose...");
                    entradaValida = true;
                    break;
                default:
                    Teclado.imprimirCadena("Error, introduce 1 o 2.");
            }

        } while (!entradaValida);

        return opcion;
    }


    @Override
    public void menuIniciarSesion() {
        //TOCAR PARA QUE SE REPITA EL PEDIR USUARIO Y CONTRASEÑA
        //Logica de comprobar si esta en el archivo ya esta hecha NO TOCAR
        String usuario = Teclado.leeString("Introduzca su Usuario:");
        String contraseña = Teclado.leeString("Introduzca su contraseña");
        if (Archivo.verificarCredenciales("usuariosRegistrados", usuario, contraseña)) {
            Teclado.imprimirCadena("LOGEANDOTE CRUCK");
        } else {
            Teclado.imprimirCadena("No estas logeado en la web");
        }


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
            correo = Teclado.leeString("Introduzca su email");

            //VALIDACION CORREO CREAR FUNCION
            while (!Usuario.validarCorreo(correo)) {
                Teclado.imprimirCadena("Correo no válido");
                correo = Teclado.leeString("Introduzca su email");
            }

            contraseña = Teclado.leeString("Introduzca su contraseña");

            // Verificar si el nombre de usuario o el correo ya están registrados
            if (!Archivo.verificarCredenciales("usuariosRegistrados", usuario, contraseña)) {
                usuarioRegistrado = new Usuario(nombre, usuario, contraseña, correo, "");
                Archivo.guardarEnArchivo(usuarioRegistrado.getNombre(), usuarioRegistrado.getUsuario(), usuarioRegistrado.getContraseña(), usuarioRegistrado.getCorreo(), "usuariosRegistrados");
                credencialesValidas = true;
            } else {
                Teclado.imprimirCadena("El usuario o el correo electrónico ya están en uso. Por favor, elija otro.");
                menuRegistroInicioSesion();
            }
        }

        return usuarioRegistrado;
    }

    @Override
    public void mensajeBienvenidaTaskFlow() {
        Teclado.imprimirCadena("Bienvenido a TaskFloW");
    }

    @Override
    public int eleccionCRUD() {
        int op = -1;
        boolean entradaValida = false;
        do {
            Teclado.imprimirCadena("Elige la opcion que desees usar: ");
            Teclado.imprimirCadena("1. Listar proyecto");
            Teclado.imprimirCadena("2. Crear proyecto");
            Teclado.imprimirCadena("3. Borrar proyecto");
            Teclado.imprimirCadena("4. Organizar tareas");
            Teclado.imprimirCadena("5. Salir y guardar");
            switch (op) {
                case 1:
                    Teclado.imprimirCadena("Listando proyectos...");
                    entradaValida = true;
                    break;
                case 2:
                    Teclado.imprimirCadena("Crear proyecto...");
                    entradaValida = true;
                    break;
                case 3:
                    Teclado.imprimirCadena("Borrando proyecto...");
                    entradaValida = true;
                    break;
                case 4:
                    Teclado.imprimirCadena("Organizando tareas...");
                    entradaValida = true;
                    break;
                case 5:

                    Teclado.imprimirCadena("Saliendo, los cambios se han guardado correctamente.");
                    entradaValida = true;
                    break;
                default:
                    Teclado.imprimirCadena("Error, introduce un numero entre 1 y 5.");
            }
        } while (!entradaValida);

        return op;
    }

    @Override
    public int tareasProyecto() {
        int opcion = 0;
        boolean entradaValida = false;

        do {
            Teclado.imprimirCadena("Menú de Tareas del Proyecto");
            Teclado.imprimirCadena("1. Crear tarea");
            Teclado.imprimirCadena("2. Editar tarea");
            Teclado.imprimirCadena("3. Eliminar tarea");
            Teclado.imprimirCadena("4. Ver lista de tareas");
            Teclado.imprimirCadena("5. Volver al menú principal");
            opcion = Teclado.leeEntero("");

            switch (opcion) {
                case 1:
                    // Lógica para crear una nueva tarea
                    Teclado.imprimirCadena("Creando nueva tarea...");
                    entradaValida = true;
                    break;
                case 2:
                    // Lógica para editar una tarea existente
                    Teclado.imprimirCadena("Editando tarea...");
                    entradaValida = true;
                    break;
                case 3:
                    // Lógica para eliminar una tarea existente
                    Teclado.imprimirCadena("Eliminando tarea...");
                    entradaValida = true;
                    break;
                case 4:
                    // Lógica para mostrar la lista de tareas del proyecto
                    Teclado.imprimirCadena("Lista de tareas del proyecto:");
                    // Aquí iterar sobre la lista de tareas y mostrarlas
                    entradaValida = true;
                    break;
                case 5:
                    // Volver al menú principal
                    entradaValida = true;
                    break;
                default:
                    Teclado.imprimirCadena("Error, introduce un número válido.");
            }

        } while (!entradaValida);

        return opcion;
    }

}
