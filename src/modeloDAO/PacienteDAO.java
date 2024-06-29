

package modeloDAO;

import Interfaces.PacienteInterface;
import config.Conexion;
import java.util.ArrayList;
import modelo.Paciente;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PacienteDAO implements PacienteInterface{
    Connection conn;
    Conexion con = new Conexion();
    
    Paciente p;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    ArrayList<Paciente> lista = new ArrayList<>();

    @Override
    public boolean agregar(Paciente p) {
        try {
            String sql= "insert into persona (dni, nombre, apellido, celular, correo, direccion, edad) "
                    + "values (?,?,?,?,?,?,?) ";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            //PARA INGRESAR LOS DATOS BAJO LA SENTENCIA SQL
            ps.setString(1,p.getDni());
            ps.setString(2,p.getNombre());
            ps.setString(3,p.getApellido() );
            ps.setString(4,p.getCelular());
            ps.setString(5,p.getCorreo() );
            ps.setString(6,p.getDireccion() );
            ps.setInt(7,p.getEdad());
            
            //EJECUTAR LOS VALORES
            ps.executeUpdate();
            //agregando en otra tabla
            String sql2 = "Insert into paciente(TIPO_SEGURO, dni) values (?,?) ";
            ps = conn.prepareStatement(sql2);
            
            ps.setString(1, p.getTipoSeguro());
            ps.setString(2, p.getDni());
            ps.executeUpdate();
              } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(String dni) {
        try {
            
             //ELIMINADO PACIENTE
            String sql2 = "delete from paciente where dni = " + "'"  + dni + "'" ;
            conn = con.getConexion();
            ps = conn.prepareStatement(sql2);
            ps.executeUpdate();
            
            //ELIMINANDO PERSONA
            String sql= "delete from persona where dni = " + "'" + dni+ "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();

           
            
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean modificar(Paciente p) {
        try {
            String sql= "update persona set  nombre =?, apellido=?, celular = ?, correo = ?, "
                    + "direccion = ?, edad = ? where dni = '"+ p.getDni()+"'" ;
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            //PARA INGRESAR LOS DATOS BAJO LA SENTENCIA SQL
            ps.setString(1,p.getNombre());
            ps.setString(2,p.getApellido() );
            ps.setString(3,p.getCelular());
            ps.setString(4,p.getCorreo() );
            ps.setString(5,p.getDireccion() );
            ps.setInt(6,p.getEdad());
            ps.executeUpdate();
            
            //MODIFICANDO TABLA 
            
            String sql2 = "update paciente set TIPO_SEGURO  = ?  "
                    + "where DNI = " + "'"+ p.getDni()+"'";
            ps = conn.prepareStatement(sql2);
            
            ps.setString(1, p.getTipoSeguro());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Paciente> listarTodos() {
        try {
            String sql= "SELECT pe.*, pa.TIPO_SEGURO from persona pe join paciente pa "
                    + "on pe.DNI = pa.DNI ";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Paciente();
                p.setDni(rs.getString("dni"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setTipoSeguro(rs.getString("TIPO_SEGURO"));
                p.setCelular(rs.getString("celular"));
                p.setCorreo(rs.getString("correo"));
                p.setDireccion(rs.getString("direccion"));
                p.setEdad(rs.getInt("edad"));

                lista.add(p);
    
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

        
    }

    @Override
    public Paciente listarUno(String dni) {
        try {
            String sql= "SELECT pe.*, pa.TIPO_SEGURO from persona pe join "
                    + "paciente pa on pe.DNI = pa.DNI  where pe.DNI = " + "'" + dni + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Paciente();
                p.setDni(rs.getString("dni"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setTipoSeguro(rs.getString("TIPO_SEGURO"));
                p.setCelular(rs.getString("celular"));
                p.setCorreo(rs.getString("correo"));
                p.setDireccion(rs.getString("direccion"));
                p.setEdad(rs.getInt("edad"));
    
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
}
