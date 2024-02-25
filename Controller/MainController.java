package Controller;

import Interfaces.iController;
import Model.Entitys.Usuario;
import View.View;

public class MainController implements iController {

    View view = new View();
    Usuario usuario = new Usuario();


    @Override
    public void switchMenuRegistroInicioSesion() {
        int opcion = 0;

        do {
                opcion = view.menuRegistroInicioSesion();
                switch (opcion) {
                    case 1:
                        view.menuIniciarSesion();
                        break;
                    case 2:
                        view.menuRegistroUsuario();
                        break;
                    default:
                        System.out.println("Elige la opcion correcta.");
                }
        } while (!(opcion == 1 || opcion == 2));
    }

}

