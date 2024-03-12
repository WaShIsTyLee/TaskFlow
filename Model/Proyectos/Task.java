package Model.Proyectos;

import IO.Keyboard;
import Interfaces.iTareas;
import View.View;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import static Model.Proyectos.TaskStatus.*;

public class Task implements iTareas, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * Metodos relacionados con el manejo de las tareas dentro del progrma.
     *
     */
    static View view = new View();
    static ArrayList<Task> tareas = new ArrayList<>();

    String nombre;
    String descripcion;
    TaskStatus TaskStatus;
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

    public TaskStatus getEstadoTareas() {
        return TaskStatus;
    }

    public void setEstadoTareas(TaskStatus TaskStatus) {
        this.TaskStatus = TaskStatus;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Task(String nombre, String descripcion, TaskStatus TaskStatus, String comentario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.TaskStatus = TaskStatus;
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
        sb.append("     Estado: ").append(TaskStatus).append("\n");
        sb.append("     Comentario: ").append(comentario).append("\n");
        sb.append("     Fecha inicio: ").append(fechaInicio).append("\n");
        sb.append("     Fecha fin: ").append(fechaFinaliazacion).append("\n");
        return sb.toString();
    }


    /**
     * Método para establecer el estado de una tarea basado en la opción proporcionada.
     * Method to set the status of a task based on the provided option.
     * @param opcion Un número entero que representa el estado de la tarea.
     *               1 para Sin Iniciar, 2 para En Trámite, 3 para Finalizada.
     * @return El estado de la tarea.
     */
    public static TaskStatus taskStatus(int opcion) {

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

    /**
     * Método para agregar una tarea a la lista de tareas si no existe.
     * Method to add a task to the task list if it doesn't already exist.
     * @param tarea La tarea que se va a agregar a la lista.
     * @return La lista de tareas actualizada.
     */
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

    /**
     * Método para actualizar el estado de una tarea en una lista de project.
     * Method to update the status of a task in a list of project.
     * @param project    La lista de project donde se buscará la tarea.
     * @param nombreTarea  El nombre de la tarea que se desea actualizar.
     * @param nuevoEstado  El nuevo estado al que se desea cambiar la tarea.
     * @return El estado anterior de la tarea, si se encuentra y se actualiza; de lo contrario, null.
     */
    public static TaskStatus updateTaskStatus(Project project, String nombreTarea, TaskStatus nuevoEstado) {
        Task tareaEncontrada = null;
        TaskStatus estadoAnterior = null;

        for (Task tarea : project.getListaTareas()) {
            if (tarea.getNombre().equals(nombreTarea)) {
                tareaEncontrada = tarea;
                estadoAnterior = tarea.getEstadoTareas();
                tareaEncontrada.setEstadoTareas(nuevoEstado);
            }

        }
        TaskStatus estadoResultado = null;
        if (tareaEncontrada != null) {
            estadoResultado = estadoAnterior;
        }
        return estadoResultado;
    }

    /**
     * Método para eliminar una tarea de la lista de project.
     * Method to delete a task from the list of project.
     * @param project   La lista de project de donde se eliminará la tarea.
     * @param nombreTarea El nombre de la tarea que se desea eliminar.
     */
    public static void deleteTask(Project project, String nombreTarea) {
        boolean tareaEncontrada = false;
        Iterator<Task> iterator = project.getListaTareas().iterator();
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

    /**
     * Método para agregar un comentario a una tarea en la lista de project.
     * Method to add a comment to a task in the list of project.
     * @param project    La lista de project donde se buscará la tarea.
     * @param nombreTarea  El nombre de la tarea a la que se desea agregar el comentario.
     * @param comentario   El comentario que se desea agregar a la tarea.
     */
    public static void addComment(Project project, String nombreTarea, String comentario) {
        Task tareaEncontrada = null;
        String resultado;

        for (Task tarea : project.getListaTareas()) {
            if (tarea.getNombre().equals(nombreTarea)) {
                tareaEncontrada = tarea;
                resultado = tareaEncontrada.getComentario();
                tareaEncontrada.setComentario(comentario);
            }

        }
    }

    /**
     * Método para crear una nueva tarea.
     * Method to create a new task.
     * @return La nueva tarea creada.
     */
    public static Task createTask() {
        Task aux = new Task();
        aux.setNombre(Keyboard.readString("Introduce nombre Tarea"));
        aux.setDescripcion(Keyboard.readString("Introduce descripcion par la tarea"));
        aux.setEstadoTareas(taskStatus(taskStatus()));
        aux.setFechaInicio(LocalDate.now());
        aux.setFechaFinaliazacion(Project.addEndDate());
        Task.addTask(aux);
        return aux;
    }

    /**
     * Imprime el menú de estados de las tareas.
     * Prints the menu for task statuses.
     * @return La opción seleccionada por el usuario.
     */
    public static int taskStatus() {
        int opcion = 0;
        Keyboard.printString("1. Tarea sin iniciar");
        Keyboard.printString("2. Tarea en tramite");
        Keyboard.printString("3. Tarea finalizada");
        opcion = Keyboard.readInt("Esperando respuesta: ");

        return opcion;
    }
}
