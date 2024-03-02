package Controller;

import IO.Teclado;
import Interfaces.iController;
import Model.Archivos.Datos;
import Model.Entitys.Usuario;
import Model.Serializador.Serializador;
import View.View;

public class MainController implements iController {

    View view = new View();




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
                    Teclado.imprimirCadena(" ");
                    Teclado.imprimirCadena("Adios");
                    break;

                default:
                    Teclado.imprimirCadena("Ups... Parece que te has equivocado, prueba otra vez.");
                    Teclado.imprimirCadena(" ");
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
                    Teclado.imprimirCadena("");
                    Teclado.imprimirCadena("");
                    switchMenuRegistroInicioSesion(view.menuRegistroInicioSesion());
                    break;
            }


    }

    @Override
    public void switchEleccionTareas(int opcion) {

        do {
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
                    // Lógica para mostrar la lista de usuarios
                    Teclado.imprimirCadena("Lista de usuarios del proyecto:");
                    Datos.listarUsuarios("usuariosRegistrados");

                    break;
                case 5:
                    Teclado.imprimirCadena("");
                    Teclado.imprimirCadena("");
                    view.eleccionCRUD();
                    break;


            }
            Teclado.imprimirCadena("");
            Teclado.imprimirCadena("");
            switchEleccionTareas(view.tareasProyecto());

        }while (opcion!=5);
    }


}

