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
                "       / \\          <\\__  / \\  _\\o__</    / \\  <\\  / \\           / \\   <\\__ __/>      <\\/>    <\\/>    \n" +
                "                                                                                                      \n" +
                "                                                                                                      \n" +
                "                                                                                                      ");
    }

    @Override
    public int menuRegistroInicioSesion() {
        int opcion = 0;
        boolean entradaValida = false;

        do {
            System.out.println("Elige la opcion que desees usar: ");
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
    public void menuIniciarSesion() {
        //TOCAR PARA QUE SE REPITA EL PEDIR USUARIO Y CONTRASEÑA
        //Logica de comprobar si esta en el archivo ya esta hecha NO TOCAR
        String usuario = Teclado.leeString("Introduzca su Usuario:");
        String contraseña = Teclado.leeString("Introduzca su contraseña");
        if (Archivo.verificarCredenciales("usuariosRegistrados", usuario, contraseña)) {
            System.out.println("LOGEANDOTE CRUCK");
        } else {
            System.out.println("No estas logeado en la web");
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
            correo = Teclado.leeString("Introduzca su gmail");
            //VALIDACION CORREO CREAR FUNCION
            contraseña = Teclado.leeString("Introduzca su contraseña");

            // Verificar si el nombre de usuario o el correo ya están registrados
            if (!Archivo.verificarCredenciales("usuariosRegistrados", usuario, contraseña)) {
                usuarioRegistrado = new Usuario(nombre, usuario, contraseña, correo, "");
                Archivo.guardarEnArchivo(usuarioRegistrado.getNombre(), usuarioRegistrado.getUsuario(), usuarioRegistrado.getContraseña(), usuarioRegistrado.getCorreo(), "usuariosRegistrados");
                credencialesValidas = true;
            } else {
                System.out.println("El usuario o el correo electrónico ya están en uso. Por favor, elija otro.");
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
            System.out.println("Elige la opcion que desees usar: ");
            System.out.println("1. Listar proyecto");
            System.out.println("2. Crear proyecto");
            System.out.println("3. Borrar proyecto");
            System.out.println("4. Organizar tareas");
            System.out.println("5. Salir y guardar");
            switch (op) {
                case 1:
                    System.out.println("Listando proyectos...");
                    entradaValida = true;
                    break;
                case 2:
                    System.out.println("Crear proyecto...");
                    entradaValida = true;
                    break;
                case 3:
                    System.out.println("Borrando proyecto...");
                    entradaValida = true;
                    break;
                case 4:
                    System.out.println("Organizando tareas...");
                    entradaValida = true;
                    break;
                case 5:
                    System.out.println("Saliendo, los cambios se han guardado correctamente.");
                    entradaValida = true;
                    break;
                default:
                    System.out.println("Error, introduce un numero entre 1 y 5.");
            }
        } while (!entradaValida);

        return op;
    }

    @Override
    public int tareasProyecto() {
        return 0;
    }
}
