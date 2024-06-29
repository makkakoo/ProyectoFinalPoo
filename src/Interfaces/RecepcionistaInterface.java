package Interfaces;

import modelo.Recepcionista;


public interface RecepcionistaInterface extends CRUD<Recepcionista>{
    public Recepcionista validarLogueo(String codRecepcionista, String contraRecepcionista);
}
