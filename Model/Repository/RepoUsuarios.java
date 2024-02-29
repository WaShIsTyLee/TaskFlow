package Model.Repository;

import Model.Entitys.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RepoUsuarios extends Repository{
    List<Usuario> usuarios;
    private RepoUsuarios(){}

    public void addUsuario(Usuario usuario){
        if(usuarios==null){
            usuarios=new ArrayList<>();
        }
        usuarios.add(usuario);
    }
    public static RepoUsuarios getInstance(){
        if(_instance==null){
            _instance=new RepoUsuarios();
        }
        return (RepoUsuarios) _instance;
    }
    //CRUD


    public List<Usuario> getUsuarios(){
        return usuarios;
    }

}
