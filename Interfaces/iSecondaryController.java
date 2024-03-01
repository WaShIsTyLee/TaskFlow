package Interfaces;

import Model.Entitys.Usuario;
import Model.Proyectos.Projectos;

import java.util.ArrayList;

public interface iSecondaryController {

    void switchMenuCRUDcreador();

    void switchMenuColaborador();

    boolean borrarProyecto(String nombre, ArrayList<Projectos> listaProyectos);
}
