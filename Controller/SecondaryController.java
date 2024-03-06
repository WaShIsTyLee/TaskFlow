package Controller;


import IO.Teclado;
import Interfaces.iSecondaryController;
import Model.Proyectos.Proyectos;
import Model.Proyectos.Tareas;
import Model.Proyectos.estadoTareas;
import View.View;

public class SecondaryController implements iSecondaryController {
    View view = new View();

    Tareas tareas = new Tareas();

    @Override
    public void switchMenuCRUDcreador() {

    }

    @Override
    public void switchMenuColaborador(int opcion) {
        switch (opcion) {
            case 1:
                Teclado.imprimirCadena("Editando estado de la tarea...");
                editarEstadoTareas(tareas);
                break;
            case 2:
                Teclado.imprimirCadena("Añadiendo comentario...");
                break;
            case 3:
                view.eleccionCRUD();
                break;

        }
    }

    public void editarEstadoTareas(Tareas tareas) {

        tareas.setEstadoTareas(estadoTareas.SinIniciar);

        tareas.imprimirEstadoTareas();

        tareas.setEstadoTareas(estadoTareas.EnTramite);

        tareas.imprimirEstadoTareas();

        tareas.setEstadoTareas(estadoTareas.Finalizada);

        tareas.imprimirEstadoTareas();
    }


    public void añadirComentario(Tareas tareas, Proyectos proyectos, String comentario) {

        comentario = Teclado.leeString("");
        tareas.setComentario(comentario);

    }

    public void switchMenuCrudTareas(int opcion) {
        switch (opcion) {
            case 1:
                Teclado.imprimirCadena("Creando la tarea...");
                Tareas.agregarTarea(tareas);
                break;
            case 2:
                Teclado.imprimirCadena("Actualizando la tarea...");
                //Meter el metodo y dentro de este la logica
                break;
            case 3:
                Teclado.imprimirCadena("Creando la tarea...");
                Tareas.eliminarTarea(view.nombreTarea());
                break;
        }
    }
}
