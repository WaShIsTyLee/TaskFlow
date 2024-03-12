package Interfaces;

import Model.Entitys.User;
import Model.Proyectos.Project;

public interface iView {

    void loginMessage();

    int menuRegisterLogin();

    static User menuIniciarSesion() {
        return null;
    }
    User menuUserRegister();

    int choiceCRUD();

    int menuCreator();

    int menuColaborator();

    Project viewDeleteProject();

    Project viewAddProject();

    int choiceListProject();


    String taskName();

}
