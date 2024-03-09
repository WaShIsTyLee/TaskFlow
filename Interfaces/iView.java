package Interfaces;

import Model.Entitys.Usuario;

public interface iView {

    void mensajesDeInicio();

    int menuRegistroInicioSesion();

    Usuario menuRegistroUsuario();

    int eleccionCRUD();


    int menuCreador();

    int menuColaborador();


}
