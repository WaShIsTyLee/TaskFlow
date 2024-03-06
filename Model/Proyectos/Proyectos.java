package Model.Proyectos;

import Model.Entitys.Colaborador;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Proyectos implements Serializable {
    ArrayList<Tareas> listaTareas = new ArrayList<>();
    String nombre;
    String descripcion;
    LocalDate fechaInicio;
    LocalDate fechaFinalizacion;
    ArrayList <Colaborador> colaborador = new ArrayList<>();

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

    public List getColaborador() {
        return colaborador;
    }

    public void setColaborador(ArrayList<Colaborador> colaborador) {
        this.colaborador = colaborador;
    }

    public Proyectos(ArrayList<Tareas> listaTareas, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFinalizacion, ArrayList<Colaborador> colaborador) {
        this.listaTareas = listaTareas;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.colaborador = colaborador;
    }

    public Proyectos(){
        this(null,"","",LocalDate.now(),null,null);
    }

    @Override
    public String toString() {
        return  "Proyecto: " + " "+ nombre + " "+ descripcion + " " + fechaInicio + " "  + fechaFinalizacion + " " + "\n" +
                 listaTareas;


    }

}

