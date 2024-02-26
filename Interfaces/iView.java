package Interfaces;

import Model.Entitys.Usuario;

public interface iView {

    void mensajesDeInicio();
    int menuRegistroInicioSesion();
        //1.Iniciar sesion, 2.Registrarse
    void menuIniciarSesion();
        //intentar hacer el monigote
    Usuario menuRegistroUsuario();
        //Registrar usuario con los setter

}
