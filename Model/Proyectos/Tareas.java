package Model.Proyectos;

import IO.Teclado;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Tareas implements Serializable {
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
    public Tareas(){
        this("","",null,null,null,"");
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
}
