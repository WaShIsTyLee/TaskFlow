package Model.Repository;

import Interfaces.iRepoProjectos;
import Model.Proyectos.Projectos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepoProjectos implements iRepoProjectos {
    List<Projectos> projectos = new ArrayList<>();

    public boolean borrarProyecto(Projectos projecto) {
        boolean result = false;
        Iterator<Projectos> iterator = projectos.iterator();
        while (iterator.hasNext()) {
            Projectos proyectoEnLista = iterator.next();
            if (proyectoEnLista.getNombre().equals(projecto.getNombre())) {
                iterator.remove();
                result = true;
            }
        }
        return result;
    }

    public boolean crearProjecto(Projectos projecto) {
        boolean result = false;
        if (isProject(projecto) == -1) {
            projectos.add(projecto);
            result = true;
            System.out.println("Proyecto creado correctamente");
        } else {
            System.out.println("El proyecto ya existe");
        }
        return result;
    }

    private int isProject(Projectos projecto) {
        int index = -1;
        for (int i = 0; i < projectos.size(); i++) {
            if (projectos.get(i).getNombre().equals(projecto.getNombre())) {
                index = i;
                break;
            }
        }
        return index;
    }

}
