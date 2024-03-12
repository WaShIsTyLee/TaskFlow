package Interfaces;

import Model.Entitys.Colaborator;

import java.time.LocalDate;
import java.util.ArrayList;

public interface iProject {

    ArrayList<Colaborator> addColaborator();

    static LocalDate añadirFechaFin() {
        return null;
    }
}
