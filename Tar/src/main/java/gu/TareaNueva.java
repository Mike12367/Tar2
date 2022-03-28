/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gu;
import clase.TareaClass;
import java.util.Date;
/**
 *
 * @author margv
 */

//crea nueva tarea
public class TareaNueva extends Tarea {

    public TareaNueva() {
        actividadText.setEnabled(true);
        actividadText.setText("");//vacia texto
        fechaSpinner.setEnabled(true);
        eliminarButton.setVisible(false);//para desaparecer el boton
        terminarButton.setVisible(false);//para desaparecer el boton

        
    }
    TareaClass getTareaClass(){
        Date fecha = fechaSpinner.getValue();
        String actividad = actividadText.getText();
        TareaClass tareaClass = new TareaClass(fecha.getTime(), actividad);
        return tareaClass;
    }
}
