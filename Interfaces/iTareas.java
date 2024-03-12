package Interfaces;

import Model.Proyectos.Project;
import Model.Proyectos.Task;
import Model.Proyectos.TaskStatus;

import java.util.ArrayList;

public interface iTareas {

    static TaskStatus imprimirEstadoTareas(int opcion) {
        return null;
    }

    static ArrayList<Task> agregarTarea(Task tarea) {
        return null;
    }

    static TaskStatus actualizarEstadoTarea(Project project, String nombreTarea, TaskStatus nuevoEstado) {
        return null;
    }

    static void eliminarTarea(Project project, String nombreTarea) {

    }

    static void añadirComentario(Project project, String nombreTarea, String comentario) {

    }

    static Task crearTarea() {
        return null;
    }

}
