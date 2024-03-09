package Interfaces;

import Model.Entitys.Colaborador;
import Model.Proyectos.Proyectos;

import java.time.LocalDate;
import java.util.ArrayList;

public interface iProject {

    ArrayList<Colaborador> añadirColaborador();

    static LocalDate añadirFechaFin() {
        return null;
    }
}
