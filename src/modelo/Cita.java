package modelo;

public class Cita {
    private double pago = 0;
    private double descuento = 0;
    private String motivoConsulta;
    private String codCita;
    
    private Doctor Doc;
    private Paciente Pac;
    
    
    public double descuento(Paciente p, EspecialidadDoctor e){
        
        switch(p.getTipoSeguro()){
            case "Completo": descuento = e.getTarifa(); break;
            case "Parcial": descuento = e.getTarifa() * 0.5; break;
            case "No tiene": descuento = 0.00; break;
        }
        return descuento;
    
    }
    
    public double calcularPago( EspecialidadDoctor e){
        double tarifa = e.getTarifa();
        pago = tarifa - descuento;
        return pago;
        
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }


    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getCodCita() {
        return codCita;
    }

    public void setCodCita(String codCita) {
        this.codCita = codCita;
    }

    public Doctor getDoc() {
        return Doc;
    }

    public void setDoc(Doctor Doc) {
        this.Doc = Doc;
    }

    public Paciente getPac() {
        return Pac;
    }

    public void setPac(Paciente Pac) {
        this.Pac = Pac;
    }
    
    
}
