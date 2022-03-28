/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acci;
import clase.TareaClass;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Exception;
/**
 *
 * @author margv
 */
public class TareaAcciones {
    public static void guardarTarea(TareaClass tareaClass){//se va a usar esta clase como una clse de datos
        long id = insertarTarea(tareaClass);
        tareaClass.setID(id);//pone a la tarea el id que acaba de agarrar
    }
    static private long insertarTarea(TareaClass tareaClass){
        String sql = "insert into tareas (fecha, actividad)" +"values(?,?)";
       PreparedStatement ps = Conexion.PepareStatement(sql);
       ps.setLong(1, tareaClass.fecha);
       ps.setString(2, tareaClass.actividad);//actividad que va a tener
       int id = 0;
       ps.execute();
       sql = "select last_insert_rowid();";
       ps = Conexion.PepareStatement(sql, true);
       ResultSet rs = ps.executeQuery();
       if(rs.next()){
           id = rs.getInt(1);     
       }
       return id;
    
    }
    public static ArrayList<TareaClass> obtenerTareas throws SQLException(){ 
       String sql = "select tarea_id, fecha, actividad from tareas order by fecha";// da prioridad a fecha
       PreparedStatement ps = Conexion.PepareStatement(sql);
       ArrayList<TareaClass> list = new ArrayList<>();
       try(ResultSet rs = ps executeQuery()){//dice el recurso a tomar y solo completa y cierra el resultset
           while(rs.next()){
               long id = rs.getLong("tarea_id");
               long fecha = rs.getLong("fecha");//para la fecha
               String actividad = rs.getString("actividad");
               TareaClass tareaclass = new TareaClass(id, fecha, actividad);
               list.add(tareaClass); 
           }
       
       }
       return list;//regresa el valor que se toma
    }
       public static void eliminarTarea(TareaClass tareaClass){
           String sql = "delete from tareas where tarea_id = ?"
           PreparedStatement ps = Conexion.PepareStatement(sql);
           ps.setLong(1, tareaClass.getID());
           ps.execute();
           
       }
       public static void finalizarTarea(TareaClass tareaClass ){
           insertarTareaHistorial(tareaClass);
           eliminarTarea(tareaClass);
       
       
       }
       
       public static void insertarTareaHistorial(TareaClass tareaClass) throws SQLException{
            String sql = "insert into historial (tarea_id, fecha, actividad)"
                    + "values(?,?,?);";
            PreparedStatement ps = Conexion.PepareStatement(sql);
            ps.setLong(1, tareaClass.getID());
            ps.setLong(2, tareaClass.fecha);
            ps.setString(3, tareaClass.actividad);//actividad que va a tener
            int id = 0;
            ps.execute();
       
       }
}
    
