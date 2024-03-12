package Model.Entitys;

import Model.Proyectos.Proyectos;
import Interfaces.iColaborador;

import java.io.Serial;
import java.io.Serializable;

public class Colaborator extends User implements iColaborador, Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    private String Usuario;

    public Colaborator(String usuario) {
        Usuario = usuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }



    @Override
    public String toString() {
        return Usuario;
    }

    public static Colaborator findCollaborator(Proyectos aux, User user) {
        Colaborator colaboradora = null;
        for (Colaborator colaborator : aux.getColaborador()) {
            if (user.getNombre().equals(colaborator.getUsuario())) {
                colaboradora = colaborator;
            }
        }
        System.out.println(colaboradora);
        return colaboradora;
    }

}