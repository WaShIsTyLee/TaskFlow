package Model.Proyectos;

import Model.Entitys.Usuario;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Projectos implements Serializable {
    ArrayList<Tareas> listaTareas = new ArrayList<>();
    String nombre;
    String descripcion;
    LocalDate fechaInicio;
    LocalDate fechaFinalizacion;
    String colaborador;

    public Projectos(ArrayList<Tareas> listaTareas, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFinalizacion, String colaborador) {
        this.listaTareas = listaTareas;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.colaborador = colaborador;
    }
    public Projectos() {
        this(new ArrayList<>(), "", "", null, null, "");
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

    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    @Override
    public String toString() {
        return "Projectos{" +
                "listaTareas=" + listaTareas +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinalizacion=" + fechaFinalizacion +
                ", colaborador='" + colaborador + '\'' +
                '}';
    }
}
