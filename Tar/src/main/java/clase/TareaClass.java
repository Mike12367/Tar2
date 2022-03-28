/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

/**
 *
 * @author margv
 */
public class TareaClass {
    long tareaID;
    public final long fecha;
    public final String actividad;// como se llama en la base de datos

    public TareaClass(long fecha, String actividad) {
        this.fecha = fecha;
        this.actividad = actividad;
    }

    public TareaClass(long tareaID, long fecha, String actividad) {
        this.tareaID = tareaID;
        this.fecha = fecha;
        this.actividad = actividad;
    }
    public void setID(long tareaID){
    this.tareaID = tareaID;
}
    public long getID(){
        return tareaID;
}
}
