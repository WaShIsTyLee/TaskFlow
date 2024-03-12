package Interfaces;

import Model.Proyectos.Project;
import Model.Repository.RepoProjectos;


import java.io.Serializable;
import java.util.ArrayList;

public interface iRepoProjectos extends Serializable {

    boolean deleteProjec(Project projecto);
    boolean createProject(Project proyecto);

    private int isProject(Project projecto) {
        return 0;
    }

    static RepoProjectos getInstance() {
        return null;
    }
    static void listarProyectos(ArrayList<Project> repoProjectos) {

    }

    static Project listarProyectoporNombre(ArrayList<Project> proyectos) {
        return null;
    }
    boolean saveData();

    static RepoProjectos loadData() {
        return null;
    }
}
