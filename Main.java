import View.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        int opcion =0;
        do{
            view.menuRegistroUsuario();
            opcion ++;
        }while (opcion <2);

    }
}
