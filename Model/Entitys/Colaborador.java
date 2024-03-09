package Model.Entitys;

import Model.Proyectos.Proyectos;
import Interfaces.iColaborador;
import java.io.Serializable;

public class Colaborador extends Usuario implements iColaborador, Serializable{
    private String Usuario;

    public Colaborador(String usuario) {
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

    public static Colaborador encontrarColaborador(Proyectos aux, Usuario usuario) {
        Colaborador colaboradora = null;
        for (Colaborador colaborador : aux.getColaborador()) {
            if (usuario.getNombre().equals(colaborador.getUsuario())) {
                colaboradora = colaborador;
            }
        }
        System.out.println(colaboradora);
        return colaboradora;
    }

}