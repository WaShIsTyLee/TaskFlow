package Interfaces;

import Model.Proyectos.Proyectos;
import Model.Repository.RepoProjectos;


import java.io.Serializable;
import java.util.ArrayList;

public interface iRepoProjectos {

    boolean deleteProject(Proyectos projecto);
    boolean createProject(Proyectos proyecto);

    private int isProject(Proyectos projecto) {
        return 0;
    }

    static RepoProjectos getInstance() {
        return null;
    }
    static void listProject(ArrayList<Proyectos> repoProjectos) {

    }

    static Proyectos listByName(ArrayList<Proyectos> proyectos) {
        return null;
    }
    boolean saveData();

    static RepoProjectos loadData() {
        return null;
    }
}
