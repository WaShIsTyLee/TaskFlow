package Model.Repository;

import IO.Keyboard;
import Interfaces.iRepoProjectos;
import Model.Proyectos.Proyectos;
import Model.Serializador.Serializador;


import java.io.Serial;
import java.util.ArrayList;
import java.util.Iterator;


public class RepoProjectos extends Repository implements iRepoProjectos {
    @Serial
    private static final long serialVersionUID = 1L;

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
    @Override
    public boolean deleteProject(Proyectos proyecto) {
        boolean result = false;
        Iterator<Proyectos> iterator = proyectos.iterator();
        while (iterator.hasNext()) {
            Proyectos proyectoEnLista = iterator.next();
            if (proyectoEnLista.getNombre().equals(proyecto.getNombre())) {
                iterator.remove();
                result = true;
                System.out.println("Proyecto borrado");
            }
        }
        return result;
    }

    @Override
    public boolean createProject(Proyectos proyecto) {

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

    public static void listProject(ArrayList<Proyectos> repoProjectos) {
        System.out.println(repoProjectos);
    }

    public static Proyectos listByName(ArrayList<Proyectos> proyectos) {
        String nombreProyecto;
        Proyectos proyectoEncontrado = null;
        do {
            nombreProyecto = Keyboard.readString("Introduce el nombre del proyecto a buscar o pulse 'salir': ");
            for (Proyectos proyecto : proyectos) {
                if (proyecto.getNombre().equalsIgnoreCase(nombreProyecto)) {
                    proyectoEncontrado = proyecto; // Asigna el proyecto encontrado
                }
            }
            if (proyectoEncontrado == null) {
                System.out.println("No se encontró ningún proyecto con ese nombre.");
            }
        } while (!nombreProyecto.equalsIgnoreCase("salir") && proyectoEncontrado == null);
        return proyectoEncontrado; // Devuelve el proyecto encontrado o null si no se encontró ninguno
    }
    @Override
    public boolean saveData() {
        return Serializador.serialize(this, FILENAME);
    }


    public static RepoProjectos loadData() {
        return (RepoProjectos) Serializador.deserializer(FILENAME);
    }
}




