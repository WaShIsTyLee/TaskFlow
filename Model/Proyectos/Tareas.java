package Model.Proyectos;

import IO.Teclado;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Tareas implements Serializable {
    static ArrayList<Tareas> tareas = new ArrayList<>();

    String nombre;
    String descripcion;
    LocalDate fechaInicio;
    LocalDate fechaLimite;
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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
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

    public Tareas(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaLimite, Model.Proyectos.estadoTareas estadoTareas, String comentario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
        this.estadoTareas = estadoTareas;
        this.comentario = comentario;
    }

    public Tareas() {
        this("", "", null, null, null, "");
    }

    @Override
    public String toString() {
        return "Tareas{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaLimite=" + fechaLimite +
                ", estadoTareas=" + estadoTareas +
                ", comentario='" + comentario + '\'' +
                '}';
    }

    public void imprimirEstadoTareas() {
        switch (this.estadoTareas) {
            case SinIniciar:
                Teclado.imprimirCadena("La tarea aún no ha comenzado.");
                break;
            case EnTramite:
                Teclado.imprimirCadena("La tarea está en proceso.");
                break;
            case Finalizada:
                Teclado.imprimirCadena("La tarea ha sido completada.");
                break;
            default:
                Teclado.imprimirCadena("Estado desconocido.");
                break;
        }
    }

    public static void agregarTarea(Tareas tarea) {
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
            System.out.println(tareas);
        }
    }

    public static void eliminarTarea(Tareas tarea) {
        Iterator<Tareas> iterator = tareas.iterator();
        while (iterator.hasNext()) {
            Tareas tareasaux = iterator.next();
            if (tareasaux.getNombre().equals(tarea.getNombre())) {
                iterator.remove();
            }
        }
    }


}
