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

//para ver el historial de tareas
public class TareaHistorial extends Tarea {
    final TareaClass tareaClass;//establecer que tarea esta haciendo referencia

    public TareaHistorial(TareaClass tareaClass) {
        this.tareaClass = tareaClass;
        actividadText.setEditable(false);//false porque es el historial
        actividadText.setText(tareaClass.actividad);
        fechaSpinner.setEnabled(false);
        fechaSpinner.setValue(new Date(tareaClass.fecha));// establecer el valor del spinner
        eliminarButton.setVisible(false);//para desaparecer el boton
        terminarButton.setVisible(true);
        terminarButton.setText("Reactivar");
    }
    
    
}
