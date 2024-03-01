package Controller;

import Interfaces.iSecondaryController;
import Model.Entitys.Usuario;
import Model.Proyectos.Projectos;

import java.util.ArrayList;
import java.util.Iterator;

public class SecondaryController implements iSecondaryController {


    @Override
    public void switchMenuCRUDcreador() {

    }

    @Override
    public void switchMenuColaborador() {

    }



    /**
     *
     * @param nombre que se le pide al usuario y es el que usara para borrar ese nombre de la lista
     * @param listaProyectos
     * @return
     */
    @Override
    public boolean borrarProyecto(String nombre, ArrayList<Projectos> listaProyectos) {
        boolean result = false;
        Iterator<Projectos> iterator = listaProyectos.iterator();
        while (iterator.hasNext()) {
            Projectos proyecto = iterator.next();
            if (proyecto.getNombre().equals(nombre)) {
                iterator.remove();
                result = true;
            }
        }
        return result;

    }
}
