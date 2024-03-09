package Interfaces;

import Model.Archivos.Sesion;
import Model.Entitys.Usuario;

public interface iSesion {

    static Sesion getInstancia() {
        return null;
    }
    void iniciarSesion();

    static Usuario getUsuarioIniciado() {
        return null;
    }
}
