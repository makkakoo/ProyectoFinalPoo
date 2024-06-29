package Interfaces;

import java.util.ArrayList;

public interface CRUD <T>{
    public boolean agregar(T a);
    public boolean eliminar(String codigo);
    public boolean modificar(T a);
    public ArrayList<T> listarTodos();
    public T listarUno(String codigo);
}
