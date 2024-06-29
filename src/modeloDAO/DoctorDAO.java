package modeloDAO;

import Interfaces.DoctorInterface;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Doctor;
import modelo.EspecialidadDoctor;

public class DoctorDAO implements DoctorInterface {

    Connection conn;
    Conexion con = new Conexion();
    Doctor d;

    EspecialidadDoctor objEspe;
    EspecialidadDoctorDAO objEspeDAO = new EspecialidadDoctorDAO();

    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    ArrayList<Doctor> lista = new ArrayList<>();

    @Override
    public boolean agregar(Doctor a) {
        try {
            String sql = "insert into persona (DNI, NOMBRE, APELLIDO, CELULAR, CORREO, DIRECCION, EDAD) "
                    + "values (?,?,?,?,?,?, ?) ";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            //PARA INGRESAR LOS DATOS BAJO LA SENTENCIA SQL
            ps.setString(1, a.getDni());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getApellido());
            ps.setString(4, a.getCelular());
            ps.setString(5, a.getCorreo());
            ps.setString(6, a.getDireccion());
            ps.setInt(7, a.getEdad());

            //EJECUTAR LOS VALORES
            ps.executeUpdate();

            String sq2 = "insert into doctor (CODIGO_DOCTOR, Persona_DNI, CODIGO_ESPE) "
                    + "values (?,?,?) ";
            ps = conn.prepareStatement(sq2);
            //PARA INGRESAR LOS DATOS BAJO LA SENTENCIA SQL
            ps.setString(1, a.getCODIGO_DOCTOR());
            ps.setString(2, a.getDni());
            ps.setString(3, a.getObjEspe().getCodEspe());

            //EJECUTAR LOS VALORES
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean agregarSoloTablaDoctorTurno(Doctor a) {
        try {
            String sq3 = "insert into doctor_turno (CODIGO_DOCTOR, FECHA, CUPOS, TURNO) "
                    + "values (?,?,?,?) ";
            ps = conn.prepareStatement(sq3);
            //PARA INGRESAR LOS DATOS BAJO LA SENTENCIA SQL
            ps.setString(1, a.getCODIGO_DOCTOR());
            ps.setString(2, a.getFecha());
            ps.setInt(3, a.getCupos());
            ps.setString(4, a.getTurno());

            //EJECUTAR LOS VALORES
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(String dni, String codigo_DOCTOR) {
        try {

            // ELIMINANDO DE DOCTOR_TURNO
            String sql3 = "DELETE from doctor_turno where CODIGO_DOCTOR = '" + codigo_DOCTOR + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql3);
            ps.executeUpdate();

            // ELIMINANDO DE DOCTOR
            String sql2 = "DELETE FROM doctor WHERE PERSONA_DNI = ?";
            ps = conn.prepareStatement(sql2);
            ps.setString(1, dni);
            ps.executeUpdate();

            // ELIMINANDO DE PERSONA
            String sql = "DELETE FROM persona WHERE DNI = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dni);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean modificar(Doctor d) {
        try {

            String sq3 = "update doctor_turno set FECHA = ?, "
                    + " TURNO = ? where CODIGO_HORARIO  = '" + d.getCODIGO_HORARIO() + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sq3);
            ps.setString(1, d.getFecha());
            ps.setString(2, d.getTurno());
            ps.executeUpdate();

            String sq2 = "update doctor set Persona_DNI =?,"
                    + " CODIGO_ESPE=? where CODIGO_DOCTOR = '" + d.getCODIGO_DOCTOR() + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sq2);
            ps.setString(1, d.getDni());
            ps.setString(2, d.getObjEspe().getCodEspe());
            ps.executeUpdate();

            String sql = "UPDATE persona p JOIN doctor d ON p.DNI = d.Persona_DNI "
                    + "SET p.dni = ?, p.nombre = ?, p.apellido = ?, p.celular = ?, p.correo = ?"
                    + ", p.direccion = ?, p.edad = ? WHERE d.CODIGO_DOCTOR = '" + d.getCODIGO_DOCTOR() + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, d.getDni());
            ps.setString(2, d.getNombre());
            ps.setString(3, d.getApellido());
            ps.setString(4, d.getCelular());
            ps.setString(5, d.getCorreo());
            ps.setString(6, d.getDireccion());
            ps.setInt(7, d.getEdad());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Doctor> listarTodos() {
        try {
            String sql = "SELECT p.*, d.*, dt.* FROM persona p JOIN doctor d ON p.DNI = d.Persona_DNI "
                    + "JOIN doctor_turno dt  ON d.CODIGO_DOCTOR = dt.CODIGO_DOCTOR; ";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                d = new Doctor();
                //TABLA PERSONA
                d.setCODIGO_DOCTOR(rs.getString("CODIGO_DOCTOR"));
                d.setDni(rs.getString("dni"));
                d.setNombre(rs.getString("nombre"));
                d.setApellido(rs.getString("apellido"));
                d.setCelular(rs.getString("celular"));
                d.setCorreo(rs.getString("correo"));
                d.setDireccion(rs.getString("direccion"));
                d.setEdad(rs.getInt("edad"));

                // Obtener el objeto Especialidad
                String c = rs.getString("CODIGO_ESPE");
                objEspe = objEspeDAO.listarUno(c);
                d.setObjEspe(objEspe);

                //tabla doctor_turno
                d.setCODIGO_HORARIO(rs.getString("CODIGO_HORARIO"));
                d.setFecha(rs.getString("FECHA"));
                d.setCupos(rs.getInt("CUPOS"));
                d.setTurno(rs.getString("TURNO"));

                lista.add(d);
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public ArrayList<Doctor> listarUno(String dni) {
        try {
            String sql = "SELECT p.*, d.*, dt.* FROM persona p JOIN doctor d ON p.DNI = d.Persona_DNI "
                    + "JOIN doctor_turno dt  ON d.CODIGO_DOCTOR = dt.CODIGO_DOCTOR WHERE DNI = '" + dni + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                d = new Doctor();
                d.setCODIGO_DOCTOR(rs.getString("CODIGO_DOCTOR"));
                d.setDni(rs.getString("dni"));
                d.setNombre(rs.getString("nombre"));
                d.setApellido(rs.getString("apellido"));
                d.setCelular(rs.getString("celular"));
                d.setCorreo(rs.getString("correo"));
                d.setDireccion(rs.getString("direccion"));
                d.setEdad(rs.getInt("edad"));

                // Obtener el objeto Especialidad
                String c = rs.getString("CODIGO_ESPE");
                objEspe = objEspeDAO.listarUno(c);
                d.setObjEspe(objEspe);

//                  Obtener la fecha y el código del turno
                d.setCODIGO_HORARIO(rs.getString("CODIGO_HORARIO"));
                d.setFecha(rs.getString("FECHA"));
                d.setCupos(rs.getInt("CUPOS"));
                d.setTurno(rs.getString("TURNO"));

                lista.add(d);
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<Doctor> todosDoctoresSinDuplicar() {
        try {
            String sql = "SELECT p.*, CODIGO_DOCTOR, CODIGO_ESPE FROM persona p "
                    + "JOIN doctor d ON p.dni = d.Persona_DNI ";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                d = new Doctor();
                d.setDni(rs.getString("DNI"));
                d.setNombre(rs.getString("NOMBRE"));
                d.setApellido(rs.getString("APELLIDO"));
                d.setCelular(rs.getString("celular"));
                d.setCorreo(rs.getString("correo"));
                d.setDireccion(rs.getString("direccion"));
                d.setEdad(rs.getInt("edad"));
                d.setCODIGO_DOCTOR(rs.getString("CODIGO_DOCTOR"));
                // Obtener el objeto Especialidad
                String c = rs.getString("CODIGO_ESPE");
                objEspe = objEspeDAO.listarUno(c);
                d.setObjEspe(objEspe);

                lista.add(d);
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Doctor unDoctorSinDuplicar(String cod_horario) {
        try {
            String sql = "SELECT p.*, CODIGO_DOCTOR, CODIGO_ESPE FROM persona p "
                    + "JOIN doctor d ON p.dni = d.Persona_DNI where CODIGO_DOCTOR = '" + cod_horario + "";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                d = new Doctor();
                d.setDni(rs.getString("DNI"));
                d.setNombre(rs.getString("NOMBRE"));
                d.setApellido(rs.getString("APELLIDO"));
                d.setCelular(rs.getString("celular"));
                d.setCorreo(rs.getString("correo"));
                d.setDireccion(rs.getString("direccion"));
                d.setEdad(rs.getInt("edad"));
                d.setCODIGO_DOCTOR(rs.getString("CODIGO_DOCTOR"));
                // Obtener el objeto Especialidad
                String c = rs.getString("CODIGO_ESPE");
                objEspe = objEspeDAO.listarUno(c);
                d.setObjEspe(objEspe);

            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public Doctor nuevoCod(Doctor a) {
        try {
            String sql = "SELECT codGeneradoDoctor()";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                String codigoDoc = rs.getString(1);
                a.setCODIGO_DOCTOR(codigoDoc);

            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    //LISTAR TODOS LOS HORARIOS
    public Doctor listarHorarioPorDoctor(String codigo_doctor, String fecha, String turno) {
        try {
            String sql = "SELECT * from doctor_turno where CODIGO_DOCTOR = '" + codigo_doctor
                    + "' and FECHA = '" + fecha + "' and turno = '" + turno + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                d = new Doctor();
                d.setCODIGO_HORARIO(rs.getString("CODIGO_HORARIO"));
                d.setCODIGO_DOCTOR(rs.getString("CODIGO_DOCTOR"));
                d.setFecha(rs.getString("FECHA"));
                d.setCupos(rs.getInt("CUPOS"));
                d.setTurno(rs.getString("TURNO"));

            }


        } catch (SQLException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public Doctor listaUnicoDoctorPorEspecialidad(String codigo_doctor, String fecha, String turno) {
        try {
            String sql = "SELECT p.*, d.CODIGO_DOCTOR, d.CODIGO_ESPE, dt.CODIGO_HORARIO, dt.FECHA, dt.CUPOS, dt.TURNO from persona p join doctor d ON\n"
                    + "p.DNI = d.Persona_DNI join doctor_turno dt ON\n"
                    + "d.CODIGO_DOCTOR = dt.CODIGO_DOCTOR where fecha = '" + fecha + "' and turno = '" + turno + "' and d.CODIGO_DOCTOR = '" + codigo_doctor + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                d = new Doctor();

                d.setDni(rs.getString("DNI"));
                d.setNombre(rs.getString("NOMBRE"));
                d.setApellido(rs.getString("APELLIDO"));
                d.setCelular(rs.getString("celular"));
                d.setCorreo(rs.getString("correo"));
                d.setDireccion(rs.getString("direccion"));
                d.setEdad(rs.getInt("edad"));

                d.setCODIGO_HORARIO(rs.getString("CODIGO_HORARIO"));
                d.setCODIGO_DOCTOR(rs.getString("CODIGO_DOCTOR"));
                d.setFecha(rs.getString("FECHA"));
                d.setCupos(rs.getInt("CUPOS"));
                d.setTurno(rs.getString("TURNO"));

            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public ArrayList<Doctor> DoctorFiltradoPorEspe(String cod_espe) {
        try {
            String sql = "SELECT p.*, nombre, apellido FROM doctor p join persona a\n"
                    + "on p.Persona_DNI = a.DNI where codigo_Espe = '" + cod_espe + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                d = new Doctor();
                d.setCODIGO_DOCTOR(rs.getString("CODIGO_DOCTOR"));
                d.setDni(rs.getString("Persona_DNI"));
                String c = rs.getString("CODIGO_ESPE");
                objEspe = objEspeDAO.listarUno(c);
                d.setObjEspe(objEspe);
                d.setNombre(rs.getString("NOMBRE"));
                //linea antosisocial
                d.setApellido(rs.getString("APELLIDO"));
                lista.add(d);
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<Doctor> fechaUnDoctorSinRepetir(String cod_doctor) {
        try {
            String sql = "SELECT DISTINCT FECHA, CODIGO_DOCTOR FROM DOCTOR_TURNO\n"
                    + "WHERE CODIGO_DOCTOR = \n"
                    + " '" + cod_doctor + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                d = new Doctor();
                d.setCODIGO_DOCTOR(rs.getString("CODIGO_DOCTOR"));
                d.setFecha(rs.getString("FECHA"));
                lista.add(d);
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<Doctor> todaLaTablaDoctor_turno(String cod_doctor, String fecha) {
        try {
            String sql = "select * from doctor_turno where FECHA = '" + fecha + " ' and CODIGO_DOCTOR = '" + cod_doctor + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                d = new Doctor();
                d.setCODIGO_HORARIO(rs.getString("CODIGO_HORARIO"));
                d.setCODIGO_DOCTOR(rs.getString("CODIGO_DOCTOR"));
                d.setFecha(rs.getString("FECHA"));
                d.setCupos(Integer.parseInt(rs.getString("CUPOS")));
                d.setTurno(rs.getString("TURNO"));
                lista.add(d);
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Doctor listaHoarario(String codigo_horario) {
        try {
            String sql = "select p.*, d.*, dt.* from doctor_turno dt join doctor d ON\n"
                    + "dt.CODIGO_DOCTOR = d.CODIGO_DOCTOR join persona p \n"
                    + "on p.DNI = d.Persona_DNI where CODIGO_HORARIO = '" + codigo_horario + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                d = new Doctor();
                d.setDni(rs.getString("DNI"));
                d.setNombre(rs.getString("NOMBRE"));
                d.setApellido(rs.getString("APELLIDO"));
                d.setCelular(rs.getString("CELULAR"));
                d.setDireccion(rs.getString("DIRECCION"));
                d.setEdad( Integer.parseInt(rs.getString("EDAD")));
                String c = rs.getString("CODIGO_ESPE");
                objEspe = objEspeDAO.listarUno(c);
                d.setObjEspe(objEspe);
                
                d.setCODIGO_HORARIO(rs.getString("CODIGO_HORARIO"));
                d.setCODIGO_DOCTOR(rs.getString("CODIGO_DOCTOR"));
                d.setFecha(rs.getString("FECHA"));
                d.setCupos(rs.getInt("CUPOS"));
                d.setTurno(rs.getString("TURNO"));

            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

}
