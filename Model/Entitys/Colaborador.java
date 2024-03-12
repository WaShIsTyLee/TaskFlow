package Model.Entitys;

import Model.Proyectos.Proyectos;
import Interfaces.iColaborador;
import java.io.Serializable;

public class Colaborador extends Usuario implements iColaborador, Serializable{
    /**
     * Metodos relacionados con el manejo de la clase colaborador dentro del progrma.
     *
     */
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

    /**
     *
     * @param aux un proyecto declarado como dato auxiliar
     * @param usuario un usuario
     * @return
     */
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