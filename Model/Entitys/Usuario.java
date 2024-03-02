package Model.Entitys;

import Model.Proyectos.Projectos;
import Model.Proyectos.Tareas;
import Model.Proyectos.TipoRol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Usuario implements Serializable {
    private String nombre;
    private String usuario;
    private String contraseña;
    private String correo;
    private String codigo;
    private TipoRol tipoRol;


    public Usuario(String nombre, String usuario, String contraseña, String correo, String codigo, TipoRol tipoRol) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correo = correo;
        this.codigo = codigo;
        this.tipoRol = tipoRol;
    }
    public Usuario(){
        this("","","","","",null);
    }

    public static boolean validarCorreo(String email) {

        return email.matches("^([\\w-]+\\.)*?[\\w-]+@[\\w-]+\\.([\\w-]+\\.)*?[\\w]+$");

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public TipoRol getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(TipoRol tipoRol) {
        this.tipoRol = tipoRol;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getUsuario(), usuario.getUsuario()) ||
                Objects.equals(getCorreo(), usuario.getCorreo());    }

    //Falta un hashcode para la contraseña


    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", correo='" + correo + '\'' +
                ", codigo='" + codigo + '\'' +
                ", tipoRol=" + tipoRol +
                '}';
    }
}
