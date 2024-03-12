package Controller;

import IO.Teclado;
import Interfaces.iController;
import Model.Archivos.Datos;
import Model.Archivos.Sesion;
import Model.Entitys.Colaborador;
import Model.Entitys.Usuario;
import Model.Proyectos.Proyectos;
import Model.Repository.RepoProjectos;
import View.View;

import java.util.ArrayList;
import java.util.Iterator;


public class MainController implements iController {

    View view = new View();
    RepoProjectos rp = RepoProjectos.getInstance();
    SecondaryController secondaryController = new SecondaryController();

    /**
     *
     * @param proyecto el proyecto en cuestion
     * @return
     */
    private boolean esCreador(Proyectos proyecto){
        Usuario ultimoUsuario = Sesion.getUsuarioIniciado();
        boolean aux = false;
        if (proyecto.getCreador().getNombre().equals(ultimoUsuario.getNombre())) {
            aux = true;
        }else{
            Teclado.imprimirCadena("No eres creador del proyecto");
        }
        return aux;
    }


    @Override
    public  void startApp() {
        switchMenuRegistroInicioSesion(view.menuRegistroInicioSesion());
    }

    /**
     *
     * @param opcion la opcion que eliges
     */
    @Override
    public void switchMenuRegistroInicioSesion(int opcion) {
        do {
            switch (opcion) {
                case 1:
                    RepoProjectos.load("Repositorio.bin");
                    Sesion.getInstancia();
                    view.mensajesDeInicio();
                    switchEleccionCrud(view.eleccionCRUD());
                    break;
                case 2:
                    view.menuRegistroUsuario();
                    switchMenuRegistroInicioSesion(view.menuRegistroInicioSesion());
                    break;

                case 3:
                    Teclado.imprimirCadena("Adios y gracias por usar TaskFlow");
                    break;
                default:
                    Teclado.imprimirCadena("Ups... Parece que te has equivocado, prueba otra vez.");

            }
        } while (opcion < 1 || opcion > 3);
    }

    /**
     *
     * @param opcion la opcion que eliges
     */
    @Override
    public void switchEleccionCrud(int opcion) {
        switch (opcion) {
            case 1:
                Teclado.imprimirCadena("Listando proyectos...");
                switchListar(view.eleccionListarProyecto());
                switchEleccionCrud(view.eleccionCRUD());
                break;
            case 2:
                Teclado.imprimirCadena("Crear proyecto...");
                rp.crearProjecto(view.viewAñadirProjecto());
                rp.saveData();
                switchEleccionCrud(view.eleccionCRUD());
                break;
            case 3:
                Teclado.imprimirCadena("Borrando proyecto...");
                Usuario ultimoUsuario = Sesion.getUsuarioIniciado();
                Proyectos aux = RepoProjectos.listarProyectoporNombre(rp.getProyectos());
                if (esCreador(aux)){
                    rp.borrarProyecto(aux);
                    switchEleccionCrud(view.eleccionCRUD());
                }
                switchEleccionCrud(view.eleccionCRUD());
                break;
            case 4:
                Teclado.imprimirCadena("");
                Teclado.imprimirCadena("Lista de usuarios de la app:");
                Usuario.listarUsuarios("usuariosRegistrados");
                Teclado.imprimirCadena("");
                switchEleccionCrud(view.eleccionCRUD());
                break;
            case 5:
                Teclado.imprimirCadena("Saliendo, los cambios se han guardado correctamente.");
                rp.saveData();
                rp.save("Repositorio.bin");
                break;
        }
    }

    /**
     *
     * @param opcion la opcion que eliges
     */
    @Override
    public void switchListar(int opcion) {
        switch (opcion) {
            case 1:
                RepoProjectos.listarProyectos(rp.getProyectos());
                break;
            case 2:
                Proyectos aux = RepoProjectos.listarProyectoporNombre(rp.getProyectos());
                Usuario ultimoUsuario = Sesion.getUsuarioIniciado();
                if (aux.getCreador().getNombre().equals(ultimoUsuario.getNombre())) {
                    Teclado.imprimirCadena(aux.toString());
                    secondaryController.switchMenuCRUDcreador(view.menuCreador(),aux);
                } else {
                    Colaborador colaborador = Colaborador.encontrarColaborador(aux, ultimoUsuario);
                    if (colaborador != null && colaborador.getUsuario().equals(ultimoUsuario.getNombre())) {
                        Teclado.imprimirCadena(aux.toString());
                        secondaryController.switchMenuColaborador(view.menuColaborador(), aux);
                    } else {
                        Teclado.imprimirCadena("No perteneces a ningun proyecto");
                    }
                }
            case 3:
                Usuario ultimoUsuario1 = Sesion.getUsuarioIniciado();
                listarProyectosCreador(rp.getProyectos(),ultimoUsuario1);
                break;
            case 4:
                Usuario ultimoUsuario2 = Sesion.getUsuarioIniciado();
                listarProyectosColaborador(rp.getProyectos(),ultimoUsuario2);
                break;
            default:
                break;
        }
    }

    /**
     *
     * @param proyectos lista de proyectos
     * @param usuario nombre de usuario
     */
    public static void listarProyectosCreador(ArrayList<Proyectos> proyectos, Usuario usuario) {
        Iterator<Proyectos> iterador = proyectos.iterator();
        while (iterador.hasNext()) {
            Proyectos proyecto = iterador.next();
            if (proyecto.getCreador().getNombre().equals(usuario.getNombre())) {
                Teclado.imprimirCadena(proyecto.toString());
            }
        }
    }

    /**
     *
     * @param proyectos lista de proyectos
     * @param usuario nombre de usuario
     */
    public static void listarProyectosColaborador(ArrayList<Proyectos> proyectos, Usuario usuario) {
        Iterator<Proyectos> iterador = proyectos.iterator();
        while (iterador.hasNext()) {
            Proyectos proyecto = iterador.next();
            for (Colaborador colaborador : proyecto.getColaborador()) {
                if (colaborador.getUsuario().equals(usuario.getNombre())) {
                    Teclado.imprimirCadena(proyecto.toString());
                }
            }
        }
    }
}






