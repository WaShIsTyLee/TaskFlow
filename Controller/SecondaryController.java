package Controller;


import IO.Keyboard;
import Interfaces.iSecondaryController;
import Model.Entitys.Collaborator;
import Model.Proyectos.Project;
import Model.Proyectos.Task;
import View.View;

public class SecondaryController implements iSecondaryController {
    View view = new View();
    Task task = new Task();

    /**
     * Gestiona las acciones CRUD para las task de un proyecto específico.
     * Manage CRUD actions for tasks in a specific project.
     * @param opcion la opción que el usuario elige en el menú CRUD del creador viene de la funcion
     *               menuCreator
     * @param project el proyecto sobre el cual se realizan las acciones CRUD
     */
    @Override
    public void switchMenuCRUDcreator(int opcion, Project project) {
        switch (opcion) {
            case 1:
                Keyboard.printString("Creando la tarea...");
                project.getListaTareas().add(task = Task.createTask());
                break;
            case 2:
                Keyboard.printString("Actualizando estado de la tarea...");
                Task.updateTaskStatus(project, view.taskName(), Task.taskStatus(Task.taskStatus()));
                break;
            case 3:
                Keyboard.printString("Elimando la tarea...");
                Task.deleteTask(project, view.taskName());
                break;
            case 4:
                Keyboard.printString("Estableciendo comentario..");
                String comentario1 = Keyboard.readString("Introduzca comentario");
                Task.addComment(project, view.taskName(), comentario1);
                break;
            case 5:
                Keyboard.printString("Añadiendo colaboradores...");
                String nombreColaborador = Keyboard.readString("Introduce nombre del collaborator a añadir");
                Collaborator collaborator = new Collaborator(nombreColaborador);
                project.getColaborador().add(collaborator);
                break;
            case 6:
                break;

        }

    }
    /**
     * Gestiona las opciones del menú para colaboradores en un proyecto.
     * Manage menu options for collaborators on a project.
     * @param opcion la opción que el usuario elige en el menú de colaborador viene de la funcion
     *               menuColaborator
     * @param project el proyecto sobre el cual se realizan las acciones
     */
    @Override
    public void switchMenuColaborator(int opcion, Project project) {
        switch (opcion) {
            case 1:
                Keyboard.printString("Editando estado de la tarea...");
                Task.updateTaskStatus(project, view.taskName(), Task.taskStatus(Task.taskStatus()));
                break;
            case 2:
                Keyboard.printString("Añadiendo comentario...");
                String comentario1 = Keyboard.readString("Introduzca comentario");
                Task.addComment(project, view.taskName(), comentario1);
                break;
            case 3:
                view.choiceCRUD();
                break;

        }
    }


}
