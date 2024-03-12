package Controller;

import IO.Keyboard;
import Interfaces.iController;
import Model.Archivos.Sesion;
import Model.Entitys.Collaborator;
import Model.Entitys.User;
import Model.Proyectos.Project;
import Model.Repository.RepoProjectos;
import View.View;

import java.util.ArrayList;
import java.util.Iterator;


public class MainController implements iController {

    View view = new View();
    RepoProjectos rp = RepoProjectos.getInstance();
    SecondaryController secondaryController = new SecondaryController();

    /**
     *  Indica si el usuario con la sesión inciada es creador de un proyecto
     *  Indicates if the logged-in user is the creator of a project
     * @param proyecto
     * @return booleano que indica si el usuario conectado es el creador del proyecto
     */
    private boolean isCreator(Project proyecto){
        User ultimoUser = Sesion.getUsuarioIniciado();
        boolean aux = false;
        if (proyecto.getCreator().getName().equals(ultimoUser.getName())) {
            aux = true;
        }else{
            Keyboard.printString("No eres creador del proyecto");
        }
        return aux;
    }


    @Override
    public  void startApp() {
        switchMenuRegisterLogin(view.menuRegisterLogin());
    }

    /**
     * Maneja el menú de registro e inicio de sesión.
     * Manage the registration and login menu.
     * @param opcion la opción que eliges, esta opcion viene de otro metodo menuRegisterLogin
     */
    @Override
    public void switchMenuRegisterLogin(int opcion) {
        do {
            switch (opcion) {
                case 1:
                    RepoProjectos.load("Repositorio.bin");
                    Sesion.getInstancia();
                    view.loginMessage();
                    switchChoiceCrud(view.choiceCRUD());
                    break;
                case 2:
                    view.menuUserRegister();
                    switchMenuRegisterLogin(view.menuRegisterLogin());
                    break;

                case 3:
                    Keyboard.printString("Adios y gracias por usar TaskFlow");
                    break;
                default:
                    Keyboard.printString("Ups... Parece que te has equivocado, prueba otra vez.");

            }
        } while (opcion < 1 || opcion > 3);
    }

    /**
     * Maneja la elección del usuario en el menú CRUD.
     * Handles user choice in the CRUD menu.
     * @param opcion la opción que el usuario elige viene de la siguiente funcion choiceCRUD
     */
    @Override
    public void switchChoiceCrud(int opcion) {
        switch (opcion) {
            case 1:
                Keyboard.printString("Listando proyectos...");
                switchList(view.choiceListProject());
                switchChoiceCrud(view.choiceCRUD());
                break;
            case 2:
                Keyboard.printString("Crear proyecto...");
                rp.createProject(view.viewAddProject());
                rp.saveData();
                switchChoiceCrud(view.choiceCRUD());
                break;
            case 3:
                Keyboard.printString("Borrando proyecto...");
                User ultimoUser = Sesion.getUsuarioIniciado();
                Project aux = RepoProjectos.listByName(rp.getProject());
                if (isCreator(aux)){
                    rp.deleteProjec(aux);
                    switchChoiceCrud(view.choiceCRUD());
                }
                switchChoiceCrud(view.choiceCRUD());
                break;
            case 4:
                Keyboard.printString("");
                Keyboard.printString("Lista de usuarios de la app:");
                User.listUsers("usuariosRegistrados");
                Keyboard.printString("");
                switchChoiceCrud(view.choiceCRUD());
                break;
            case 5:
                Keyboard.printString("Saliendo, los cambios se han guardado correctamente.");
                rp.saveData();
                rp.save("Repositorio.bin");
                break;
        }
    }

    /**
     * Maneja las opciones de listado dentro del menú CRUD.
     * Manage listing options within the CRUD menu.
     * @param opcion la opción que el usuario elige para listar proyectos viene de la siguiente funcion
     *               choiceListProject
     */

    @Override
    public void switchList(int opcion) {
        switch (opcion) {
            case 1:
                RepoProjectos.listProject(rp.getProject());
                break;
            case 2:
                Project aux = RepoProjectos.listByName(rp.getProject());
                User ultimoUser = Sesion.getUsuarioIniciado();
                if (aux.getCreator().getName().equals(ultimoUser.getName())) {
                    Keyboard.printString(aux.toString());
                    secondaryController.switchMenuCRUDcreator(view.menuCreator(),aux);
                } else {
                    Collaborator collaborator = Collaborator.findColaborator(aux, ultimoUser);
                    if (collaborator != null && collaborator.getUser().equals(ultimoUser.getName())) {
                        Keyboard.printString(aux.toString());
                        secondaryController.switchMenuColaborator(view.menuColaborator(), aux);
                    } else {
                        Keyboard.printString("No perteneces a ningun proyecto");
                    }
                }
            case 3:
                User ultimoUser1 = Sesion.getUsuarioIniciado();
                listProjectCreator(rp.getProject(), ultimoUser1);
                break;
            case 4:
                User ultimoUser2 = Sesion.getUsuarioIniciado();
                listProjectColaborator(rp.getProject(), ultimoUser2);
                break;
            default:
                break;
        }
    }

    /**
     * Lista todos los proyectos creados por un user específico.
     * Lists all projects created by a specific user.
     * @param proyectos la lista de todos los proyectos
     * @param user el user cuyos proyectos se van a listar
     */
    public static void listProjectCreator(ArrayList<Project> proyectos, User user) {
        Iterator<Project> iterador = proyectos.iterator();
        while (iterador.hasNext()) {
            Project proyecto = iterador.next();
            if (proyecto.getCreator().getName().equals(user.getName())) {
                Keyboard.printString(proyecto.toString());
            }
        }
    }

    /**
     * Lista todos los proyectos en los que el user es colaborador.
     * Lists all projects in which the user is a collaborator.
     * @param proyectos
     * @param user el user cuyos proyectos como colaborador se van a listar
     */
    public static void listProjectColaborator(ArrayList<Project> proyectos, User user) {
        Iterator<Project> iterador = proyectos.iterator();
        while (iterador.hasNext()) {
            Project proyecto = iterador.next();
            for (Collaborator collaborator : proyecto.getColaborador()) {
                if (collaborator.getUser().equals(user.getName())) {
                    Keyboard.printString(proyecto.toString());
                }
            }
        }
    }


}






