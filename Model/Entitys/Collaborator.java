package Model.Entitys;

import Model.Proyectos.Project;
import Interfaces.iColaborador;
import java.io.Serializable;

public class Collaborator extends User implements iColaborador, Serializable{
    /**
     * Metodos relacionados con el manejo de la clase colaborador dentro del progrma.
     *
     */
    private String Usuario;

    public Collaborator(String usuario) {
        Usuario = usuario;
    }

    public String getUser() {
        return Usuario;
    }

    public void setUser(String user) {
        Usuario = user;
    }



    @Override
    public String toString() {
        return Usuario;
    }

    /**
     *
     * @param aux un proyecto declarado como dato auxiliar
     * @param user un user
     * @return
     */
    public static Collaborator findColaborator(Project aux, User user) {
        Collaborator colaboradora = null;
        for (Collaborator collaborator : aux.getColaborador()) {
            if (user.getName().equals(collaborator.getUser())) {
                colaboradora = collaborator;
            }
        }
        System.out.println(colaboradora);
        return colaboradora;
    }

}