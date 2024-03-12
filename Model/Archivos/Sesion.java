package Model.Archivos;

import Model.Entitys.User;
import View.View;
import Interfaces.iSesion;

public class Sesion implements iSesion {
    /**
     * Metodos relacionados con el manejo de la sesión dentro del progrma.
     */
    private static Sesion _instance;
    private static User userIniciado;

    private Sesion() {
    }

    public static Sesion getInstancia() {
        if (_instance == null) {
            _instance = new Sesion();
            _instance.logIn();
        }
        return _instance;
    }
    @Override
    public void logIn() {
        this.userIniciado = View.menuLogin();
    }

    public static User getStartedUser() {
        return userIniciado;
    }
}
