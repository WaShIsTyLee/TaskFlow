package Interfaces;

import Model.Proyectos.Proyectos;
import Model.Proyectos.Tareas;
import Model.Proyectos.estadoTareas;

import java.util.ArrayList;

public interface iTareas {

    static estadoTareas imprimirEstadoTareas(int opcion) {
        return null;
    }

    static ArrayList<Tareas> agregarTarea(Tareas tarea) {
        return null;
    }

    static estadoTareas actualizarEstadoTarea(Proyectos proyectos, String nombreTarea, estadoTareas nuevoEstado) {
        return null;
    }

    static void eliminarTarea(Proyectos proyectos, String nombreTarea) {

    }

    static void añadirComentario(Proyectos proyectos, String nombreTarea, String comentario) {

    }

    static Tareas crearTarea() {
        return null;
    }

}
