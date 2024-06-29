package modeloDAO;

import Interfaces.EspecialidadInterface;
import config.Conexion;
import java.util.ArrayList;
import modelo.EspecialidadDoctor;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EspecialidadDoctorDAO implements EspecialidadInterface {

    Connection conn;
    Conexion con = new Conexion();
    PreparedStatement ps;
    EspecialidadDoctor a;
    ResultSet rs;

    ArrayList<EspecialidadDoctor> lista = new ArrayList<>();

    @Override
    public boolean agregar(EspecialidadDoctor a) {
        try {
            String sql = "insert into especialidad (CODIGO_ESPE, NOMBRE_ESPECIALIDAD, TARIFA) "
                    + "values (?,?,?) ";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            //PARA INGRESAR LOS DATOS BAJO LA SENTENCIA SQL
            ps.setString(1, a.getCodEspe());
            ps.setString(2, a.getNomEspe());
            ps.setDouble(3, a.getTarifa());
            //EJECUTAR LOS VALORES
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(String codigo) {
        try {
            String sql = "delete from especialidad where CODIGO_ESPE= " + "'" + codigo + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean modificar(EspecialidadDoctor a) {
        try {
            String sql = "UPDATE especialidad SET NOMBRE_ESPECIALIDAD = ?, TARIFA = ? WHERE CODIGO_ESPE = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, a.getNomEspe());
            ps.setDouble(2, a.getTarifa());
            ps.setString(3, a.getCodEspe());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<EspecialidadDoctor> listarTodos() {
        try {
            String sql = "select * from especialidad";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new EspecialidadDoctor();
                a.setCodEspe(rs.getString("CODIGO_ESPE"));
                a.setNomEspe(rs.getString("NOMBRE_ESPECIALIDAD"));
                a.setTarifa(rs.getDouble("TARIFA"));
                lista.add(a);

            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<EspecialidadDoctor> especialidadesQueContenganDoctor() {
        try {
            String sql = "SELECT DISTINCT e.CODIGO_ESPE, e.NOMBRE_ESPECIALIDAD, e.TARIFA\n"
                    + "FROM ESPECIALIDAD e\n"
                    + "INNER JOIN DOCTOR d ON e.CODIGO_ESPE = d.CODIGO_ESPE;";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new EspecialidadDoctor();
                a.setCodEspe(rs.getString("CODIGO_ESPE"));
                a.setNomEspe(rs.getString("NOMBRE_ESPECIALIDAD"));
                a.setTarifa(rs.getDouble("TARIFA"));
                lista.add(a);

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public EspecialidadDoctor listarUno(String codigo) {
        try {
            String sql = "select * from especialidad where CODIGO_ESPE = " + "'" + codigo + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new EspecialidadDoctor();
                a.setCodEspe(rs.getString("CODIGO_ESPE"));
                a.setNomEspe(rs.getString("NOMBRE_ESPECIALIDAD"));
                a.setTarifa(rs.getDouble("TARIFA"));

            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

}
