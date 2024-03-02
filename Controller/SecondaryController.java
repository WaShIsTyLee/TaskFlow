package Controller;

import IO.Teclado;
import Interfaces.iSecondaryController;
import Model.Proyectos.Projectos;
import Model.Proyectos.Tareas;
import Model.Proyectos.estadoTareas;
import View.View;

public class SecondaryController implements iSecondaryController  {
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

    public void añadirComentario(Tareas tareas, Projectos projectos, String comentario){
        comentario = Teclado.leeString("");
        tareas.setComentario(comentario);
    }
}
