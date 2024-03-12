package Model.Repository;

import IO.Keyboard;
import Interfaces.iRepoProjectos;
import Model.Proyectos.Project;
import Model.Serializador.Serializador;


import java.io.Serial;
import java.util.ArrayList;
import java.util.Iterator;


public class RepoProjectos extends Repository implements iRepoProjectos {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Metodos relacionados con la creacion y destruccuin y guardado  de repositorios  dentro y fuera del progrma.
     *
     */

    private ArrayList<Project> project;
    private final static String FILENAME = "Repositorio.bin";
    private static RepoProjectos _instance;


    private RepoProjectos() {
        this.project = new ArrayList<>();
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

    public ArrayList<Project> getProject() {
        return project;
    }

    /**
     * Método para eliminar un proyecto de la lista de proyectos.
     * Method to delete a project from the list of projects.
     * @param proyecto El proyecto que se desea eliminar.
     * @return true si el proyecto fue eliminado con éxito, de lo contrario false.
     */
    @Override
    public boolean deleteProjec(Project proyecto) {
        boolean result = false;
        Iterator<Project> iterator = project.iterator();
        while (iterator.hasNext()) {
            Project proyectoEnLista = iterator.next();
            if (proyectoEnLista.getName().equals(proyecto.getName())) {
                iterator.remove();
                result = true;
                System.out.println("Proyecto borrado");
            }
        }
        return result;
    }

    /**
     * Método para crear un nuevo proyecto si no existe en la lista de proyectos.
     * Method to create a new project if it does not exist in the list of projects.
     * @param proyecto El proyecto que se desea crear.
     * @return true si el proyecto se creó con éxito, de lo contrario false.
     */
    @Override
    public boolean createProject(Project proyecto) {

        boolean result = false;
        if (isProject(proyecto) == -1) {
            project.add(proyecto);
            result = true;
            System.out.println("Proyecto creado correctamente");
        } else {
            System.out.println("El proyecto ya existe");
        }
        return result;
    }

    /**
     * Método privado para verificar si un proyecto ya existe en la lista de proyectos.
     * Private method to check if a project already exists in the list of projects.
     * @param projecto El proyecto que se desea verificar.
     * @return El índice del proyecto en la lista de proyectos si existe, de lo contrario -1.
     */
    private int isProject(Project projecto) {
        int index = -1;
        for (int i = 0; i < project.size(); i++) {
            if (project.get(i).getName().equals(projecto.getName())) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Método para listar los proyectos en el repositorio de proyectos.
     * Method to list the projects in the project repository.
     * @param repoProjectos El repositorio de proyectos que se desea listar.
     */
    public static void listProject(ArrayList<Project> repoProjectos) {
        System.out.println(repoProjectos);
    }

    /**
     * Método para buscar un proyecto por su nombre en una lista de proyectos.
     * Method to search for a project by its name in a list of projects.
     * @param proyectos La lista de proyectos en la que se realizará la búsqueda.
     * @return El proyecto encontrado, o null si no se encontró ningún proyecto con el nombre especificado.
     */
    public static Project listByName(ArrayList<Project> proyectos) {
        String nombreProyecto;
        Project proyectoEncontrado = null;
        do {
            nombreProyecto = Keyboard.readString("Introduce el nombre del proyecto a buscar o pulse 'salir': ");
            for (Project proyecto : proyectos) {
                if (proyecto.getName().equalsIgnoreCase(nombreProyecto)) {
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




