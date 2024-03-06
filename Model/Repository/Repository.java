package Model.Repository;

import Model.Serializador.Serializador;

import java.io.Serializable;

public class Repository implements Serializable {
    protected static Repository _instance;
    protected Repository(){
    }
    public static Repository getInstance(){
        if(_instance==null){
            _instance=new Repository();
        }
        return _instance;
    }

    public boolean save(String filename){
        System.out.println(this.getClass());
        return Serializador.serialize(this,filename);
    }
    public static Repository load(String filename){
       return Serializador.deserializer(filename);
    }

}
