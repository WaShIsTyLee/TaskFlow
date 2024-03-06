package Model.Repository;

import IO.Teclado;
import Interfaces.iRepoProjectos;
import Model.Proyectos.Proyectos;
import Model.Serializador.Serializador;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


public class RepoProjectos extends Repository implements iRepoProjectos, Serializable {

    private ArrayList<Proyectos> proyectos;
    private final static String FILENAME = "Repositorio.bin";
    private static RepoProjectos _instance;

    private RepoProjectos() {
        this.proyectos = new ArrayList<>();
    }

    public static RepoProjectos getInstance() {
        if(_instance==null){
            _instance = (RepoProjectos) load(FILENAME);
            if(_instance==null){
                _instance=new RepoProjectos();
            }
        }
        return _instance;
    }

    public ArrayList<Proyectos> getProyectos() {
        return proyectos;
    }

    public boolean borrarProyecto(Proyectos proyecto) {
        boolean result = false;
        Iterator<Proyectos> iterator = proyectos.iterator();
        while (iterator.hasNext()) {
            Proyectos proyectoEnLista = iterator.next();
            if (proyectoEnLista.getNombre().equals(proyecto.getNombre())) {

                iterator.remove();
                result = true;
            }
        }
        return result;
    }


    public boolean crearProjecto(Proyectos proyecto) {

        boolean result = false;
        if (isProject(proyecto) == -1) {
            proyectos.add(proyecto);
            result = true;
            System.out.println("Proyecto creado correctamente");
        } else {
            System.out.println("El proyecto ya existe");
        }
        return result;
    }

    private int isProject(Proyectos projecto) {
        int index = -1;
        for (int i = 0; i < proyectos.size(); i++) {
            if (proyectos.get(i).getNombre().equals(projecto.getNombre())) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void listarProyectos(ArrayList<Proyectos> repoProjectos) {
        System.out.println(repoProjectos);
    }

    public static void listarProyectoporNombre(ArrayList<Proyectos> proyectos) {
        String a;
        do {
            a = Teclado.leeString("Introduce el nombre a buscar o pulse salir: ");
            boolean proyectoEncontrado = false;
            for (Proyectos proyecto : proyectos) {
                if (proyecto.getNombre().equalsIgnoreCase(a)) {
                    System.out.println(proyecto);
                    proyectoEncontrado = true;
                }
            }
            if (!proyectoEncontrado) {
                System.out.println("No existe ningún proyecto con ese nombre.");
            }
        } while (!a.equalsIgnoreCase("salir"));
    }

    public boolean saveData() {
        return Serializador.serialize(this, FILENAME);
    }

    public static RepoProjectos loadData() {
        return (RepoProjectos) Serializador.deserializer(FILENAME);
    }
}




