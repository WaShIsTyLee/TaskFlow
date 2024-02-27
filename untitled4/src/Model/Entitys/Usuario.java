package Model.Entitys;

import java.util.Objects;

public class Usuario {
    private String nombre;
    private String usuario;
    private String contraseña;
    private String correo;
    private String codigo;

    public Usuario(String nombre, String usuario, String contraseña, String correo, String codigo) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correo = correo;
        this.codigo = codigo;
    }
    public Usuario(){
        this("","","","","");
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

    //Tocar este set para que no se puedan guardar 2 correos iguales
    public void setCorreo(String correo) {

        this.correo = correo;
    }

    public String getCodigo() {
        return codigo;
    }

    //Utilizar el setCodigo de juanje de su anterior proyecto
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public static boolean validarCorreo(String email) {

        return email.matches("^([\\w-]+\\.)*?[\\w-]+@[\\w-]+\\.([\\w-]+\\.)*?[\\w]+$");

    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", correo='" + correo + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario1)) return false;
        return Objects.equals(getUsuario(), usuario1.getUsuario()) && Objects.equals(getCorreo(), usuario1.getCorreo());
    }

    //Falta un hashcode para la contraseña






}
