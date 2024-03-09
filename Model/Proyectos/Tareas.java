package Model.Proyectos;

import IO.Teclado;
import View.View;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import static Model.Proyectos.estadoTareas.*;

import static Model.Proyectos.estadoTareas.*;

public class Tareas implements Serializable {
    static View view = new View();
    static ArrayList<Tareas> tareas = new ArrayList<>();

    String nombre;
    String descripcion;
    estadoTareas estadoTareas;
    String comentario;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Model.Proyectos.estadoTareas getEstadoTareas() {
        return estadoTareas;
    }

    public void setEstadoTareas(Model.Proyectos.estadoTareas estadoTareas) {
        this.estadoTareas = estadoTareas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Tareas(String nombre, String descripcion, Model.Proyectos.estadoTareas estadoTareas, String comentario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estadoTareas = estadoTareas;
        this.comentario = comentario;
    }

    public Tareas() {
        this("", "",  null, "");
    }

    @Override
    public String toString() {
        return "Tareas{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estadoTareas=" + estadoTareas +
                ", comentario='" + comentario + '\'' +
                '}';
    }


    public static estadoTareas imprimirEstadoTareas(int opcion) {

        Tareas aux = new Tareas();
        switch (opcion) {
            case 1:
                Teclado.imprimirCadena("La tarea aún no ha comenzado.");
                aux.setEstadoTareas(SinIniciar);
                break;
            case 2:
                Teclado.imprimirCadena("La tarea está en proceso.");
                aux.setEstadoTareas(EnTramite);
                break;
            case 3:
                Teclado.imprimirCadena("La tarea ha sido completada.");
                aux.setEstadoTareas(Finalizada);
                break;
            default:
                Teclado.imprimirCadena("Estado desconocido.");
                break;
        }
        return aux.getEstadoTareas();

    }


    public static ArrayList<Tareas> agregarTarea(Tareas tarea) {
        boolean tareaExistente = false;

        for (Tareas tareaExiste : tareas) {
            if (tareaExiste.getNombre().equals(tarea.getNombre())) {
                tareaExistente = true;
            }
        }

        if (!tareaExistente) {
            tareas.add(tarea);
        } else {
            Teclado.imprimirCadena("La tarea ya existe en el proyecto.");
        }

        return tareas;
    }
    public static estadoTareas actualizarEstadoTarea(Proyectos proyectos, String nombreTarea, estadoTareas nuevoEstado) {
        Tareas tareaEncontrada = null;
        estadoTareas estadoAnterior = null;

        for (Tareas tarea : proyectos.getListaTareas()) {
            if (tarea.getNombre().equals(nombreTarea)) {
                tareaEncontrada = tarea;
                estadoAnterior = tarea.getEstadoTareas();
                tareaEncontrada.setEstadoTareas(nuevoEstado);
            }

        }
        estadoTareas estadoResultado = null;
        if (tareaEncontrada != null) {
            estadoResultado = estadoAnterior;
        }
        return estadoResultado;
    }


    public static void eliminarTarea(Proyectos proyectos, String nombreTarea) {
        boolean tareaEncontrada = false;
        Iterator<Tareas> iterator = proyectos.getListaTareas().iterator();
        while (iterator.hasNext()) {
            Tareas tarea = iterator.next();
            if (tarea.getNombre().equals(nombreTarea)) {
                iterator.remove();
                Teclado.imprimirCadena("Tarea eliminada exitosamente.");
                tareaEncontrada = true;
            }
        }
        if (!tareaEncontrada) {
            Teclado.imprimirCadena("La tarea no fue encontrada.");

        }
    }

    public static void añadirComentario(Proyectos proyectos, String nombreTarea, String comentario) {
        Tareas tareaEncontrada = null;
        String resultado;

        for (Tareas tarea : proyectos.getListaTareas()) {
            if (tarea.getNombre().equals(nombreTarea)) {
                tareaEncontrada = tarea;
                resultado = tareaEncontrada.getComentario();
                tareaEncontrada.setComentario(comentario);
            }

        }
    }

    public static Tareas crearTarea() {
        Tareas aux = new Tareas();
        aux.setNombre(Teclado.leeString("Introduce nombre Tarea"));
        aux.setDescripcion(Teclado.leeString("Introduce descripcion par la tarea"));
        aux.setEstadoTareas(imprimirEstadoTareas(view.estadoTareas()));
        Tareas.agregarTarea(aux);
        return aux;
    }
}
