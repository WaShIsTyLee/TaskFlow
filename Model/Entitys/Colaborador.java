package Model.Entitys;

public class Colaborador extends Usuario {
    String nombre;

    public Colaborador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Colaborador{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
