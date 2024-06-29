package modeloDAO;

import config.Conexion;
import Interfaces.RecepcionistaInterface;
import java.util.ArrayList;
import modelo.Recepcionista;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecepcionistaDAO implements RecepcionistaInterface {

    Connection conn;
    Conexion con = new Conexion();
    Recepcionista r;
    PreparedStatement ps;
    Statement s;
    ResultSet rs;

    @Override
    public Recepcionista validarLogueo(String codRecepcionista, String contraRecepcionista) {

        try {
            String sql = "select * from Recepcionista where recepCod =" + "'" + codRecepcionista + "'" + "and codRecep =" + "'" + contraRecepcionista + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                r = new Recepcionista();
                r.setCodRecepcionista(rs.getString("recepCod"));
                r.setContraRecepcionista(rs.getString("codRecep"));

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RecepcionistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public boolean agregar(Recepcionista a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modificar(Recepcionista a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Recepcionista> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Recepcionista listarUno(String cod_recep) {
        try {
            String sql = "select p.*, RecepCod from persona p join recepcionista r ON\n"
                    + "p.DNI = r.DNI where RecepCod = '" + cod_recep + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                r = new Recepcionista();
                r.setDni(rs.getString("DNI"));
                r.setNombre(rs.getString("NOMBRE"));
              
                r.setApellido(rs.getString("APELLIDO"));
                r.setCelular(rs.getString("CELULAR"));
                r.setCorreo(rs.getString("CORREO"));
                r.setDireccion(rs.getString("DIRECCION"));
                r.setEdad(Integer.parseInt(rs.getString("EDAD")));
                r.setCodRecepcionista(rs.getString("RECEPCOD"));

            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

}
