package Controller;


import IO.Keyboard;
import Interfaces.iSecondaryController;
import Model.Entitys.Colaborator;
import Model.Proyectos.Proyectos;
import Model.Proyectos.Task;
import View.View;

public class SecondaryController implements iSecondaryController {
    View view = new View();
    Task task = new Task();

    @Override
    public void switchMenuCRUDcreator(int opcion, Proyectos proyectos) {
        switch (opcion) {
            case 1:
                Keyboard.printString("Creando la tarea...");
                proyectos.getListaTareas().add(task = Task.makeTask());
                break;
            case 2:
                Keyboard.printString("Actualizando estado de la tarea...");
                Task.updateStateTask(proyectos, view.taskName(), Task.StateTasks(view.statusTasks()));
                break;
            case 3:
                Keyboard.printString("Elimando la tarea...");
                Task.deleteTask(proyectos, view.taskName());
                break;
            case 4:
                Keyboard.printString("Estableciendo comentario..");
                String comentario1 = Keyboard.readString("Introduzca comentario");
                Task.addComment(proyectos, view.taskName(), comentario1);
                break;
            case 5:
                Keyboard.printString("Añadiendo colaboradores...");
                String nombreColaborador = Keyboard.readString("Introduce nombre del colaborator a añadir");
                Colaborator colaborator = new Colaborator(nombreColaborador);
                proyectos.getColaborador().add(colaborator);
                break;
            case 6:
                break;

        }

    }

    @Override
    public void switchMenuColaborator(int opcion, Proyectos proyectos) {
        switch (opcion) {
            case 1:
                Keyboard.printString("Editando estado de la tarea...");
                Task.updateStateTask(proyectos, view.taskName(), Task.StateTasks(view.statusTasks()));
                break;
            case 2:
                Keyboard.printString("Añadiendo comentario...");
                String comentario1 = Keyboard.readString("Introduzca comentario");
                Task.addComment(proyectos, view.taskName(), comentario1);
                break;
            case 3:
                view.choiceCRUD();
                break;

        }
    }


}
