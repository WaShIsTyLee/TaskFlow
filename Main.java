import Controller.MainController;
import Controller.SecondaryController;
import Model.Proyectos.Tareas;
import View.View;


public class Main {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        View view = new View();
        SecondaryController secondaryController = new SecondaryController();

        secondaryController.switchMenuCrudTareas(view.menuCrudTareas());
        Tareas.agregarTarea(view.nombreTarea());

        // mainController.switchMenuRegistroInicioSesion(view.menuRegistroInicioSesion());


      //  view.añadirProjecto();





       /* RepoUsuarios ru = RepoUsuarios.getInstance();
        ru.addUsuario(new Usuario("Carlos","Carlos","1234","c@gmail.com","0"));
        ru.addUsuario(new Usuario("Juan","Jua n","1234","j@gmail.com","a"));
        ru.save("usuarios.bin");

        RepoUsuarios.load("usuarios.bin");
        RepoUsuarios ru = RepoUsuarios.getInstance();
        System.out.println(ru.getUsuarios());*/
    }
}