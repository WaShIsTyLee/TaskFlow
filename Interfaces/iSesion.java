package Interfaces;

import Model.Archivos.Sesion;
import Model.Entitys.User;

public interface iSesion {

    static Sesion getInstancia() {
        return null;
    }
    void logIn();

    static User getStartedUser() {
        return null;
    }
}
