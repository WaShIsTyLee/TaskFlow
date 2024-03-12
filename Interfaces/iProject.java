package Interfaces;

import Model.Entitys.Collaborator;

import java.time.LocalDate;
import java.util.ArrayList;

public interface iProject {

    ArrayList<Collaborator> addColaborator();

    static LocalDate añadirFechaFin() {
        return null;
    }
}
