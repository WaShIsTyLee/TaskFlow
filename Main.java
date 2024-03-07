import Controller.MainController;
import Controller.SecondaryController;
import Model.Proyectos.Tareas;
import View.View;


public class Main {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        View view = new View();
        SecondaryController secondaryController = new SecondaryController();

        mainController.startApp();

    }
}
