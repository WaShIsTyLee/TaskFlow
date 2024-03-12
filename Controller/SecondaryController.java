package Controller;


import IO.Teclado;
import Interfaces.iSecondaryController;
import Model.Entitys.Colaborador;
import Model.Proyectos.Proyectos;
import Model.Proyectos.Tareas;
import View.View;

public class SecondaryController implements iSecondaryController {
    View view = new View();
    Tareas tareas = new Tareas();

    /**
     * Gestiona las acciones CRUD para las tareas de un proyecto específico.
     * @param opcion la opción que el usuario elige en el menú CRUD del creador
     * @param proyectos el proyecto sobre el cual se realizan las acciones CRUD
     */
    @Override
    public void switchMenuCRUDcreador(int opcion, Proyectos proyectos) {
        switch (opcion) {
            case 1:
                Teclado.imprimirCadena("Creando la tarea...");
                proyectos.getListaTareas().add(tareas = Tareas.crearTarea());
                break;
            case 2:
                Teclado.imprimirCadena("Actualizando estado de la tarea...");
                Tareas.actualizarEstadoTarea(proyectos, view.nombreTarea(), Tareas.imprimirEstadoTareas(view.estadoTareas()));
                break;
            case 3:
                Teclado.imprimirCadena("Elimando la tarea...");
                Tareas.eliminarTarea(proyectos, view.nombreTarea());
                break;
            case 4:
                Teclado.imprimirCadena("Estableciendo comentario..");
                String comentario1 = Teclado.leeString("Introduzca comentario");
                Tareas.añadirComentario(proyectos, view.nombreTarea(), comentario1);
                break;
            case 5:
                Teclado.imprimirCadena("Añadiendo colaboradores...");
                String nombreColaborador = Teclado.leeString("Introduce nombre del colaborador a añadir");
                Colaborador colaborador = new Colaborador(nombreColaborador);
                proyectos.getColaborador().add(colaborador);
                break;
            case 6:
                break;

        }

    }
    /**
     * Gestiona las opciones del menú para colaboradores en un proyecto.
     * @param opcion la opción que el usuario elige en el menú de colaborador
     * @param proyectos el proyecto sobre el cual se realizan las acciones
     */
    @Override
    public void switchMenuColaborador(int opcion, Proyectos proyectos) {
        switch (opcion) {
            case 1:
                Teclado.imprimirCadena("Editando estado de la tarea...");
                Tareas.actualizarEstadoTarea(proyectos, view.nombreTarea(), Tareas.imprimirEstadoTareas(view.estadoTareas()));
                break;
            case 2:
                Teclado.imprimirCadena("Añadiendo comentario...");
                String comentario1 = Teclado.leeString("Introduzca comentario");
                Tareas.añadirComentario(proyectos, view.nombreTarea(), comentario1);
                break;
            case 3:
                view.eleccionCRUD();
                break;

        }
    }


}
