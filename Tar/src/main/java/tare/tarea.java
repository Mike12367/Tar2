/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tare;
import gu.*;
/**
 *
 * @author margv
 */
public class tarea {
   public static Principal principal;// se usa desde varios lugares diferentes
    
    public static void main(String[] args) {
        principal = new Principal();
        principal.setVisible(true);
        principal.requestFocus();
        
        
    }
}
