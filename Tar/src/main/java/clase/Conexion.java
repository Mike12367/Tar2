/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author margv
 */
public class Conexion {
    private static Connection connection;
    public final static Conexion instancia = new Conexion();
    
    public static PreparedStatement PepareStatement(String sql) throws SQLException {
        return prepareStatement(sql);
        
    }
    public static void cerrar() throws SQLException{
        connection.close();
        
        
        
    
    }
    public static PreparedStatement PepareStatement(String sql, boolean b) throws SQLException {
        return connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
}
    private Conexion(){//singleton el constructor se deja privado
        String cadena = "jdbc:sqlite:tareas.db";
        try{
            connection = DriverManager.getConnection(cadena);
            
        } catch (SQLException ex){
        Logger.getLogger(Conexion,class.getName()).log(Level.SEVERE , null, ex);
                
        
        }
    
    
    }
}