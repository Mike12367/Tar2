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
//visualiza tarea
public class TareaVisualizar extends Tarea {
    final TareaClass tareaClass;

    public TareaVisualizar(TareaClass tareaClass) {
        this.tareaClass = tareaClass;
        actividadText.setEditable(false);//false porque es el historial
        actividadText.setText(tareaClass.actividad);
        fechaSpinner.setEnabled(false);
        fechaSpinner.setValue(new Date(tareaClass.fecha));// establecer el valor del spinner
        eliminarButton.setVisible(true);//muestra la parte de eliminar
        terminarButton.setVisible(true);//muestra parte terminar
        
    }
    
    @Override
    void eliminar(){
        try{
            TareaAcciones.eliminarTarea(TareaClass);// elimina la tarea que queremos eliminar
            tareas.Tareas.principal.eliminarTaraea(This);
        } catch (SQLException ex){
            Logger.getLogger(TareaVisualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    @Override
        void marcar(){// marca las tareas como terminadas
            TareaAcciones.finalizarTarea(tareaClass);
            tareas.Tareas.principal.eliminarTaraea(This);
        
        
        
        }
}
