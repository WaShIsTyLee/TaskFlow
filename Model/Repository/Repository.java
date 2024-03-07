package Model.Repository;

import Model.Serializador.Serializador;

import java.io.Serial;
import java.io.Serializable;

public class Repository implements Serializable {
    /**
     * Serial sirve para que cuando serializemos desde varias versiones no nos de un error,
     * le añadimos un numero serializable y debera serializar sobre este numero
     */
    @Serial
    private static final long serialVersionUID = 1L;

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
        return Serializador.serialize(this,filename);
    }
    public static Repository load(String filename){
       return Serializador.deserializer(filename);
    }

}
