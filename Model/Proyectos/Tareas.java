package Model.Proyectos;

import IO.Teclado;

import java.time.LocalDate;
import java.util.Objects;

public class Tareas {
    String nombre;
    String descripcion;
    LocalDate fechaInicio;
    LocalDate fechaLimite;
    estadoTareas estadoTareas;

    public Tareas(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaLimite, Model.Proyectos.estadoTareas estadoTareas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
        this.estadoTareas = estadoTareas;
    }

    public Tareas() {

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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Tareas tareas)) return false;
        return Objects.equals(nombre, tareas.nombre) && Objects.equals(descripcion, tareas.descripcion) && Objects.equals(fechaInicio, tareas.fechaInicio) && Objects.equals(fechaLimite, tareas.fechaLimite) && estadoTareas == tareas.estadoTareas;
    }

    @Override
    public String toString() {
        return "Tareas{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaLimite=" + fechaLimite +
                ", estadoTareas=" + estadoTareas +
                '}';
    }
}
