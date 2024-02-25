import Controller.MainController;


public class Main {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        int opcion=0;
        do {
            mainController.switchMenuRegistroInicioSesion();
            opcion ++;
        }while (opcion !=2);

    }
}