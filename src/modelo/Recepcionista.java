
package modelo;

public class Recepcionista extends Persona{
    
    private String codRecepcionista;
    private String contraRecepcionista;

    public String getContraRecepcionista() {
        return contraRecepcionista;
    }

    public void setContraRecepcionista(String contraRecepcionista) {
        this.contraRecepcionista = contraRecepcionista;
    }
   

    public String getCodRecepcionista() {
        return codRecepcionista;
    }

    public void setCodRecepcionista(String codRecepcionista) {
        this.codRecepcionista = codRecepcionista;
    }
    
}
