package Interfaces;

import java.util.ArrayList;
import modelo.Doctor;

public interface DoctorInterface{
    
    public boolean agregar(Doctor a);
    public boolean eliminar(String dni,String codigo);
    public boolean modificar(Doctor a);
    public ArrayList<Doctor> listarTodos();
    public  ArrayList<Doctor> listarUno(String codigo);

    

}
