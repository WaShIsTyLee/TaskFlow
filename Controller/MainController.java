package Controller;

import Interfaces.iController;
import View.View;

import java.util.InputMismatchException;

public class MainController implements iController {

    View view = new View();

    public void mensajesDeInicio(){

    }

    @Override
    public void switchMenuRegistroInicioSesion() {
        int opcion;
        boolean entradaValida = false;
        do {
                opcion = view.menuRegistroInicioSesion();
                switch (opcion) {
                    case 1:
                        view.menuIniciarSesion();
                        entradaValida = true;
                        break;
                    case 2:
                        view.menuRegistroUsuario();
                        entradaValida = true;
                        break;
                    default:
                        System.out.println("Elige la opcion correcta:");
                }
        } while (!entradaValida);
    }

}

