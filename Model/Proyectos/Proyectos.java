package Model.Proyectos;

import IO.Teclado;
import Interfaces.iProject;
import Model.Entitys.Colaborador;
import Model.Entitys.Usuario;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Proyectos implements iProject, Serializable {
    /**
     * Metodos relacionados con el manejo de los proyectos dentro del progrma.
     *
     */

    static String d = "\u001B[0m"; // Stop print the color // Parar el color establecido
    static String red = "\033[31m"; // Rojo
    static String purple = "\033[35m";


    ArrayList<Tareas> listaTareas = new ArrayList<>();
    String nombre;
    String descripcion;
    LocalDate fechaInicio;
    LocalDate fechaFinalizacion;
    ArrayList <Colaborador> colaborador = new ArrayList<>();
    Usuario creador;

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public ArrayList<Tareas> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(ArrayList<Tareas> listaTareas) {
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

    public ArrayList<Colaborador> getColaborador() {
        return colaborador;
    }

    public void setColaborador(ArrayList<Colaborador> colaborador) {
        this.colaborador = colaborador;
    }

    public Proyectos(ArrayList<Tareas> listaTareas, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFinalizacion, ArrayList<Colaborador> colaborador, Usuario creador) {
        this.listaTareas = listaTareas;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.colaborador = colaborador;
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
        sb.append("Colaborador: ").append(colaborador).append("\n");
        sb.append("Tareas: \n");
        for (Tareas tarea : listaTareas) {
            sb.append("\t ").append(tarea).append("\n");
        }
        sb.append(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d+"\n");

        return sb.toString();
    }

    @Override
    public ArrayList<Colaborador> añadirColaborador() {
        ArrayList <Colaborador> colaborador = new ArrayList<>();

        boolean auxSN = true;
        while (auxSN) {
            Colaborador colaboradoraux = new Colaborador("");
            colaboradoraux.setUsuario(Teclado.leeString("Introduce el nombre del colaborador: "));
            colaborador.add(colaboradoraux);
            String respuesta = Teclado.leeString("Quieres añadir otro colaborador (s/n)? ");
            auxSN = respuesta.equalsIgnoreCase("s");
        }
        return colaborador;
    }
    public static LocalDate añadirFechaFin() {
        LocalDateTime ahora = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaActualStr = formatter.format(ahora);

        LocalDate fechaFinalizacion = null;

        while (fechaFinalizacion == null) {
            String fechaFinalizacionStr = Teclado.leeString("Introduce la fecha de finalización (formato AAAA-MM-DD):");

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


