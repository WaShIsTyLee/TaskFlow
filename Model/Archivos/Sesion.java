package Model.Archivos;

import Model.Entitys.Usuario;
import View.View;

public class Sesion {
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

    private void iniciarSesion() {
        this.usuarioIniciado = View.menuIniciarSesion();
    }

    public static Usuario getUsuarioIniciado() {
        return usuarioIniciado;
    }
}
