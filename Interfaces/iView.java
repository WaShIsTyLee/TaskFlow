package Interfaces;

import Model.Entitys.Usuario;
import Model.Proyectos.Proyectos;

public interface iView {

    void mensajesDeInicio();

    int menuRegistroInicioSesion();

    static Usuario menuIniciarSesion() {
        return null;
    }
    Usuario menuRegistroUsuario();

    int eleccionCRUD();

    int menuCreador();

    int menuColaborador();

    Proyectos viewBorrarProyecto();

    Proyectos viewAñadirProjecto();

    int eleccionListarProyecto();

    int estadoTareas();
    String nombreTarea();

}
