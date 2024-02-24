package View;
import Interfaces.iView;
import Model.Entitys.Usuario;

public class View implements iView {
    @Override
    public int menuRegistroInicioSesion() {
        return 0;
    }

    @Override
    public void menuIniciarSesion() {

    }

    @Override
    public Usuario menuRegistroUsuario() {
        return null;
    }
}
