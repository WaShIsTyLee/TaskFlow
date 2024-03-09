package Controller;


import IO.Teclado;
import Interfaces.iSecondaryController;
import Model.Proyectos.Proyectos;
import Model.Proyectos.Tareas;
import Model.Proyectos.estadoTareas;
import View.View;

import java.util.Iterator;

public class SecondaryController implements iSecondaryController {
    View view = new View();
    Tareas tareas = new Tareas();

    @Override
    public void switchMenuCRUDcreador(int opcion, Proyectos proyectos) {
        switch (opcion) {
            case 1:
                Teclado.imprimirCadena("Creando la tarea...");
                tareas = Tareas.crearTarea();
                proyectos.getListaTareas().add(tareas);
                break;
            case 2:
                Teclado.imprimirCadena("Actualizando estado de la tarea...");
                Tareas.actualizarEstadoTarea(proyectos, view.nombreTarea(), Tareas.imprimirEstadoTareas(view.estadoTareas()));
                break;
            case 3:
                Teclado.imprimirCadena("Elimando la tarea...");
                Tareas.eliminarTarea(proyectos, view.nombreTarea());
                break;
            case 4:
                Teclado.imprimirCadena("Estableciendo comentario..");
                String comentario1 = Teclado.leeString("Introduzca comentario");
                Tareas.añadirComentario(proyectos, view.nombreTarea(), comentario1);
                break;

        }

    }

    @Override
    public void switchMenuColaborador(int opcion, Proyectos proyectos) {
        switch (opcion) {
            case 1:
                Teclado.imprimirCadena("Editando estado de la tarea...");
                Tareas.actualizarEstadoTarea(proyectos, view.nombreTarea(), Tareas.imprimirEstadoTareas(view.estadoTareas()));
                break;
            case 2:
                Teclado.imprimirCadena("Añadiendo comentario...");
                String comentario1 = Teclado.leeString("Introduzca comentario");
                Tareas.añadirComentario(proyectos, view.nombreTarea(), comentario1);
                break;
            case 3:
                view.eleccionCRUD();
                break;

        }
    }


}
