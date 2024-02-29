package Controller;

import IO.Teclado;
import Interfaces.iController;
import Model.Entitys.Usuario;
import View.View;

public class MainController implements iController {

    View view = new View();
    Usuario usuario = new Usuario();

    @Override
    public void startApp() {

    }


    @Override
    public void switchMenuRegistroInicioSesion(int opcion) {
        do {

            switch (opcion) {
                case 1:
                    view.menuIniciarSesion();
                    view.mensajesDeInicio();
                    switchEleccionCrud(view.eleccionCRUD());
                    break;
                case 2:
                    view.menuRegistroUsuario();
                    switchMenuRegistroInicioSesion(view.menuRegistroInicioSesion());
                    break;

                case 3:
                    System.out.println(" ");
                    System.out.println("Adios");
                    break;

                default:
                    System.out.println("Ups... Parece que te has equivocado, prueba otra vez.");
                    System.out.println(" ");
                    opcion=view.menuRegistroInicioSesion();
            }
        } while (opcion != 3);
    }

    public void switchEleccionCrud(int opcion) {  //LLAMAR A CADA FUNCION CUANDO ESTEN CREADAS
        switch (opcion) {
            case 1:
                Teclado.imprimirCadena("Listando proyectos...");

                break;
            case 2:
                Teclado.imprimirCadena("Crear proyecto...");

                break;
            case 3:
                Teclado.imprimirCadena("Borrando proyecto...");

                break;
            case 4:
                Teclado.imprimirCadena("Organizando tareas...");
                switchEleccionTareas(view.tareasProyecto());
                break;
            case 5:
                Teclado.imprimirCadena("Saliendo, los cambios se han guardado correctamente.");
                switchMenuRegistroInicioSesion(view.menuRegistroInicioSesion());
                break;
        }
    }

    @Override
    public void switchEleccionTareas(int opcion) {
        switch (opcion) {
            case 1:
                // Lógica para crear una nueva tarea
                Teclado.imprimirCadena("Creando nueva tarea...");

                break;
            case 2:
                // Lógica para editar una tarea existente
                Teclado.imprimirCadena("Editando tarea...");

                break;
            case 3:
                // Lógica para eliminar una tarea existente
                Teclado.imprimirCadena("Eliminando tarea...");

                break;
            case 4:
                // Lógica para mostrar la lista de tareas del proyecto
                Teclado.imprimirCadena("Lista de tareas del proyecto:");

                break;
            case 5:
                view.eleccionCRUD();
                break;

        }
    }


}

