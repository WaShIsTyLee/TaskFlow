package Model.Entitys;

import java.io.Serializable;

public class Colaborador implements Serializable {
    String Usuario;

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
        return "Colaborador{" +
                "Usuario='" + Usuario + '\'' +
                '}';
    }

}