package Model.Proyectos;

import IO.Keyboard;
import Interfaces.iProject;
import Model.Entitys.Colaborator;
import Model.Entitys.User;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Proyectos implements iProject, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    static String d = "\u001B[0m"; // Stop print the color // Parar el color establecido
    static String red = "\033[31m"; // Rojo
    static String purple = "\033[35m";


    ArrayList<Task> listaTareas = new ArrayList<>();
    String nombre;
    String descripcion;
    LocalDate fechaInicio;
    LocalDate fechaFinalizacion;
    ArrayList <Colaborator> colaborator = new ArrayList<>();
    User creador;

    public User getCreador() {
        return creador;
    }

    public void setCreador(User creador) {
        this.creador = creador;
    }

    public ArrayList<Task> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(ArrayList<Task> listaTareas) {
        this.listaTareas = listaTareas;
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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public ArrayList<Colaborator> getColaborador() {
        return colaborator;
    }

    public void setColaborador(ArrayList<Colaborator> colaborator) {
        this.colaborator = colaborator;
    }

    public Proyectos(ArrayList<Task> listaTareas, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFinalizacion, ArrayList<Colaborator> colaborator, User creador) {
        this.listaTareas = listaTareas;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.colaborator = colaborator;
        this.creador = creador;
    }

    public Proyectos(){
        this(null,"","",LocalDate.now(),null,null,null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d+"\n");
        sb.append(red + "\n"+
                "  _____                                         _                 \n" +
                " |  __ \\                                       | |                \n" +
                " | |__) |  _ __    ___    _   _    ___    ___  | |_    ___    ___ \n" +
                " |  ___/  | '__|  / _ \\  | | | |  / _ \\  / __| | __|  / _ \\  / __|\n" +
                " | |      | |    | (_) | | |_| | |  __/ | (__  | |_  | (_) | \\__ \\\n" +
                " |_|      |_|     \\___/   \\__, |  \\___|  \\___|  \\__|  \\___/  |___/\n" +
                "                           __/ |                                  \n" +
                "                          |___/                                   \n" + d  );
        sb.append("Nombre del proyecto: ").append(nombre).append("\n");
        sb.append("Descripción: ").append(descripcion).append("\n");
        sb.append("Fecha de Inicio: ").append(fechaInicio).append("\n");
        sb.append("Fecha de Finalización: ").append(fechaFinalizacion).append("\n");
        sb.append("Creador: ").append(creador).append("\n");
        sb.append("Colaborator: ").append(colaborator).append("\n");
        sb.append("Task: \n");
        for (Task tarea : listaTareas) {
            sb.append("\t ").append(tarea).append("\n");
        }
        sb.append(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d+"\n");

        return sb.toString();
    }

    @Override
    public ArrayList<Colaborator> addColaborator() {
        ArrayList <Colaborator> colaborator = new ArrayList<>();

        boolean auxSN = true;
        while (auxSN) {
            Colaborator colaboradoraux = new Colaborator("");
            colaboradoraux.setUsuario(Keyboard.readString("Introduce el nombre del colaborator: "));
            colaborator.add(colaboradoraux);
            String respuesta = Keyboard.readString("Quieres añadir otro colaborator (s/n)? ");
            auxSN = respuesta.equalsIgnoreCase("s");
        }
        return colaborator;
    }
    public static LocalDate addEndDate() {
        LocalDateTime ahora = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaActualStr = formatter.format(ahora);

        LocalDate fechaFinalizacion = null;

        while (fechaFinalizacion == null) {
            String fechaFinalizacionStr = Keyboard.readString("Introduce la fecha de finalización (formato AAAA-MM-DD):");

            if (fechaFinalizacionStr.matches("\\d{4}-\\d{2}-\\d{2}") && fechaFinalizacionStr.compareTo(fechaActualStr) >= 0) {
                fechaFinalizacion = LocalDate.parse(fechaFinalizacionStr, formatter);
            } else {
                System.out.println("Error: La fecha de finalización no puede ser anterior a la fecha actual o el formato es incorrecto. " +
                        "Por favor, inténtalo de nuevo.");
            }
        }

        return fechaFinalizacion;
    }
}


