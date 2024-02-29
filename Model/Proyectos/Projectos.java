package Model.Proyectos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Projectos {
    public tipoRol rol;
    ArrayList<Tareas> listaTareas = new ArrayList<>();
    String nombre;
    String descripcion;
    LocalDate fechaInicio;
    LocalDate fechaFinalizacion;
}
