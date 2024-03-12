package Controller;

import IO.Keyboard;
import Interfaces.iController;
import Model.Archivos.Sesion;
import Model.Entitys.Colaborator;
import Model.Entitys.User;
import Model.Proyectos.Proyectos;
import Model.Repository.RepoProjectos;
import View.View;

import java.util.ArrayList;
import java.util.Iterator;


public class MainController implements iController {

    View view = new View();
    RepoProjectos rp = RepoProjectos.getInstance();
    SecondaryController secondaryController = new SecondaryController();

    private boolean isCreator(Proyectos proyecto){
        User ultimoUser = Sesion.getStartedUser();
    /**
     * Indica si es creador
     * @param proyecto el proyecto en cuestion
     * @return booleano que indica si el usuario conectado es el creador del proyecto
     */

        boolean aux = false;
        if (proyecto.getCreador().getNombre().equals(ultimoUser.getNombre())) {
            aux = true;
        }else{
            Keyboard.printString("No eres creador del proyecto");
        }
        return aux;
    }


    @Override
    public  void startApp() {
        switchMenuRegisterHomeSession(view.menuRegisterLoginSession());
    }

    /**
     * Maneja el menú de registro e inicio de sesión.
     *
     * @param opcion la opción que eliges
     */
    @Override
    public void
    switchMenuRegisterHomeSession(int opcion) {
        do {
            switch (opcion) {
                case 1:
                    RepoProjectos.load("Repositorio.bin");
                    Sesion.getInstancia();
                    view.startMessage();
                    switchElectionCrud(view.choiceCRUD());
                    break;
                case 2:
                    view.menuRegister();

                    switchMenuRegisterHomeSession(view.menuRegisterLoginSession());
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
     * @param opcion la opción que el usuario elige
     */
    @Override
    public void switchElectionCrud(int opcion) {
        switch (opcion) {
            case 1:
                Keyboard.printString("Listando proyectos...");
                switchList(view.choiceListProject());
                switchElectionCrud(view.choiceCRUD());
                break;
            case 2:
                Keyboard.printString("Crear proyecto...");
                rp.createProject(view.viewAddProject());
                rp.saveData();
                switchElectionCrud(view.choiceCRUD());
                break;
            case 3:
                Keyboard.printString("Borrando proyecto...");
                User ultimoUser = Sesion.getStartedUser();
                Proyectos aux = RepoProjectos.listByName(rp.getProyectos());
                if (isCreator(aux)){
                    rp.deleteProject(aux);
                    switchElectionCrud(view.choiceCRUD());
                }
                switchElectionCrud(view.choiceCRUD());
                break;
            case 4:
                Keyboard.printString("");
                Keyboard.printString("Lista de usuarios de la app:");
                User.listUsers("usuariosRegistrados");
                Keyboard.printString("");
                switchElectionCrud(view.choiceCRUD());
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
     * @param opcion la opción que el usuario elige para listar proyectos
     */

    @Override
    public void switchList(int opcion) {
        switch (opcion) {
            case 1:
                RepoProjectos.listProject(rp.getProyectos());
                break;
            case 2:
                Proyectos aux = RepoProjectos.listByName(rp.getProyectos());
                User ultimoUser = Sesion.getStartedUser();
                if (aux.getCreador().getNombre().equals(ultimoUser.getNombre())) {
                    Keyboard.printString(aux.toString());
                    secondaryController.switchMenuCRUDcreator(view.menuCreator(),aux);
                } else {
                    Colaborator colaborator = Colaborator.findCollaborator(aux, ultimoUser);
                    if (colaborator != null && colaborator.getUsuario().equals(ultimoUser.getNombre())) {
                        Keyboard.printString(aux.toString());
                        secondaryController.switchMenuColaborator(view.menuColaborator(), aux);
                    } else {
                        Keyboard.printString("No perteneces a ningun proyecto");
                    }
                }
            case 3:
                User ultimoUser1 = Sesion.getStartedUser();
                listProjectsCreator(rp.getProyectos(), ultimoUser1);
                break;
            case 4:
                User ultimoUser2 = Sesion.getStartedUser();
                listProjectsCollaborator(rp.getProyectos(), ultimoUser2);
                break;
            default:
                break;
        }
    }
    public static void listProjectsCreator(ArrayList<Proyectos> proyectos, User user) {

    /**
     * Lista todos los proyectos creados por un usuario específico.
     * @param proyectos la lista de todos los proyectos
     * @param usuario el usuario cuyos proyectos se van a listar
     */

        Iterator<Proyectos> iterador = proyectos.iterator();
        while (iterador.hasNext()) {
            Proyectos proyecto = iterador.next();
            if (proyecto.getCreador().getNombre().equals(user.getNombre())) {
                Keyboard.printString(proyecto.toString());
            }
        }
    }
    public static void listProjectsCollaborator(ArrayList<Proyectos> proyectos, User user) {

    /**
     * Lista todos los proyectos en los que el usuario es colaborador.
     * @param proyectos la lista de todos los proyectos
     * @param usuario el usuario cuyos proyectos como colaborador se van a listar
     */

        Iterator<Proyectos> iterador = proyectos.iterator();
        while (iterador.hasNext()) {
            Proyectos proyecto = iterador.next();
            for (Colaborator colaborator : proyecto.getColaborador()) {
                if (colaborator.getUsuario().equals(user.getNombre())) {
                    Keyboard.printString(proyecto.toString());
                }
            }
        }
    }
}






