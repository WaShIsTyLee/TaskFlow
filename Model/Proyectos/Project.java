package Model.Proyectos;

import IO.Keyboard;
import Interfaces.iProject;
import Model.Entitys.Collaborator;
import Model.Entitys.User;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Project implements iProject, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * Metodos relacionados con el manejo de los proyectos dentro del progrma.
     *
     */

    static String d = "\u001B[0m"; // Stop print the color // Parar el color establecido
    static String red = "\033[31m"; // Rojo
    static String purple = "\033[35m";


    ArrayList<Task> listaTareas = new ArrayList<>();
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private ArrayList <Collaborator> collaborator = new ArrayList<>();
    private User creator;

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public ArrayList<Task> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(ArrayList<Task> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public ArrayList<Collaborator> getColaborador() {
        return collaborator;
    }

    public void setColaborador(ArrayList<Collaborator> collaborator) {
        this.collaborator = collaborator;
    }

    public Project(ArrayList<Task> listaTareas, String name, String description, LocalDate startDate, LocalDate endDate, ArrayList<Collaborator> collaborator, User creator) {
        this.listaTareas = listaTareas;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.collaborator = collaborator;
        this.creator = creator;
    }

    public Project(){
        this(null,"","",LocalDate.now(),null,null,null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d+"\n");
        sb.append(red + "\n"+
                "  _____                                         _                 \n" +
                " |  __ \\                                       | |                \n" +
                " | |__) |  _ __    ___    _   _    ___    ___  | |_    ___    ___ \n" +
                " |  ___/  | '__|  / _ \\  | | | |  / _ \\  / __| | __|  / _ \\  / __|\n" +
                " | |      | |    | (_) | | |_| | |  __/ | (__  | |_  | (_) | \\__ \\\n" +
                " |_|      |_|     \\___/   \\__, |  \\___|  \\___|  \\__|  \\___/  |___/\n" +
                "                           __/ |                                  \n" +
                "                          |___/                                   \n" + d  );
        sb.append("Nombre del proyecto: ").append(name).append("\n");
        sb.append("Descripción: ").append(description).append("\n");
        sb.append("Fecha de Inicio: ").append(startDate).append("\n");
        sb.append("Fecha de Finalización: ").append(endDate).append("\n");
        sb.append("Creador: ").append(creator).append("\n");
        sb.append("Collaborator: ").append(collaborator).append("\n");
        sb.append("Task: \n");
        for (Task tarea : listaTareas) {
            sb.append("\t ").append(tarea).append("\n");
        }
        sb.append(purple + "◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥◤▲◥" + d+"\n");

        return sb.toString();
    }

    /**
     * Método para agregar colaboradores a una lista.
     * Method to add collaborators to a list.
     * @return La lista de colaboradores actualizada.
     */

    @Override
    public ArrayList<Collaborator> addColaborator() {
        ArrayList <Collaborator> collaborator = new ArrayList<>();

        boolean auxSN = true;
        while (auxSN) {
            Collaborator colaboradoraux = new Collaborator("");
            colaboradoraux.setUser(Keyboard.readString("Introduce el nombre del collaborator: "));
            collaborator.add(colaboradoraux);
            String respuesta = Keyboard.readString("Quieres añadir otro collaborator (s/n)? ");
            auxSN = respuesta.equalsIgnoreCase("s");
        }
        return collaborator;
    }

    /**
     * Método para agregar la fecha de finalización.
     * Method to add the end date.
     * @return La fecha de finalización ingresada por el usuario.
     */
    public static LocalDate addEndDate() {
        LocalDateTime ahora = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaActualStr = formatter.format(ahora);

        LocalDate fechaFinalizacion = null;

        while (fechaFinalizacion == null) {
            String fechaFinalizacionStr = Keyboard.readString("Introduce la fecha de finalización (formato AAAA-MM-DD):");

            if (fechaFinalizacionStr.matches("\\d{4}-\\d{2}-\\d{2}") && fechaFinalizacionStr.compareTo(fechaActualStr) >= 0) {
                fechaFinalizacion = LocalDate.parse(fechaFinalizacionStr, formatter);
            } else {
                System.out.println("Error: La fecha de finalización no puede ser anterior a la fecha actual o el formato es incorrecto. " +
                        "Por favor, inténtalo de nuevo.");
            }
        }

        return fechaFinalizacion;
    }
}


