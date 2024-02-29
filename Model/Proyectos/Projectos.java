package Model.Proyectos;

import Model.Entitys.Usuario;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Projectos implements Serializable {
    ArrayList<Usuario> usuariosProyecto = new ArrayList<>();
    ArrayList<Tareas> listaTareas = new ArrayList<>();
    String nombre;
    String descripcion;
    LocalDate fechaInicio;
    LocalDate fechaFinalizacion;

    public Projectos(ArrayList<Usuario> usuariosProyecto, ArrayList<Tareas> listaTareas, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFinalizacion) {
        this.usuariosProyecto = usuariosProyecto;
        this.listaTareas = listaTareas;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Projectos() {
        this(new ArrayList<>(), new ArrayList<>(), "", "", null, null);
    }

    public ArrayList<Usuario> getUsuariosProyecto() {
        return usuariosProyecto;
    }

    public void setUsuariosProyecto(ArrayList<Usuario> usuariosProyecto) {
        this.usuariosProyecto = usuariosProyecto;
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

    @Override
    public String toString() {
        return "Projectos{" +
                "usuariosProyecto=" + usuariosProyecto +
                ", listaTareas=" + listaTareas +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinalizacion=" + fechaFinalizacion +
                '}';
    }
}
