package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection conn;
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bdproyectofinal", "root", "");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return conn;
    }
}
