package Model.Proyectos;

import IO.Keyboard;
import View.View;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import static Model.Proyectos.StateTask.*;

public class Task implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    static View view = new View();//desapararecer
    static ArrayList<Task> tareas = new ArrayList<>();

    String nombre;
    String descripcion;
    StateTask StateTask;
    String comentario;
    LocalDate fechaInicio;
    LocalDate fechaFinaliazacion;

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinaliazacion() {
        return fechaFinaliazacion;
    }

    public void setFechaFinaliazacion(LocalDate fechaFinaliazacion) {
        this.fechaFinaliazacion = fechaFinaliazacion;
    }

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

    public StateTask getEstadoTareas() {
        return StateTask;
    }

    public void setEstadoTareas(StateTask StateTask) {
        this.StateTask = StateTask;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Task(String nombre, String descripcion, StateTask StateTask, String comentario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.StateTask = StateTask;
        this.comentario = comentario;
    }

    public Task() {
        this("", "",  null, "");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre de la tarea: ").append(nombre).append("\n");
        sb.append("     Descripción: ").append(descripcion).append("\n");
        sb.append("     Estado: ").append(StateTask).append("\n");
        sb.append("     Comentario: ").append(comentario).append("\n");
        sb.append("     Fecha inicio: ").append(fechaInicio).append("\n");
        sb.append("     Fecha fin: ").append(fechaFinaliazacion).append("\n");
        return sb.toString();
    }


    public static StateTask StateTasks(int opcion) {

        Task aux = new Task();
        switch (opcion) {
            case 1:
                Keyboard.printString("La tarea aún no ha comenzado.");
                aux.setEstadoTareas(SinIniciar);
                break;
            case 2:
                Keyboard.printString("La tarea está en proceso.");
                aux.setEstadoTareas(EnTramite);
                break;
            case 3:
                Keyboard.printString("La tarea ha sido completada.");
                aux.setEstadoTareas(Finalizada);
                break;
            default:
                Keyboard.printString("Estado desconocido.");
                break;
        }
        return aux.getEstadoTareas();

    }


    public static ArrayList<Task> addTask(Task tarea) {
        boolean tareaExistente = false;

        for (Task tareaExiste : tareas) {
            if (tareaExiste.getNombre().equals(tarea.getNombre())) {
                tareaExistente = true;
            }
        }
        if (!tareaExistente) {
            tareas.add(tarea);
        }

        return tareas;
    }

    public static StateTask updateStateTask(Proyectos proyectos, String nombreTarea, StateTask nuevoEstado) {
        Task tareaEncontrada = null;
        StateTask estadoAnterior = null;

        for (Task tarea : proyectos.getListaTareas()) {
            if (tarea.getNombre().equals(nombreTarea)) {
                tareaEncontrada = tarea;
                estadoAnterior = tarea.getEstadoTareas();
                tareaEncontrada.setEstadoTareas(nuevoEstado);
            }

        }
        StateTask estadoResultado = null;
        if (tareaEncontrada != null) {
            estadoResultado = estadoAnterior;
        }
        return estadoResultado;
    }


    public static void deleteTask(Proyectos proyectos, String nombreTarea) {
        boolean tareaEncontrada = false;
        Iterator<Task> iterator = proyectos.getListaTareas().iterator();
        while (iterator.hasNext()) {
            Task tarea = iterator.next();
            if (tarea.getNombre().equals(nombreTarea)) {
                iterator.remove();
                Keyboard.printString("Tarea eliminada exitosamente.");
                tareaEncontrada = true;
            }
        }
        if (!tareaEncontrada) {
            Keyboard.printString("La tarea no fue encontrada.");

        }
    }

    public static void addComment(Proyectos proyectos, String nombreTarea, String comentario) {
        Task tareaEncontrada = null;
        String resultado;

        for (Task tarea : proyectos.getListaTareas()) {
            if (tarea.getNombre().equals(nombreTarea)) {
                tareaEncontrada = tarea;
                resultado = tareaEncontrada.getComentario();
                tareaEncontrada.setComentario(comentario);
            }

        }
    }

    public static Task makeTask() {
        Task aux = new Task();
        aux.setNombre(Keyboard.readString("Introduce nombre Tarea"));
        aux.setDescripcion(Keyboard.readString("Introduce descripcion par la tarea"));
        aux.setEstadoTareas(StateTasks(view.statusTasks()));
        aux.setFechaInicio(LocalDate.now());
        aux.setFechaFinaliazacion(Proyectos.addEndDate());
        Task.addTask(aux);
        return aux;
    }
}
