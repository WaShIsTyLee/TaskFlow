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
    int eleccionCRUD();
    //1 listar proyecto 2 crear proyecto 3 Borrar proyecto 4 Organizar tareas 5 Salir y guardar(Serializador)
    int tareasProyecto();
    //1 Tareas de mi proecto(Assignar Tareas) 2 Ver tareas como coloaborador
}
