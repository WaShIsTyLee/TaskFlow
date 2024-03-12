package Model.Archivos;

import Model.Entitys.Usuario;
import View.View;
import Interfaces.iSesion;

public class Sesion implements iSesion {
    /**
     * Metodos relacionados con el manejo de la sesión dentro del progrma.
     */
    private static Sesion _instance;
    private static Usuario usuarioIniciado;

    private Sesion() {
    }

    public static Sesion getInstancia() {
        if (_instance == null) {
            _instance = new Sesion();
            _instance.iniciarSesion();
        }
        return _instance;
    }
    @Override
    public void iniciarSesion() {
        this.usuarioIniciado = View.menuIniciarSesion();
    }

    public static Usuario getUsuarioIniciado() {
        return usuarioIniciado;
    }
}
