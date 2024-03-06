package Interfaces;

import Model.Proyectos.Proyectos;


import java.io.Serializable;

public interface iRepoProjectos extends Serializable {

    boolean borrarProyecto(Proyectos projecto);
}
