package Interfaces;

import Model.Proyectos.Proyectos;
import Model.Proyectos.Task;
import Model.Proyectos.StateTask;

import java.util.ArrayList;

public interface iTareas {

    static StateTask imprimirEstadoTareas(int opcion) {
        return null;
    }

    static ArrayList<Task> agregarTarea(Task tarea) {
        return null;
    }

    static StateTask actualizarEstadoTarea(Proyectos proyectos, String nombreTarea, StateTask nuevoEstado) {
        return null;
    }

    static void eliminarTarea(Proyectos proyectos, String nombreTarea) {

    }

    static void añadirComentario(Proyectos proyectos, String nombreTarea, String comentario) {

    }

    static Task crearTarea() {
        return null;
    }

}
