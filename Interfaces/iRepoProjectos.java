package Interfaces;

import Model.Proyectos.Proyectos;
import Model.Repository.RepoProjectos;


import java.io.Serializable;
import java.util.ArrayList;

public interface iRepoProjectos extends Serializable {

    boolean borrarProyecto(Proyectos projecto);
    boolean crearProjecto(Proyectos proyecto);

    private int isProject(Proyectos projecto) {
        return 0;
    }

    static RepoProjectos getInstance() {
        return null;
    }
    static void listarProyectos(ArrayList<Proyectos> repoProjectos) {

    }

    static Proyectos listarProyectoporNombre(ArrayList<Proyectos> proyectos) {
        return null;
    }
    boolean saveData();

    static RepoProjectos loadData() {
        return null;
    }
}
