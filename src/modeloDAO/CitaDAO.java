package modeloDAO;

import Interfaces.CitaInterface;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cita;
import modelo.Doctor;
import modelo.EspecialidadDoctor;
import modelo.Paciente;

public class CitaDAO implements CitaInterface {

    Connection conn;
    Conexion con = new Conexion();
    Statement st;
    PreparedStatement ps;
    ResultSet rs;

    //CITA
    Cita a;
    ArrayList<Cita> lista = new ArrayList<>();

    //Doctor
    Doctor d;
    DoctorDAO objDoctorDao = new DoctorDAO();

    Paciente p;

    //ESPECIALIDAD
    EspecialidadDoctor e;
    EspecialidadDoctorDAO eDAO = new EspecialidadDoctorDAO();

    //
    PacienteDAO pDAO = new PacienteDAO();

    @Override
    public boolean agregar(Cita a) {
        try {
            String sql = "insert into cita (PACIENTE_DNI, PAGO, DESCUENTO, "
                    + "MOTIVO_CONSULTA, CODIGO_DOCTOR, CODIGO_HORARIO) "
                    + "values (?,?,?,?,?,?)";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, a.getPac().getDni());
            ps.setDouble(2, a.getPago());
            ps.setDouble(3, a.getDescuento());
            ps.setString(4, a.getMotivoConsulta());
            ps.setString(5, a.getDoc().getCODIGO_DOCTOR());
            ps.setString(6, a.getDoc().getCODIGO_HORARIO());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(String codigo) {
        try {
            String sql = "delete from cita where CODIGO_CITA = " + "'" + codigo + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean modificar(Cita a) {
        try {
            String sql = "update cita set PACIENTE_DNI = ?, PAGO = ?, DESCUENTO = ?, "
                    + "MOTIVO_CONSULTA = ?, CODIGO_DOCTOR = ?, CODIGO_HORARIO=? "
                    + "where CODIGO_CITA = " + "'" + a.getCodCita() + "'";

            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
//            ps.setString(1, a.getCodCita());
            ps.setString(1, a.getPac().getDni());
            ps.setDouble(2, a.getPago());
            ps.setDouble(3, a.getDescuento());
            ps.setString(4, a.getMotivoConsulta());
            ps.setString(5, a.getDoc().getCODIGO_DOCTOR());
            ps.setString(6, a.getDoc().getCODIGO_HORARIO());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Cita> listarTodos() {
        try {
            String sql = "SELECT * FROM CITA";  //tal vez haya un error
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new Cita();
                a.setCodCita(rs.getString("CODIGO_CITA"));
                //PARA PACIENTE
                String c = rs.getString("PACIENTE_DNI");
                p = pDAO.listarUno(c);
                a.setPac(p);
                a.setPago(rs.getDouble("PAGO"));
                a.setDescuento(rs.getDouble("DESCUENTO"));
                a.setMotivoConsulta(rs.getString("MOTIVO_CONSULTA"));
                String cod = rs.getString("CODIGO_HORARIO");
                d = objDoctorDao.listaHoarario(cod);
                a.setDoc(d);

                lista.add(a);
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public Cita listarUno(String codigo) {
        try {
            String sql = "SELECT * FROM CITA where CODIGO_CITA = " + "'" + codigo + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                a.setCodCita(rs.getString("CODIGO_CITA"));
                //PARA PACIENTE
                String c = rs.getString("PACIENTE_DNI");
                p = pDAO.listarUno(c);
                a.setPac(p);
                a.setPago(rs.getDouble("PAGO"));
                a.setDescuento(rs.getDouble("DESCUENTO"));
                a.setMotivoConsulta(rs.getString("MOTIVO_CONSULTA"));
                String cod = rs.getString("CODIGO_HORARIO");
                d = objDoctorDao.listaHoarario(cod);
                a.setDoc(d);

            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

}
