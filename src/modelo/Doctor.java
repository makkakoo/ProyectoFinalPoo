package modelo;

public class Doctor extends Persona{
    private String CODIGO_DOCTOR;
    private String fecha;
    private String turno;
    private int cupos;
    private EspecialidadDoctor objEspe;
    
    private String CODIGO_HORARIO;

    public String getCODIGO_DOCTOR() {
        return CODIGO_DOCTOR;
    }

    public void setCODIGO_DOCTOR(String CODIGO_DOCTOR) {
        this.CODIGO_DOCTOR = CODIGO_DOCTOR;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public EspecialidadDoctor getObjEspe() {
        return objEspe;
    }

    public void setObjEspe(EspecialidadDoctor objEspe) {
        this.objEspe = objEspe;
    }

    public String getCODIGO_HORARIO() {
        return CODIGO_HORARIO;
    }

    public void setCODIGO_HORARIO(String CODIGO_HORARIO) {
        this.CODIGO_HORARIO = CODIGO_HORARIO;
    }
    
}
