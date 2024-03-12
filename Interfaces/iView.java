package Interfaces;

import Model.Entitys.User;
import Model.Proyectos.Proyectos;

public interface iView {

    void startMessage();

    int menuRegisterLoginSession();

    static User menuLogin() {
        return null;
    }
    User menuRegister();

    int choiceCRUD();

    int menuCreator();

    int menuColaborator();


    Proyectos viewAddProject();

    int choiceListProject();

    int statusTasks();
    String taskName();

}
